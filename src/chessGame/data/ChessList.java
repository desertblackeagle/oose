package chessGame.data;

import java.io.Serializable;
import java.util.ArrayList;

import chessGame.data.interfaceData.LocationInterface;
import chessGame.frame.Chess;

public class ChessList implements LocationInterface, Serializable {
	private Chess[][] chineseChessList;
	private Chess[][] taiwanChessList;
	public ChessGameData data;

	public ChessList(ChessGameData data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		chineseChessList = new Chess[10][9];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				chineseChessList[i][j] = null;
			}
		}

		taiwanChessList = new Chess[4][8];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				taiwanChessList[i][j] = null;
			}
		}
	}

	public void print() {
		if (data.getGameStatus().getChessStatus().getWhichGame() == 1) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 9; j++) {
					if (chineseChessList[i][j] != null) {
						System.out.printf("%8s", chineseChessList[i][j].getName());
					} else {
						System.out.printf("%8s", "null");
					}
				}
				System.out.println();
			}
		} else {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					if (taiwanChessList[i][j] != null) {
						System.out.printf("%8s", taiwanChessList[i][j].getName());
					} else {
						System.out.printf("%8s", "null");
					}

				}
				System.out.println();
			}
		}
	}

	public Chess[][] getChessList() {
		if (data.getGameStatus().getChessStatus().getWhichGame() == 0) {
			return taiwanChessList;
		} else {
			return chineseChessList;
		}
	}

	public void setChessList(Chess[][] tmp) {
		if (data.getGameStatus().getChessStatus().getWhichGame() == 0) {
			taiwanChessList = tmp;
		} else {
			chineseChessList = tmp;
		}
	}

	public void clearList() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				chineseChessList[i][j] = null;
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				taiwanChessList[i][j] = null;
			}
		}
	}

	public void reloadChessList(ArrayList<Chess> chessArray) {
		clearList();
		if (data.getGameStatus().getChessStatus().getWhichGame() == 1) {
			for (Chess c : chessArray) {
				if (!c.isChessDead()) {
					chineseChessList[c.getChessY()][c.getChessX()] = c;
				}

			}
		} else {
			for (Chess c : chessArray) {
				if (!c.isChessDead()) {
					taiwanChessList[c.getChessY()][c.getChessX()] = c;
				}
			}
		}
	}

	public void reloadChessLoc() {
		
		if (data.getGameStatus().getChessStatus().getWhichGame() == 0) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					if (taiwanChessList[i][j] != null) {
						taiwanChessList[i][j].setChessX(j);
						taiwanChessList[i][j].setChessY(i);
						taiwanChessList[i][j].setChessDead(false);
					}
				}
			}
		} else {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 9; j++) {
					if (chineseChessList[i][j] != null) {
						chineseChessList[i][j].setChessX(j);
						chineseChessList[i][j].setChessY(i);
						chineseChessList[i][j].setChessDead(false);
//						System.out.printf("%8s", chineseChessList[i][j].getName());
					}
//					else {
//						System.out.printf("%8s", "null");
//					}
				}
//				System.out.println();
			}
		}
	}

//	public Chess[][] getChineseChessList() {
//		return chineseChessList;
//	}
//
//	public Chess[][] getTaiwanChessList() {
//		return taiwanChessList;
//	}
}
