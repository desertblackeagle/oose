package controlUnit;

import chess.Chess;
import frame.ButtonChessArrayList;
import frameChess.ButtonChess;

/* @author Red Rose
 * Function:a manager to control board
 * @ version 2.0
 * Last Update:2013/11/17
 */

public class BoardManager {
	final static int turnRed = 0;
	final static int turnBlack = 1;
	final static int chinessChess = 1;
	final static int taiwanChess = 0;
	static final int red = 0;
	static final int black = 1;
	
	LocationMap locationMap;
	
	private int forWhoToChess = turnRed;
	private int whichGame; // chinese chess = 1 ; taiwanese chess = 0;
	private int redChessNum = 16;
	private int blackChessNum = 16;

	Chess[][] chineseChessLocationList = new Chess[10][9];

	ChessRecord chessRecord = new ChessRecord();

	public BoardManager(int whichGame, LocationMap locationMap) {
		// TODO Auto-generated constructor stub
		this.whichGame = whichGame;
		this.locationMap = locationMap;
	}

	public void moveTo(ButtonChess btnChess, int toX, int toY, LocationMap locationMap, ButtonChessArrayList buttonArrayList) {
		System.out.println(btnChess.getChess().getChessCover());
		if (btnChess.getChess().getChessCover()) {
			System.out.println("Chess need to take cover");
			btnChess.setLocation(locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX(), locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY());
			return;
		}

		// (move chess to position already)
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
						if (btnChess.getChess().getColor() != chineseChessLocationList[toY][toX].getColor()) {
							System.out.println("eat");
							chessRecord.record(btnChess.getChess(), toX, toY);
							eatChess(btnChess, toX, toY, locationMap, buttonArrayList);
							forWhoToChess = forWhoToChess ^ 1; // change other side to chess
						} else {
							// (move back) can't eat sam color
							System.out.println(btnChess.getChess().getColor() + btnChess.getChess().getName() + "[" + btnChess.getChess().getX() + "," + btnChess.getChess().getY() + "]" + "can't eat sam color " + chineseChessLocationList[toY][toX].getName());
							if (whichGame == chinessChess) {
								btnChess.setLocation(locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX(), locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY());
							} else {
								btnChess.setLocation(locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX(), locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY());
							}
						}
					} else {
						// (move back) can't eat
						System.out.println(btnChess.getChess().getName() + "[" + btnChess.getChess().getX() + "," + btnChess.getChess().getY() + "]" + "can't eat " + chineseChessLocationList[toY][toX].getName());
						if (whichGame == chinessChess) {
							btnChess.setLocation(locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX(), locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY());
						} else {
							btnChess.setLocation(locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX(), locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY());
						}
					}
				} else {
					System.out.println(btnChess.getChess().getName() + " is moving");
					chessRecord.record(btnChess.getChess(), toX, toY);
					chineseChessLocationList[toY][toX] = chineseChessLocationList[btnChess.getChess().getY()][btnChess.getChess().getX()];
					chineseChessLocationList[btnChess.getChess().getY()][btnChess.getChess().getX()] = null;
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
		return chess.moveRule(toX, toY, whichGame, chineseChessLocationList);
	}

	private boolean haveTarget(int toX, int toY) {
		if (chineseChessLocationList[toY][toX] == null) {
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
			if (chineseChessLocationList[toY][toX].getChessCover()) {
				System.out.println("can't eat cover chess");
				return false;
			}
			for (int i = 0; i < chess.getEatRule().length; i++) {
				if (chineseChessLocationList[toY][toX].getName().equals(chess.getEatRule()[i])) {
					return true;
				}
			}
			return false;
		}
	}

	private void eatChess(ButtonChess btnChess, int toX, int toY, LocationMap locationMap, ButtonChessArrayList buttonChessArrayList) {
		// the chess from chessLocationList1[toX][toY] been set location to out of board
		System.out.println(buttonChessArrayList.getBtnArrayList());
		for (int i = 0; i < buttonChessArrayList.getBtnArrayList().size(); i++) {
			if (buttonChessArrayList.getBtnArrayList().get(i).getChess().equals(chineseChessLocationList[toY][toX])) {
				if (whichGame == chinessChess) {
					if (buttonChessArrayList.getBtnArrayList().get(i).getChess().getName().equals("King")) {
						System.out.println(btnChess.getChess().getColor() + " WIM");
					}
				}else{
					if(buttonChessArrayList.getBtnArrayList().get(i).getChess().getColor() == red){
						redChessNum--;
					}else{
						blackChessNum--;
					}
					if(redChessNum == 0){
						System.out.println("Black WIM");
					}else{
						System.out.println("Red WIM");
					}
				}
				if(whichGame == chinessChess){
					buttonChessArrayList.getBtnArrayList().get(i).setLocation(1000, 500);
				}else{
					LocationPoint tmp = locationMap.getDeadLocation();
					int x = tmp.getX();
					int y = tmp.getY();
					System.out.println("D : "+x+" "+y);
					buttonChessArrayList.getBtnArrayList().get(i).setLocation(x, y);
				}
				System.out.println("消失");
			}
		}
		chineseChessLocationList[toY][toX] = chineseChessLocationList[btnChess.getChess().getY()][btnChess.getChess().getX()];
		chineseChessLocationList[btnChess.getChess().getY()][btnChess.getChess().getX()] = null;
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
					if (chineseChessLocationList[j][3 + i] != null) {
						if (j == btnChess.getChess().getY() && (3 + i) == btnChess.getChess().getX()) {
						} else {
							if (chineseChessLocationList[j][3 + i].getName().equals("King")) {
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
							if (chineseChessLocationList[btnChess.getChess().getY()][btnChess.getChess().getX()].getName().equals("King")) {
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
					if (this.chineseChessLocationList[i][j] == null) {
						System.out.printf("%7s", j + " " + i);
					} else {
						System.out.printf("%7s", this.chineseChessLocationList[i][j].getName());
					}
				}
				System.out.println();
			}
		} else {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					if (this.chineseChessLocationList[i][j] == null) {
						System.out.printf("%10s", j + " " + i);
					} else {
						System.out.printf("%10s", this.chineseChessLocationList[i][j].getColor() + this.chineseChessLocationList[i][j].getName() + this.chineseChessLocationList[i][j].getX() + this.chineseChessLocationList[i][j].getY());
					}
				}
				System.out.println();
			}
		}
	}

	public Chess[][] getChineseChessLocationList() {
		return chineseChessLocationList;
	}

	public void setChineseChessLocationList(Chess[][] chineseChessLocationList) {
		this.chineseChessLocationList = chineseChessLocationList;
	}

	public int getWhichGame() {
		return whichGame;
	}

	public void setWhichGame(int whichGame) {
		this.whichGame = whichGame;
	}

}
