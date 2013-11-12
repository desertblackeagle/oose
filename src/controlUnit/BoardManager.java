package controlUnit;

import chess.Chess;
import frame.ButtonChessArrayList;
import frameChess.ButtonChess;

/* @author Red Rose
 * Function:a manager to control board
 * @ version 1.8
 * Last Update:2013/11/8
 */

public class BoardManager {
	final static int turnRed = 0;
	final static int turnBlack = 1;
	final static int chinessChess = 1;
	final static int taiwanChess = 0;
	LocationMap locationMap;
	int forWhoToChess = turnRed;
	int whichGame; // chinese chess = 1 ; taiwanese chess = 0;

	Chess[][] chineseChessLocationList = new Chess[10][9];

	ChessRecord chessRecord = new ChessRecord();

	public BoardManager(int whichGame, LocationMap locationMap) {
		// TODO Auto-generated constructor stub
		this.whichGame = whichGame;
		this.locationMap = locationMap;
	}

	public void moveTo(ButtonChess btnChess, int toX, int toY, LocationMap locationMap, ButtonChessArrayList buttonArrayList) {

		// (move chess to position already)
		if (forWhoToChess != btnChess.getChess().getColor()) {
			// (move back)
			System.out.println("turn " + forWhoToChess + " to chess");
			if (whichGame == chinessChess) {
				btnChess.setLocation(locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY(), locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX());
			} else {
				btnChess.setLocation(locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY(), locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX());
			}
			return;
		}

		if (canMove(btnChess.getChess(), toX, toY)) {
			if (haveTarget(toX, toY)) {
				if (canEat(btnChess.getChess(), toX, toY)) {
					if (btnChess.getChess().getColor() != chineseChessLocationList[toY][toX].getColor()) {
						System.out.println("eat");
						eatChess(btnChess, toX, toY, locationMap, buttonArrayList);
						chessRecord.record(btnChess.getChess(), toX, toY);
						forWhoToChess = forWhoToChess ^ 1; // change other side to chess
					} else {
						// (move back) can't eat sam color
						System.out.println(btnChess.getChess().getColor() + btnChess.getChess().getName() + "[" + btnChess.getChess().getX() + "," + btnChess.getChess().getY() + "]" + "can't eat sam color " + chineseChessLocationList[toY][toX].getName());
						if (whichGame == chinessChess) {
							btnChess.setLocation(locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY(), locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX());
						} else {
							btnChess.setLocation(locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY(), locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX());
						}
					}
				} else {
					// (move back) can't eat
					System.out.println(btnChess.getChess().getName() + "[" + btnChess.getChess().getX() + "," + btnChess.getChess().getY() + "]" + "can't eat " + chineseChessLocationList[toY][toX].getName());
					if (whichGame == chinessChess) {
						btnChess.setLocation(locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY(), locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX());
					} else {
						btnChess.setLocation(locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY(), locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX());
					}
				}
			} else {
				System.out.println(btnChess.getChess().getName() + " is moving");
				chineseChessLocationList[toY][toX] = chineseChessLocationList[btnChess.getChess().getY()][btnChess.getChess().getX()];
				chineseChessLocationList[btnChess.getChess().getY()][btnChess.getChess().getX()] = null;
				btnChess.getChess().setX(toX);
				btnChess.getChess().setY(toY);
				chessRecord.record(btnChess.getChess(), toX, toY);
				forWhoToChess = forWhoToChess ^ 1; // change other side th chess
			}
		} else {
			// (move back) can't move to
			System.out.println(btnChess.getChess().getColor() + btnChess.getChess().getName() + "[" + btnChess.getChess().getX() + "," + btnChess.getChess().getY() + "]" + "can't move to " + "[" + toX + "," + toY + "]");
			if (whichGame == chinessChess) {
				btnChess.setLocation(locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY(), locationMap.getChineseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX());
			} else {
				btnChess.setLocation(locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getY(), locationMap.getTaiwaneseLocationMap()[btnChess.getChess().getY()][btnChess.getChess().getX()].getX());
			}
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

	// only for taiwanese use
	private boolean canEat(Chess chess, int toX, int toY) {
		if (whichGame == chinessChess) {
			return true;
		} else {
			for (int i =0;i<chess.getEatRule().length;i++) {
				System.out.println(chineseChessLocationList[toY][toX].getName()+" "+chess.getEatRule()[i]);
				if (chineseChessLocationList[toY][toX].getName().equals(chess.getEatRule()[i])) {
					return true;
				}
			}
			
//			for (String canEatTarget : chess.getEatRule()) {
//				System.out.println(chineseChessLocationList[toY][toX].getName()+" "+canEatTarget);
//				if (chineseChessLocationList[toY][toX].getName().equals(canEatTarget)) {
//					return true;
//				}
//			}
			return false;
		}
	}

	private void eatChess(ButtonChess btnChess, int toX, int toY, LocationMap locationMap, ButtonChessArrayList buttonChessArrayList) {
		// the chess from chessLocationList1[toX][toY] been set location to out of board
		System.out.println(buttonChessArrayList.getBtnArrayList());
		for (int i = 0; i < buttonChessArrayList.getBtnArrayList().size(); i++) {
			if (buttonChessArrayList.getBtnArrayList().get(i).getChess().equals(chineseChessLocationList[toY][toX])) {
				buttonChessArrayList.getBtnArrayList().get(i).setLocation(1000, 1000);
				System.out.println("消失");
			}
		}
		chineseChessLocationList[toY][toX] = chineseChessLocationList[btnChess.getChess().getY()][btnChess.getChess().getX()];
		chineseChessLocationList[btnChess.getChess().getY()][btnChess.getChess().getX()] = null;
		btnChess.getChess().setX(toX);
		btnChess.getChess().setY(toY);
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
