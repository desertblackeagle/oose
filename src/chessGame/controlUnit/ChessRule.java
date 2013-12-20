package chessGame.controlUnit;

import java.awt.event.MouseEvent;

import abstractGame.chessGame.AbstractChessBoardFactory;
import chessGame.data.LocationPoint;
import chessGame.data.chess.ChessView;

public class ChessRule {

	static final int chinessChess = 1;
	static final int taiwanChess = 0;
	static final int red = 0;
	static final int black = 1;
	private int redChessNum = 16;
	private int blackChessNum = 16;

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

		if (chess.isChessCover()) {
			System.out.println("Chess need to take cover");
			moveBack(chess);
			return false;
		}

		// check player order
		if (chess.getData().getGameStatus().getChessStatus().getWhichOrder() != chess.getColor()) {
			// (move back)
			System.out.println("turn " + chess.getData().getGameStatus().getChessStatus().getWhichOrder() + " to chess");
			moveBack(chess);
			return false;
		}

		if (kingIsLookEach(chess, toX, toY)) {
			if (canMove(chess, toX, toY)) {
				if (haveTarget(chess, toX, toY)) {
					if (canEat(chess, toX, toY)) {
						if (chess.getColor() != chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getColor()) {
							abstractChessBoard.setInfotAreaText(chess.getName() + " 吃掉  " + chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getName());
							System.out.println(chess.getName() + " eat " + chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getName());
//							chessRecord.record(chess.getChess(), toX, toY);
							eatChess(chess, toX, toY);
							swapUserOrder(chess);
							return true;
						} else {
							// (move back) can't eat same color
							System.out.println(chess.getColor() + chess.getName() + "[" + chess.getChessX() + "," + chess.getChessY() + "]" + "can't eat sam color " + chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getName());
							moveBack(chess);
							return false;
						}
					} else {
						// (move back) can't eat
						System.out.println(chess.getName() + "[" + chess.getChessX() + "," + chess.getChessY() + "]" + "can't eat " + chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getName());
						moveBack(chess);
						return false;
					}
				} else {
					abstractChessBoard.setInfotAreaText(chess.getName() + " 移動從 [" + chess.getChessX() + "," + chess.getChessY() + "] to [" + toX + "," + toY + "]");
					System.out.println(chess.getName() + " move frome [" + chess.getChessX() + "," + chess.getChessY() + "] to [" + toX + "," + toY + "]");
//					chessRecord.record(chess.getChess(), toX, toY);
					chess.getData().getGameStatus().getChessList().getChessList()[toY][toX] = chess.getData().getGameStatus().getChessList().getChessList()[chess.getChessY()][chess.getChessX()];
					chess.getData().getGameStatus().getChessList().getChessList()[chess.getChessY()][chess.getChessX()] = null;
					chess.setChessX(toX);
					chess.setChessY(toY);
					swapUserOrder(chess);
					return true;
				}
			} else {
				// (move back) can't move to
				System.out.println(chess.getColor() + chess.getName() + "[" + chess.getChessX() + "," + chess.getChessY() + "]" + "can't move to " + "[" + toX + "," + toY + "]");
				moveBack(chess);
				return false;
			}
		} else {
			System.out.println("King can't look each other");
			moveBack(chess);
			return false;
		}
	}

	private void moveBack(ChessView chess) {
		System.out.println("Back");
		chess.setLocation(chess.getData().getLocMap().getLocationMap()[chess.getChessY()][chess.getChessX()].getX(), chess.getData().getLocMap().getLocationMap()[chess.getChessY()][chess.getChessX()].getY());
	}

	public void swapUserOrder(ChessView chess) {
		chess.getData().getGameStatus().getChessStatus().setWhichOrder(chess.getData().getGameStatus().getChessStatus().getWhichOrder() ^ 1); // change other side to chess
		if (chess.getData().getGameStatus().getChessStatus().getWhichOrder() == red) {
//			gameFrame.changeLabelText(gameFrame.getUserOrder(), "輪到紅色");
		} else {
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

	private void eatChess(ChessView chess, int toX, int toY) {
		System.out.println("eat start ------------------");
		chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].setLocation(1000, 1000);

//		System.out.println("toy tox " + chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getName());

		chess.getData().getGameStatus().getChessList().getChessList()[toY][toX] = chess.getData().getGameStatus().getChessList().getChessList()[chess.getChessY()][chess.getChessX()];

//		System.out.println("foX foY " + chess.getData().getGameStatus().getChessList().getChessList()[chess.getChessY()][chess.getChessX()].getName());
//		System.out.println("aft toy tox " + chess.getData().getGameStatus().getChessList().getChessList()[toY][toX].getName());

		chess.getData().getGameStatus().getChessList().getChessList()[chess.getChessY()][chess.getChessX()] = null;

//		System.out.println("soy sox " + chess.getData().getGameStatus().getChessList().getChessList()[chess.getChessY()][chess.getChessX()]);
		chess.setChessX(toX);
		chess.setChessY(toY);
		System.out.println("eat end   ------------------");
//		chess.getData().getGameStatus().getChessList().print(1);
	}

	private void eatChess(ChessView chess, int toX, int toY, ChessViewArrayList ChessViewArrayList) {
		// the chess from chessLocationList1[toX][toY] been set location to out of board
		for (int i = 0; i < ChessViewArrayList.getBtnArrayList().size(); i++) {
			if (ChessViewArrayList.getBtnArrayList().get(i).equals(chess.getData().getGameStatus().getChessList().getChessList()[toY][toX])) {
				if (chess.getData().getGameStatus().getChessStatus().getWhichGame() == chinessChess) {
					if (ChessViewArrayList.getBtnArrayList().get(i).getName().equals("King")) {
						if (chess.getColor() == red) {
//							printRecord();
//							new InfoFrame("紅色贏了", "獲勝通知", (gameFrame.getLocationOnScreen().x + gameFrame.getWidth() / 2) - 175, (gameFrame.getLocationOnScreen().y + gameFrame.getHeight() / 2) - 20);
//							info = new InfoFrame("紅色贏了", "獲勝通知", gameFrame.getLocationOnScreen().x + gameFrame.getWidth() / 2 - 200, gameFrame.getLocationOnScreen().y + gameFrame.getHeight() / 2 - 100);
//							gameFrame.removeBtnListener();
//							gameFrame.repaint();
						} else {
//							printRecord();
//							new InfoFrame("黑色贏了", "獲勝通知", (gameFrame.getLocationOnScreen().x + gameFrame.getWidth() / 2) - 175, (gameFrame.getLocationOnScreen().y + gameFrame.getHeight() / 2) - 20);
//							new InfoFrame("黑色贏了", "獲勝通知", gameFrame.getLocationOnScreen().x + gameFrame.getWidth() / 2 - 200, gameFrame.getLocationOnScreen().y + gameFrame.getHeight() / 2 - 100);
//							gameFrame.removeBtnListener();

						}
					}
				} else {
					if (ChessViewArrayList.getBtnArrayList().get(i).getColor() == red) {
						redChessNum--;
					} else {
						blackChessNum--;
					}
					if (redChessNum == 15) {
						System.out.println("Black WIM");
//						new InfoFrame("黑色贏了", "獲勝通知", gameFrame.getLocationOnScreen().x, ((ChineseGameFrame) gameFrame).getLocationOnScreen().y);
//						new InfoFrame("黑色贏了", "獲勝通知", gameFrame.getLocationOnScreen().x + gameFrame.getWidth() / 2 - 200, gameFrame.getLocationOnScreen().y + gameFrame.getHeight() / 2 - 100);
//						gameFrame.removeBtnListener();
					} else if (blackChessNum == 15) {
						System.out.println("Red WIM");
//						new InfoFrame("紅色贏了", "獲勝通知", gameFrame.getLocationOnScreen().x + gameFrame.getWidth() / 2 - 200, gameFrame.getLocationOnScreen().y + gameFrame.getHeight() / 2 - 100);
//						gameFrame.removeBtnListener();
					}
				}
				// dead chess remove
				if (chess.getData().getGameStatus().getChessStatus().getWhichGame() == chinessChess) {
					ChessViewArrayList.getBtnArrayList().get(i).setLocation(1000, 1000);
				} else {
//					LocationPoint tmp = locationMap.getDeadLocation();
//					System.out.println("D : " + tmp.getX() + " " + tmp.getY());
//					ChessViewArrayList.getBtnArrayList().get(i).setLocation(tmp.getX(), tmp.getY());
				}
				ChessViewArrayList.getBtnArrayList().get(i).setChessDead(true);
				System.out.println("消失");

			}
		}
		chess.getData().getGameStatus().getChessList().getChessList()[toY][toX] = chess.getData().getGameStatus().getChessList().getChessList()[chess.getChessY()][chess.getChessX()];
		chess.getData().getGameStatus().getChessList().getChessList()[chess.getChessY()][chess.getChessX()] = null;
//		btnChess.setX(toX);
//		btnChess.setY(toY);
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
