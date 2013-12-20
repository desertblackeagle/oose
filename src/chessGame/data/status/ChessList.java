package chessGame.data.status;

import chessGame.data.ChessGameData;
import chessGame.data.chess.Chess;

public class ChessList implements LocationInterface {
	private Chess[][] chineseChessList;
	private Chess[][] taiwanChessList;
	private ChessGameData data;

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

	public void print(int w) {
		if (w == 1) {
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
//	public Chess[][] getChineseChessList() {
//		return chineseChessList;
//	}
//
//	public Chess[][] getTaiwanChessList() {
//		return taiwanChessList;
//	}
}
