package chessGame.data.status;

import chessGame.data.chess.Chess;

public class ChessList implements LocationInterface {
	private Chess[][] chineseChessList;
	private Chess[][] taiwanChessList;

	public ChessList() {
		// TODO Auto-generated constructor stub
		chineseChessList = new Chess[10][9];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				chineseChessList[j][i] = null;
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				taiwanChessList[j][i] = null;
			}
		}
	}

	public Chess[][] getChineseChessList() {
		return chineseChessList;
	}

	public Chess[][] getTaiwanChessList() {
		return taiwanChessList;
	}
}
