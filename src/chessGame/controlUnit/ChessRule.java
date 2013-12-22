package chessGame.controlUnit;

import java.awt.event.MouseEvent;

import abstractGame.chessGame.AbstractChessBoardFactory;
import chessGame.data.LocationPoint;
import chessGame.data.chess.Chess;
import chessGame.data.chess.ChessView;
import chessGame.frame.InfoFrame;

public class ChessRule {

	static final int chinessChess = 1;
	static final int taiwanChess = 0;
	static final int red = 0;
	static final int black = 1;
	private int redChessNum = 16;
	private int blackChessNum = 16;
	private int taiwanOrderCnt = 0;

	public boolean moveToNoAction(ChessView chess, int toX, int toY) {

		if (chess.isChessCover()) {
			return false;
		}

		if (chess.getData().getGameStatus().getChessStatus().getWhichOrder() != chess.getColor()) {
			return false;
		}

		if (kingIsLookEach(chess, toX, toY)) {
			if (canMove(chess, toX, toY)) {
				if (haveTarget(chess, toX, toY)) {
					if (canEat(chess, toX, toY)) {
						if (chess.getColor() != chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getColor()) {
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return true;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean moveTo(ChessView chess, AbstractChessBoardFactory abstractChessBoard, int toX, int toY) {
		System.out.println("to XY " + toX + " : " + toY);
		int infoLocX = abstractChessBoard.getLocation().x + (abstractChessBoard.getWidth() / 2) - 200;
		int infoLocY = abstractChessBoard.getLocation().y + (abstractChessBoard.getHeight() / 2) - 100;

		if (chess.isChessCover()) {
			System.out.println("Chess need to take cover");
			new InfoFrame("請先翻棋", infoLocX, infoLocY);
			moveBack(chess);
			return false;
		}

		// check player order
		if (!chess.isChessCover()) {
			if (chess.getData().getGameStatus().getChessStatus().getWhichOrder() != chess.getColor()) {
				// (move back)
				new InfoFrame("換對手下", infoLocX, infoLocY);
				System.out.println("turn " + chess.getData().getGameStatus().getChessStatus().getWhichOrder() + " to chess");
				moveBack(chess);
				return false;
			}
		}

		if (kingIsLookEach(chess, toX, toY)) {
			if (canMove(chess, toX, toY)) {
				if (haveTarget(chess, toX, toY)) {
					if (canEat(chess, toX, toY)) {
						if (chess.getColor() != chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getColor()) {
//							abstractChessBoard.setInfotAreaText(chess.getName() + " 吃掉  " + chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getName());

							System.out.println(chess.getName() + " eat " + chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getName());
							if (chess.getData().getGameStatus().getChessStatus().getWhichOrder() == 0) {
								chess.getData().getGameStatus().getChessRecord()
										.record("紅" + chess.getChineseName() + " 移動 [" + chess.getChessX() + "," + chess.getChessY() + "] 到 [" + toX + "," + toY + "] 吃掉  " + "黑" + chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getChineseName());
							} else {
								chess.getData().getGameStatus().getChessRecord()
										.record("黑" + chess.getChineseName() + " 移動 [" + chess.getChessX() + "," + chess.getChessY() + "] 到 [" + toX + "," + toY + "] 吃掉  " + "紅" + chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getChineseName());
							}
							abstractChessBoard.setInfotAreaText(chess.getData().getGameStatus().getChessRecord().recordToString());
							eatChess(chess, abstractChessBoard, toX, toY);
							System.out.print("999999999999999\n");
//							System.out.println(chess.getData().getGameStatus().getChessRecord().getListRecord().size());
//							chess.getData().getGameStatus().getChessList().print();
//							chess.getData().getGameStatus().getChessList().print();
							Chess[][] tmp;
							if (chess.getData().getGameStatus().getChessStatus().getWhichGame() == 1) {
								tmp = new Chess[10][9];
								for (int i = 0; i < 10; i++) {
									for (int j = 0; j < 9; j++) {
										tmp[i][j] = chess.getData().getGameStatus().getChessList().getChessList()[i][j];
									}
								}
							} else {
								tmp = new Chess[4][8];
								for (int i = 0; i < 4; i++) {
									for (int j = 0; j < 8; j++) {
										tmp[i][j] = chess.getData().getGameStatus().getChessList().getChessList()[i][j];
									}
								}
							}
							chess.getData().getGameStatus().getChessRecord().recordList(tmp, chess.getData().getGameStatus().getChessStatus().getWhichGame());
							swapUserOrder(chess, abstractChessBoard);
							return true;
						} else {
							// (move back) can't eat same color
							new InfoFrame("不能吃自己的棋子", infoLocX, infoLocY);
							System.out.println(chess.getColor() + chess.getName() + "[" + chess.getChessX() + "," + chess.getChessY() + "]" + "can't eat sam color " + chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getName());
							moveBack(chess);
							return false;
						}
					} else {
						// (move back) can't eat
						new InfoFrame("你無法吃這顆棋子", infoLocX, infoLocY);
						System.out.println(chess.getName() + "[" + chess.getChessX() + "," + chess.getChessY() + "]" + "can't eat " + chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getName());
						moveBack(chess);
						return false;
					}
				} else {
//					abstractChessBoard.setInfotAreaText(chess.getName() + " 移動從 [" + chess.getChessX() + "," + chess.getChessY() + "] to [" + toX + "," + toY + "]");

					if (chess.getData().getGameStatus().getChessStatus().getWhichOrder() == 0) {
						chess.getData().getGameStatus().getChessRecord().record("紅" + chess.getChineseName() + " 移動 [" + chess.getChessX() + "," + chess.getChessY() + "] 到 [" + toX + "," + toY + "]");
					} else {
						chess.getData().getGameStatus().getChessRecord().record("黑" + chess.getChineseName() + " 移動 [" + chess.getChessX() + "," + chess.getChessY() + "] 到 [" + toX + "," + toY + "]");
					}
					System.out.println(chess.getName() + " move frome [" + chess.getChessX() + "," + chess.getChessY() + "] to [" + toX + "," + toY + "]");
					chess.getData().getGameStatus().getChessList().getChessList()[toY][toX] = chess.getData().getGameStatus().getChessList().getChessList()[chess.getChessY()][chess.getChessX()];
					chess.getData().getGameStatus().getChessList().getChessList()[chess.getChessY()][chess.getChessX()] = null;
					chess.setChessX(toX);
					chess.setChessY(toY);
					System.out.print("999999999999999\n");
					Chess[][] tmp;
					if (chess.getData().getGameStatus().getChessStatus().getWhichGame() == 1) {
						tmp = new Chess[10][9];
						for (int i = 0; i < 10; i++) {
							for (int j = 0; j < 9; j++) {
								tmp[i][j] = chess.getData().getGameStatus().getChessList().getChessList()[i][j];
							}
						}
					} else {
						tmp = new Chess[4][8];
						for (int i = 0; i < 4; i++) {
							for (int j = 0; j < 8; j++) {
								tmp[i][j] = chess.getData().getGameStatus().getChessList().getChessList()[i][j];
							}
						}
					}
					abstractChessBoard.setInfotAreaText(chess.getData().getGameStatus().getChessRecord().recordToString());
					chess.getData().getGameStatus().getChessRecord().recordList(tmp, chess.getData().getGameStatus().getChessStatus().getWhichGame());
					swapUserOrder(chess, abstractChessBoard);
					return true;
				}
			} else {
				// (move back) can't move to
				if (chess.getChessX() == toX && chess.getChessY() == toY) {

				} else {
					new InfoFrame("無法移動到這個位置", infoLocX, infoLocY);
				}
				System.out.println(chess.getColor() + chess.getName() + "[" + chess.getChessX() + "," + chess.getChessY() + "]" + "can't move to " + "[" + toX + "," + toY + "]");
				moveBack(chess);
				return false;
			}
		} else {
			new InfoFrame("將帥不可對峙", infoLocX, infoLocY);
			System.out.println("King can't look each other");
			moveBack(chess);
			return false;
		}
	}

	private void moveBack(ChessView chess) {
		System.out.println("Back");
		chess.setLocation(chess.getData().getLocMap().getLocationMap()[chess.getChessY()][chess.getChessX()].getX(), chess.getData().getLocMap().getLocationMap()[chess.getChessY()][chess.getChessX()].getY());
	}

//	public void taiwanChessOrder(ChessView chess, GameFrame gameFrame) {
//		if (whichGame == taiwanChess) {
//			if (taiwanOrderCnt > 2) {
//				swapUserOrder(gameFrame);
//			}
//			if (taiwanOrderCnt < 2) {
//				tmp[taiwanOrderCnt] = btnChess;
//				taiwanOrderCnt++;
//			}
//			if (taiwanOrderCnt == 2) {
//				if (tmp[0].getPriority() >= tmp[1].getPriority()) {
//					forWhoToChess = tmp[0].getColor();
//					taiwanOrderCnt++;
//				} else {
//					forWhoToChess = tmp[1].getColor();
//					taiwanOrderCnt++;
//				}
//				if (forWhoToChess == red) {
//					gameFrame.changeLabelText(gameFrame.getUserOrder(), "輪到紅色");
//				} else {
//					gameFrame.changeLabelText(gameFrame.getUserOrder(), "輪到黑色");
//				}
//			}
//		}
//	}

	public void swapUserOrder(ChessView chess, AbstractChessBoardFactory abstractChessBoard) {
		chess.getData().getGameStatus().getChessStatus().setWhichOrder(chess.getData().getGameStatus().getChessStatus().getWhichOrder() ^ 1); // change other side to chess
		if (chess.getData().getGameStatus().getChessStatus().getWhichOrder() == red) {
			abstractChessBoard.getWhichOrder().setText("輪到紅色");
//			gameFrame.changeLabelText(gameFrame.getUserOrder(), "輪到紅色");
		} else {
			abstractChessBoard.getWhichOrder().setText("輪到黑色");
//			gameFrame.changeLabelText(gameFrame.getUserOrder(), "輪到黑色");
		}
	}

	public boolean canEat(ChessView chess, int toX, int toY) {
		if (chess.getData().getGameStatus().getChessStatus().getWhichGame() == chinessChess) {
			return true;
		} else {
			if (chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].isChessCover()) {
				System.out.println("can't eat cover chess");
				return false;
			}
			for (int i = 0; i < chess.getEatRule().length; i++) {
				if (chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getName().equals(chess.getEatRule()[i])) {
					return true;
				}
			}
			return false;
		}
	}

	public boolean haveTarget(ChessView chess, int toX, int toY) {
		if (chess.getData().getGameStatus().getChessList().getChessList()[toY][toX] == null) {
			return false;
		} else {
			return true;
		}
	}

	private boolean canMove(ChessView chess, int toX, int toY) {
		return chess.moveRule(toX, toY);
	}

	private void eatChess(ChessView chess, AbstractChessBoardFactory abstractChessBoard, int toX, int toY) {
		System.out.println("eat start ------------------");
		int infoLocX = abstractChessBoard.getLocation().x + (abstractChessBoard.getWidth() / 2) - 200;
		int infoLocY = abstractChessBoard.getLocation().y + (abstractChessBoard.getHeight() / 2) - 100;

		if (chess.getData().getGameStatus().getChessStatus().getWhichGame() == chinessChess) {
			chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].setLocation(1000, 1000);
			if (chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getName().equals("King")) {
				if (chess.getColor() == red) {
					new InfoFrame("紅色贏了", infoLocX, infoLocY);
					abstractChessBoard.removeChessListener();
				} else {
					new InfoFrame("黑色贏了", infoLocX, infoLocY);
					abstractChessBoard.removeChessListener();
				}
			}
		} else {
//			chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].setLocation(chess.getData().getLocMap().getDeadLocationMap()[0][0].getX(), chess.getData().getLocMap().getDeadLocationMap()[0][0].getY());
			LocationPoint tmp = chess.getData().getLocMap().getDeadLocation();
//			System.out.println("D : " + tmp.getX() + " " + tmp.getY());
			chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].setLocation(tmp.getX(), tmp.getY());
			if (chess.getColor() == red) {
				blackChessNum--;
			} else {
				redChessNum--;
			}
			if (redChessNum == 10) {
				System.out.println("Black WIM");
				abstractChessBoard.removeChessListener();
				new InfoFrame("黑色贏了", infoLocX, infoLocY);
//				new InfoFrame("黑色贏了", "獲勝通知", gameFrame.getLocationOnScreen().x, ((ChineseGameFrame) gameFrame).getLocationOnScreen().y);
//				new InfoFrame("黑色贏了", "獲勝通知", gameFrame.getLocationOnScreen().x + gameFrame.getWidth() / 2 - 200, gameFrame.getLocationOnScreen().y + gameFrame.getHeight() / 2 - 100);
//				gameFrame.removeBtnListener();
			} else if (blackChessNum == 10) {
				System.out.println("Red WIM");
				abstractChessBoard.removeChessListener();
				new InfoFrame("紅色贏了", infoLocX, infoLocY);
//				new InfoFrame("紅色贏了", "獲勝通知", gameFrame.getLocationOnScreen().x + gameFrame.getWidth() / 2 - 200, gameFrame.getLocationOnScreen().y + gameFrame.getHeight() / 2 - 100);
//				gameFrame.removeBtnListener();
			}
		}

//		System.out.println("toy tox " + chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getName());

		chess.getData().getGameStatus().getChessList().getChessList()[toY][toX] = chess.getData().getGameStatus().getChessList().getChessList()[chess.getChessY()][chess.getChessX()];

//		System.out.println("foX foY " + chess.getData().getGameStatus().getChessList().getChessList()[chess.getChessY()][chess.getChessX()].getName());
//		System.out.println("aft toy tox " + chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getName());

		chess.getData().getGameStatus().getChessList().getChessList()[chess.getChessY()][chess.getChessX()] = null;

//		System.out.println("soy sox " + chess.getData().getGameStatus().getChessList().getChessList()[chess.getChessY()][chess.getChessX()]);
		chess.setChessDead(true);
		chess.setChessX(toX);
		chess.setChessY(toY);
		System.out.println("eat end   ------------------");
//		chess.getData().getGameStatus().getChessList().print(1);
	}

	public boolean kingIsLookEach(ChessView chess, int toX, int toY) {
		int kingCount = 0;
		int count = 0;

		if (chess.getData().getGameStatus().getChessStatus().getWhichGame() == chinessChess) {
			for (int i = 0; i < 3; i++) {
				kingCount = 0;
				count = 0;
				for (int j = 0; j < 10; j++) {
					if (chess.getData().getGameStatus().getChessList().getChessList()[j][3 + i] != null) {
						if (j == chess.getChessY() && (3 + i) == chess.getChessX()) {
						} else {
							if (chess.getData().getGameStatus().getChessList().getChessList()[j][3 + i].getName().equals("King")) {
								if (j == toY && (3 + i) == toX) {
									return true;
								}
//								System.out.println(j + " _ " + (3 + i));
								kingCount++;
							} else {
								if (j == toY && (3 + i) == toX) {
									if (chess.getData().getGameStatus().getChessList().getChessList()[chess.getChessY()][chess.getChessX()].getName().equals("King")) {
//										System.out.println(j + " _ " + (3 + i));
										kingCount++;
									} else {
										if (kingCount == 1) {
//											System.out.println(j + " _ " + (3 + i));
											count++;
										}
									}
								} else {
									if (kingCount == 1) {
//										System.out.println(j + " _ " + (3 + i));
										count++;
									}
								}
							}
						}
					} else {
						if (j == toY && (3 + i) == toX) {
							if (chess.getData().getGameStatus().getChessList().getChessList()[chess.getChessY()][chess.getChessX()].getName().equals("King")) {
//								System.out.println(j + " _ " + (3 + i));
								kingCount++;
							} else {
								if (kingCount == 1) {
//									System.out.println(j + " _ " + (3 + i));
									count++;
								}
							}
						}
					}
				}
//				System.out.println(i + " king : " + kingCount + " count : " + count);
				if (kingCount == 2 && count == 0) {
					return false;
				}
			}
			return true;
		} else {
			return true;
		}
	}

	public void taiwanChessOrder(ChessView chess,AbstractChessBoardFactory abstractChessBoard) {
		ChessView tmp[] = new ChessView[2];
		if (chess.getData().getGameStatus().getChessStatus().getWhichGame() == taiwanChess) {
			if (taiwanOrderCnt > 2) {
				swapUserOrder(chess,abstractChessBoard);
			}
			if (taiwanOrderCnt < 2) {
				tmp[taiwanOrderCnt] = chess;
				taiwanOrderCnt++;
			}
			if (taiwanOrderCnt == 2) {
				if (tmp[0].getPriority() >= tmp[1].getPriority()) {
					chess.getData().getGameStatus().getChessStatus().setWhichOrder(tmp[0].getColor());
					taiwanOrderCnt++;
				} else {
					chess.getData().getGameStatus().getChessStatus().setWhichOrder(tmp[1].getColor());
					taiwanOrderCnt++;
				}
				if (chess.getData().getGameStatus().getChessStatus().getWhichOrder() == red) {
					abstractChessBoard.getWhichOrder().setText("輪到紅色");
				} else {
					abstractChessBoard.getWhichOrder().setText("輪到紅色");
				}
			}
		}
	}

	public LocationPoint findChessInBoardLoc(MouseEvent e, AbstractChessBoardFactory boardFactpry) {
		int locX = e.getXOnScreen() - 3 - boardFactpry.getLocationOnScreen().x;
		int locY = e.getYOnScreen() - 25 - boardFactpry.getLocationOnScreen().y;

		if (boardFactpry.data.getGameStatus().getChessStatus().getWhichGame() == 0) {
			if (!boardFactpry.data.getConfigData().isBoardStraight()) {
				locX -= 65;
				locY -= 555;
				locY = locY * -1;
			} else {
				locX -= 65;
				locY -= 65;
			}
		} else {
			if (!boardFactpry.data.getConfigData().isBoardStraight()) {
				locX -= 30;
				locY -= 590;
				locY = locY * -1;
			} else {
				locX -= 30;
				locY -= 30;
			}
		}

//		System.out.println("mouseReleased : " + (e.getXOnScreen() - boardFactpry.getLocationOnScreen().x) + " " + (e.getYOnScreen() - boardFactpry.getLocationOnScreen().y) + " : " + locX + " " + locY);
		if (locX > boardFactpry.getxMax() || locX < boardFactpry.getxMin() || locY > boardFactpry.getyMax() || locY < boardFactpry.getyMin()) {
			System.out.println("超出範圍");
			System.out.println("far : " + boardFactpry.getxMax() + " " + boardFactpry.getxMin() + " , " + boardFactpry.getyMax() + " " + boardFactpry.getyMin());
			System.out.println(((ChessView) e.getSource()).getChessY() + " : " + ((ChessView) e.getSource()).getChessX());
			((ChessView) e.getSource()).setLocation(boardFactpry.data.getLocMap().getLocationMap()[((ChessView) e.getSource()).getChessY()][((ChessView) e.getSource()).getChessX()].getX(),
					boardFactpry.data.getLocMap().getLocationMap()[((ChessView) e.getSource()).getChessY()][((ChessView) e.getSource()).getChessX()].getY());
			return null;
		}
		int aftChessX = 0, aftChessY = 0;
//		System.out.println("inLoc" + locX + " : " + locY);
		if ((locX % 70) <= 35 && (locY % 70) <= 35) {
//			System.out.println(locX / 70 + " " + locY / 70);
			aftChessX = locX / 70;
			aftChessY = locY / 70;
		} else if ((locX % 70) > 35 && (locY % 70) > 35) {
//			System.out.println((locX / 70 + 1) + " " + (locY / 70 + 1));
			aftChessX = (locX / 70 + 1);
			aftChessY = (locY / 70 + 1);
		} else if ((locX % 70) > 35 && (locY % 70) < 35) {
//			System.out.println((locX / 70 + 1) + " " + locY / 70);
			aftChessX = (locX / 70 + 1);
			aftChessY = locY / 70;
		} else if ((locX % 70) < 35 && (locY % 70) > 35) {
//			System.out.println(locX / 70 + " " + (locY / 70 + 1));
			aftChessX = locX / 70;
			aftChessY = (locY / 70 + 1);
		}
		if (!boardFactpry.data.getConfigData().isBoardStraight()) {
			int tmp = 0;
			tmp = aftChessX;
			aftChessX = aftChessY;
			aftChessY = tmp;
		}
//		System.out.println("inLocCCCC :" + aftChessX + " : " + aftChessY);
//		System.out.println("aft Loc : " + boardFactpry.data.getLocMap().getLocationMap()[aftChessY][aftChessX].getX() + " : " + boardFactpry.data.getLocMap().getLocationMap()[aftChessY][aftChessX].getY());
		((ChessView) e.getSource()).setLocation(boardFactpry.data.getLocMap().getLocationMap()[aftChessY][aftChessX].getX(), boardFactpry.data.getLocMap().getLocationMap()[aftChessY][aftChessX].getY());
		return new LocationPoint(aftChessX, aftChessY);
	}
}
