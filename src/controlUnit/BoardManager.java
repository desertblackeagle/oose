package controlUnit;

import chess.Chess;
import frame.ButtonChessArrayList;
import frame.ChineseGameFrame;
import frame.InfoFrame;
import frame.TaiwanGameFrame;
import frameChess.ButtonChess;

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

//	private LocationMap locationMap;
	private ChessRecord chessRecord = new ChessRecord();
	private LocationMap locationMap = new LocationMap();
	private Chess[][] chessLocationList = new Chess[10][9];

	private int forWhoToChess = turnRed;
	private int whichGame; // chinese chess = 1 ; taiwan chess = 0;
	private int redChessNum = 16;
	private int blackChessNum = 16;

	public BoardManager(int whichGame) {
		// TODO Auto-generated constructor stub
		this.whichGame = whichGame;
	}

	public void moveTo(ButtonChess btnChess, int toX, int toY, ButtonChessArrayList buttonArrayList, Object gameFrame) {
		// (move chess to position already)

		if (btnChess.getChess().getChessCover()) {
			System.out.println("Chess need to take cover");
			btnChess.setLocation(locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX(), locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY());
			return;
		}

		// check player order
		if (forWhoToChess != btnChess.getChess().getColor()) {
			// (move back)
			System.out.println("turn " + forWhoToChess + " to chess");
			if (whichGame == chinessChess) {
				btnChess.setLocation(locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX(), locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY());
			} else {
				btnChess.setLocation(locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX(), locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY());
			}
			return;
		}

		if (kingIsLookEach(btnChess, toX, toY)) {
			if (canMove(btnChess.getChess(), toX, toY)) {
				if (haveTarget(toX, toY)) {
					if (canEat(btnChess.getChess(), toX, toY)) {
						if (btnChess.getChess().getColor() != chessLocationList[toY][toX].getColor()) {
							System.out.println("eat");
							chessRecord.record(btnChess.getChess(), toX, toY);
							eatChess(btnChess, toX, toY, buttonArrayList,gameFrame);
							forWhoToChess = forWhoToChess ^ 1; // change other side to chess
						} else {
							// (move back) can't eat sam color
							System.out.println(btnChess.getChess().getColor() + btnChess.getChess().getName() + "[" + btnChess.getChess().getX() + "," + btnChess.getChess().getY() + "]" + "can't eat sam color " + chessLocationList[toY][toX].getName());
							if (whichGame == chinessChess) {
								btnChess.setLocation(locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX(), locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY());
							} else {
								btnChess.setLocation(locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX(), locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY());
							}
						}
					} else {
						// (move back) can't eat
						System.out.println(btnChess.getChess().getName() + "[" + btnChess.getChess().getX() + "," + btnChess.getChess().getY() + "]" + "can't eat " + chessLocationList[toY][toX].getName());
						if (whichGame == chinessChess) {
							btnChess.setLocation(locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX(), locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY());
						} else {
							btnChess.setLocation(locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX(), locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY());
						}
					}
				} else {
					System.out.println(btnChess.getChess().getName() + " is moving");
					chessRecord.record(btnChess.getChess(), toX, toY);
					chessLocationList[toY][toX] = chessLocationList[btnChess.getChess().getY()][btnChess.getChess().getX()];
					chessLocationList[btnChess.getChess().getY()][btnChess.getChess().getX()] = null;
					btnChess.getChess().setX(toX);
					btnChess.getChess().setY(toY);
					forWhoToChess = forWhoToChess ^ 1; // change other side th chess
				}
			} else {
				// (move back) can't move to
				System.out.println(btnChess.getChess().getColor() + btnChess.getChess().getName() + "[" + btnChess.getChess().getX() + "," + btnChess.getChess().getY() + "]" + "can't move to " + "[" + toX + "," + toY + "]");
				if (whichGame == chinessChess) {
					btnChess.setLocation(locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX(), locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY());
				} else {
					btnChess.setLocation(locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX(), locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY());
				}
			}
		} else {
			System.out.println("King can't look each other");
			btnChess.setLocation(locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX(), locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY());
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
			if (chessLocationList[toY][toX].getChessCover()) {
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

	private void eatChess(ButtonChess btnChess, int toX, int toY, ButtonChessArrayList buttonChessArrayList, Object gameFrame) {
		// the chess from chessLocationList1[toX][toY] been set location to out of board
		// System.out.println(buttonChessArrayList.getBtnArrayList());
		for (int i = 0; i < buttonChessArrayList.getBtnArrayList().size(); i++) {
			if (buttonChessArrayList.getBtnArrayList().get(i).getChess().equals(chessLocationList[toY][toX])) {
				if (whichGame == chinessChess) {
					if (buttonChessArrayList.getBtnArrayList().get(i).getChess().getName().equals("King")) {
						System.out.println(btnChess.getChess().getColor() + " WIM");
						if (btnChess.getChess().getColor() == red) {
							
							new InfoFrame("紅色贏了", "獲勝通知",(((ChineseGameFrame)gameFrame).getLocationOnScreen().x + ((ChineseGameFrame)gameFrame).getWidth() / 2) - 175,(((ChineseGameFrame)gameFrame).getLocationOnScreen().y + ((ChineseGameFrame)gameFrame).getHeight() / 2) - 20);
						} else {
							new InfoFrame("黑色贏了", "獲勝通知",(((ChineseGameFrame)gameFrame).getLocationOnScreen().x + ((ChineseGameFrame)gameFrame).getWidth() / 2) - 175,(((ChineseGameFrame)gameFrame).getLocationOnScreen().y + ((ChineseGameFrame)gameFrame).getHeight() / 2) - 20);
						}

					}
				} else {
					if (buttonChessArrayList.getBtnArrayList().get(i).getChess().getColor() == red) {
						redChessNum--;
					} else {
						blackChessNum--;
					}
					if (redChessNum == 0) {
						System.out.println("Black WIM");
						new InfoFrame("黑色贏了", "獲勝通知",((TaiwanGameFrame)gameFrame).getLocationOnScreen().x,((ChineseGameFrame)gameFrame).getLocationOnScreen().y);
					} else if (blackChessNum == 0) {
						System.out.println("Red WIM");
						new InfoFrame("紅色贏了", "獲勝通知",((TaiwanGameFrame)gameFrame).getLocationOnScreen().x,((ChineseGameFrame)gameFrame).getLocationOnScreen().y);
					}
				}
				// dead chess remove
				if (whichGame == chinessChess) {
					buttonChessArrayList.getBtnArrayList().get(i).setLocation(1000, 1000);
				} else {
					LocationPoint tmp = locationMap.getDeadLocation();
					System.out.println("D : " + tmp.getX() + " " + tmp.getY());
					buttonChessArrayList.getBtnArrayList().get(i).setLocation(tmp.getX(), tmp.getY());
				}
				buttonChessArrayList.getBtnArrayList().get(i).getChess().setChessDead(true);
				System.out.println("消失");

			}
		}
		chessLocationList[toY][toX] = chessLocationList[btnChess.getChess().getY()][btnChess.getChess().getX()];
		chessLocationList[btnChess.getChess().getY()][btnChess.getChess().getX()] = null;
		btnChess.getChess().setX(toX);
		btnChess.getChess().setY(toY);
	}

	public boolean kingIsLookEach(ButtonChess btnChess, int toX, int toY) {
		int kingCount = 0;
		int count = 0;

		if (whichGame == chinessChess) {
			for (int i = 0; i < 3; i++) {
				kingCount = 0;
				count = 0;
				for (int j = 0; j < 10; j++) {
					if (chessLocationList[j][3 + i] != null) {
						if (j == btnChess.getChess().getY() && (3 + i) == btnChess.getChess().getX()) {
						} else {
							if (chessLocationList[j][3 + i].getName().equals("King")) {
								if (j == toY && (3 + i) == toX) {
									return true;
								}
								System.out.println(j + " _ " + (3 + i));
								kingCount++;
							} else {
								if (kingCount == 1) {
									System.out.println(j + " _ " + (3 + i));
									count++;
								}
							}
						}
					} else {
						if (j == toY && (3 + i) == toX) {
							if (chessLocationList[btnChess.getChess().getY()][btnChess.getChess().getX()].getName().equals("King")) {
								if (j == toY && (3 + i) == toX) {
									return true;
								}
								System.out.println(j + " _ " + (3 + i));
								kingCount++;
							} else {
								System.out.println(j + " _ " + (3 + i));
								count++;
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

	public Chess[][] getChessLocationList() {
		return chessLocationList.clone();
	}

	public int getWhichGame() {
		return whichGame;
	}

}
