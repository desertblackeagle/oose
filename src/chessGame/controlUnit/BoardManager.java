package chessGame.controlUnit;

import java.util.Iterator;

import chessGame.data.LocationMap;
import chessGame.data.LocationPoint;
import chessGame.data.chess.Chess;
import chessGame.data.chess.ChessView;
import chessGame.data.status.ChessRecord;

/* @author Red Rose
 * Function:a manager to control board
 * @ version 2.0
 * Last Update:2013/11/21
 */

public class BoardManager {
	static final int turnRed = 0;
	static final int turnBlack = 1;
	static final int chinessChess = 1;
	static final int taiwanChess = 0;
	static final int red = 0;
	static final int black = 1;

	private ChessRecord chessRecord = new ChessRecord();
//	private LocationMap locationMap = new LocationMap();
	private Chess[][] chessLocationList = new Chess[10][9];
//	InfoFrame info = null;
//	ChessView tmp[] = new ChessView[2];

	private int forWhoToChess = turnRed;
	private int whichGame; // chinese chess = 1 ; taiwan chess = 0;
	private int redChessNum = 16;
	private int blackChessNum = 16;
	private int taiwanOrderCnt = 0;

	public BoardManager(int whichGame) {
		// TODO Auto-generated constructor stub
		this.whichGame = whichGame;
	}

	public void moveTo(ChessView btnChess, int toX, int toY, ChessViewArrayList buttonArrayList, GameFrame gameFrame) {
		// (move chess to position already)
		// if play dark chess than check cover
		if (btnChess.isChessCover()) {
			System.out.println("Chess need to take cover");
			moveBack(btnChess, taiwanChess);
//			btnChess.setLocation(locationMap.getTaiwaneseLocationMap()[btnChess.getY()][btnChess.getX()].getX(), locationMap.getTaiwaneseLocationMap()[btnChess.getY()][btnChess.getX()].getY());
			return;
		}

		// check player order
		if (forWhoToChess != btnChess.getColor()) {
			// (move back)
			System.out.println("turn " + forWhoToChess + " to chess");
			if (whichGame == chinessChess) {
				moveBack(btnChess, chinessChess);
//				btnChess.setLocation(locationMap.getChineseLocationMap()[btnChess.getY()][btnChess.getX()].getX(), locationMap.getChineseLocationMap()[btnChess.getY()][btnChess.getX()].getY());
			} else {
				moveBack(btnChess, taiwanChess);
//				btnChess.setLocation(locationMap.getTaiwaneseLocationMap()[btnChess.getY()][btnChess.getX()].getX(), locationMap.getTaiwaneseLocationMap()[btnChess.getY()][btnChess.getX()].getY());
			}
			return;
		}

		if (kingIsLookEach(btnChess, toX, toY)) {
			if (canMove(btnChess.getChess(), toX, toY)) {
				if (haveTarget(toX, toY)) {
					if (canEat(btnChess.getChess(), toX, toY)) {
						if (btnChess.getColor() != chessLocationList[toY][toX].getColor()) {
							System.out.println("eat");
							chessRecord.record(btnChess.getChess(), toX, toY);
							eatChess(btnChess, toX, toY, buttonArrayList, gameFrame);
							swapUserOrder(gameFrame);
						} else {
							// (move back) can't eat same color
							System.out.println(btnChess.getColor() + btnChess.getName() + "[" + btnChess.getX() + "," + btnChess.getY() + "]" + "can't eat sam color " + chessLocationList[toY][toX].getName());
							if (whichGame == chinessChess) {
								moveBack(btnChess, chinessChess);
//								btnChess.setLocation(locationMap.getChineseLocationMap()[btnChess.getY()][btnChess.getX()].getX(), locationMap.getChineseLocationMap()[btnChess.getY()][btnChess.getX()].getY());
							} else {
								moveBack(btnChess, taiwanChess);
//								btnChess.setLocation(locationMap.getTaiwaneseLocationMap()[btnChess.getY()][btnChess.getX()].getX(), locationMap.getTaiwaneseLocationMap()[btnChess.getY()][btnChess.getX()].getY());
							}
						}
					} else {
						// (move back) can't eat
						System.out.println(btnChess.getName() + "[" + btnChess.getX() + "," + btnChess.getY() + "]" + "can't eat " + chessLocationList[toY][toX].getName());
						if (whichGame == chinessChess) {
							moveBack(btnChess, chinessChess);
//							btnChess.setLocation(locationMap.getChineseLocationMap()[btnChess.getY()][btnChess.getX()].getX(), locationMap.getChineseLocationMap()[btnChess.getY()][btnChess.getX()].getY());
						} else {
							moveBack(btnChess, taiwanChess);
//							btnChess.setLocation(locationMap.getTaiwaneseLocationMap()[btnChess.getY()][btnChess.getX()].getX(), locationMap.getTaiwaneseLocationMap()[btnChess.getY()][btnChess.getX()].getY());
						}
					}
				} else {
					System.out.println(btnChess.getName() + " is moving");
					chessRecord.record(btnChess.getChess(), toX, toY);
					chessLocationList[toY][toX] = chessLocationList[btnChess.getY()][btnChess.getX()];
					chessLocationList[btnChess.getY()][btnChess.getX()] = null;
					btnChess.setX(toX);
					btnChess.setY(toY);
					swapUserOrder(gameFrame);
				}
			} else {
				// (move back) can't move to
				System.out.println(btnChess.getColor() + btnChess.getName() + "[" + btnChess.getX() + "," + btnChess.getY() + "]" + "can't move to " + "[" + toX + "," + toY + "]");
				if (whichGame == chinessChess) {
					moveBack(btnChess, chinessChess);
//					btnChess.setLocation(locationMap.getChineseLocationMap()[btnChess.getY()][btnChess.getX()].getX(), locationMap.getChineseLocationMap()[btnChess.getY()][btnChess.getX()].getY());
				} else {
					moveBack(btnChess, taiwanChess);
//					btnChess.setLocation(locationMap.getTaiwaneseLocationMap()[btnChess.getY()][btnChess.getX()].getX(), locationMap.getTaiwaneseLocationMap()[btnChess.getY()][btnChess.getX()].getY());
				}
			}
		} else {
			System.out.println("King can't look each other");
			moveBack(btnChess, chinessChess);
//			btnChess.setLocation(locationMap.getChineseLocationMap()[btnChess.getY()][btnChess.getX()].getX(), locationMap.getChineseLocationMap()[btnChess.getY()][btnChess.getX()].getY());
		}
	}

