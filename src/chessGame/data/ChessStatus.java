package chessGame.data;

import java.io.Serializable;

import chessGame.data.te.StatusInterface;

public class ChessStatus implements StatusInterface, Serializable {
	private int whichGame = 0; // chinese 1 taiwan 0
	private int whichOrder = 0; // player 1 = 0 player2 = 1

	public void clear() {
		whichGame = 0; // chinese 1 taiwan 0
		whichOrder = 0;
	}

	public void setWhichGame(int whichGame) {
		this.whichGame = whichGame;
	}

	public void setWhichOrder(int whichOrder) {
		this.whichOrder = whichOrder;
	}

	public int getWhichGame() {
		return whichGame;
	}

	public int getWhichOrder() {
		return whichOrder;
	}

}