	public void taiwanChessOrder(ChessView btnChess, GameFrame gameFrame) {
		if (whichGame == taiwanChess) {
			if (taiwanOrderCnt > 2) {
				swapUserOrder(gameFrame);
			}
			if (taiwanOrderCnt < 2) {
				tmp[taiwanOrderCnt] = btnChess;
				taiwanOrderCnt++;
			}
			if (taiwanOrderCnt == 2) {
				if (tmp[0].getPriority() >= tmp[1].getPriority()) {
					forWhoToChess = tmp[0].getColor();
					taiwanOrderCnt++;
				} else {
					forWhoToChess = tmp[1].getColor();
					taiwanOrderCnt++;
				}
				if (forWhoToChess == red) {
					gameFrame.changeLabelText(gameFrame.getUserOrder(), "輪到紅色");
				} else {
					gameFrame.changeLabelText(gameFrame.getUserOrder(), "輪到黑色");
				}
			}
		}
	}

	public void swapUserOrder(GameFrame gameFrame) {
		forWhoToChess = forWhoToChess ^ 1; // change other side to chess
		if (forWhoToChess == red) {
			gameFrame.changeLabelText(gameFrame.getUserOrder(), "輪到紅色");
		} else {
			gameFrame.changeLabelText(gameFrame.getUserOrder(), "輪到黑色");
		}
	}

	private void moveBack(ChessView btnChess, int whichGame) {
		if (whichGame == chinessChess) {
			btnChess.setLocation(locationMap.getChineseLocationMap()[btnChess.getY()][btnChess.getX()].getX(), locationMap.getChineseLocationMap()[btnChess.getY()][btnChess.getX()].getY());
		} else {
			btnChess.setLocation(locationMap.getTaiwanLocationPointCross()[btnChess.getY()][btnChess.getX()].getX(), locationMap.getTaiwaneseLocationMap()[btnChess.getY()][btnChess.getX()].getY());
		}

	}

	private boolean canMove(Chess chess, int toX, int toY) {
		return chess.moveRule(toX, toY, whichGame, chessLocationList);
	}

	private boolean haveTarget(int toX, int toY) {
		if (chessLocationList[toY][toX] == null) {
			return false;
		} else {
			return true;
		}
	}

	// only for taiwan use
	private boolean canEat(Chess chess, int toX, int toY) {
		if (whichGame == chinessChess) {
			return true;
		} else {
			if (chessLocationList[toY][toX].isChessCover()) {
				System.out.println("can't eat cover chess");
				return false;
			}
			for (int i = 0; i < chess.getEatRule().length; i++) {
				if (chessLocationList[toY][toX].getName().equals(chess.getEatRule()[i])) {
					return true;
				}
			}
			return false;
		}
	}

	private void eatChess(ChessView btnChess, int toX, int toY, ChessViewArrayList ChessViewArrayList, GameFrame gameFrame) {
		// the chess from chessLocationList1[toX][toY] been set location to out of board
		for (int i = 0; i < ChessViewArrayList.getBtnArrayList().size(); i++) {
			if (ChessViewArrayList.getBtnArrayList().get(i).equals(chessLocationList[toY][toX])) {
				if (whichGame == chinessChess) {
					if (ChessViewArrayList.getBtnArrayList().get(i).getName().equals("King")) {
						if (btnChess.getColor() == red) {
							printRecord();
//							new InfoFrame("紅色贏了", "獲勝通知", (gameFrame.getLocationOnScreen().x + gameFrame.getWidth() / 2) - 175, (gameFrame.getLocationOnScreen().y + gameFrame.getHeight() / 2) - 20);
//							info = new InfoFrame("紅色贏了", "獲勝通知", gameFrame.getLocationOnScreen().x + gameFrame.getWidth() / 2 - 200, gameFrame.getLocationOnScreen().y + gameFrame.getHeight() / 2 - 100);
							gameFrame.removeBtnListener();
//							gameFrame.repaint();
						} else {
							printRecord();
//							new InfoFrame("黑色贏了", "獲勝通知", (gameFrame.getLocationOnScreen().x + gameFrame.getWidth() / 2) - 175, (gameFrame.getLocationOnScreen().y + gameFrame.getHeight() / 2) - 20);
//							new InfoFrame("黑色贏了", "獲勝通知", gameFrame.getLocationOnScreen().x + gameFrame.getWidth() / 2 - 200, gameFrame.getLocationOnScreen().y + gameFrame.getHeight() / 2 - 100);
							gameFrame.removeBtnListener();

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
						gameFrame.removeBtnListener();
					} else if (blackChessNum == 15) {
						System.out.println("Red WIM");
//						new InfoFrame("紅色贏了", "獲勝通知", gameFrame.getLocationOnScreen().x + gameFrame.getWidth() / 2 - 200, gameFrame.getLocationOnScreen().y + gameFrame.getHeight() / 2 - 100);
						gameFrame.removeBtnListener();
					}
				}
				// dead chess remove
				if (whichGame == chinessChess) {
					ChessViewArrayList.getBtnArrayList().get(i).setLocation(1000, 1000);
				} else {
					LocationPoint tmp = locationMap.getDeadLocation();
					System.out.println("D : " + tmp.getX() + " " + tmp.getY());
					ChessViewArrayList.getBtnArrayList().get(i).setLocation(tmp.getX(), tmp.getY());
				}
				ChessViewArrayList.getBtnArrayList().get(i).setChessDead(true);
				System.out.println("消失");

			}
		}
		chessLocationList[toY][toX] = chessLocationList[btnChess.getY()][btnChess.getX()];
		chessLocationList[btnChess.getY()][btnChess.getX()] = null;
//		btnChess.setX(toX);
//		btnChess.setY(toY);
	}

	public boolean kingIsLookEach(ChessView btnChess, int toX, int toY) {
		int kingCount = 0;
		int count = 0;

		if (whichGame == chinessChess) {
			for (int i = 0; i < 3; i++) {
				kingCount = 0;
				count = 0;
				for (int j = 0; j < 10; j++) {
//					System.out.println((i+3) +" "+ j);
					if (chessLocationList[j][3 + i] != null) {
						if (j == btnChess.getY() && (3 + i) == btnChess.getX()) {
						} else {
							if (chessLocationList[j][3 + i].getName().equals("King")) {
								if (j == toY && (3 + i) == toX) {
									return true;
								}
								System.out.println(j + " _ " + (3 + i));
								kingCount++;
							} else {
								if (j == toY && (3 + i) == toX) {
									if (chessLocationList[btnChess.getY()][btnChess.getX()].getName().equals("King")) {
										System.out.println(j + " _ " + (3 + i));
										kingCount++;
									} else {
										if (kingCount == 1) {
											System.out.println(j + " _ " + (3 + i));
											count++;
										}
									}
								} else {
									if (kingCount == 1) {
										System.out.println(j + " _ " + (3 + i));
										count++;
									}
								}
							}
						}
					} else {
						if (j == toY && (3 + i) == toX) {
							if (chessLocationList[btnChess.getY()][btnChess.getX()].getName().equals("King")) {
//								if (j == toY && (3 + i) == toX) {
//									return true;
//								}

								System.out.println(j + " _ " + (3 + i));
								kingCount++;
							} else {
								if (kingCount == 1) {
									System.out.println(j + " _ " + (3 + i));
									count++;
								}
//								System.out.println(j + " _ " + (3 + i));
//								count++;
							}
						}
					}
				}
				System.out.println(i + " king : " + kingCount + " count : " + count);
				if (kingCount == 2 && count == 0) {
					return false;
				}
			}
			return true;
		} else {
			return true;
		}
	}

	public void printChess() {
		System.out.println();
		if (whichGame == chinessChess) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 9; j++) {
					if (this.chessLocationList[i][j] == null) {
						System.out.printf("%7s", j + " " + i);
					} else {
						System.out.printf("%7s", this.chessLocationList[i][j].getName());
					}
				}
				System.out.println();
			}
		} else {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					if (this.chessLocationList[i][j] == null) {
						System.out.printf("%10s", j + " " + i);
					} else {
						System.out.printf("%10s", this.chessLocationList[i][j].getColor() + this.chessLocationList[i][j].getName() + this.chessLocationList[i][j].getX() + this.chessLocationList[i][j].getY());
					}
				}
				System.out.println();
			}
		}
	}

	public void printRecord() {
		Iterator<String> it = chessRecord.getRecordStack().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public Chess[][] getChessLocationList() {
		return chessLocationList.clone();
	}

	public int getWhichGame() {
		return whichGame;
	}

}
