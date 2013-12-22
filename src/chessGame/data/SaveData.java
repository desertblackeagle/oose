package chessGame.data;

import java.io.Serializable;
import java.util.Stack;

import chessGame.data.chess.Chess;

public class SaveData implements Serializable {
	private int whichGame = 0; // chinese 1 taiwan 0
	private int whichOrder = 0; // player 1 = 0 player2 = 1
	private Stack<String> recordStack;
	private Stack<Chess[][]> listRecord;

	public SaveData(int whichGame, int whichOrder, Stack<String> recordStack, Stack<Chess[][]> listRecord) {
		// TODO Auto-generated constructor stub
		this.whichGame = whichGame;
		this.whichOrder = whichOrder;
		this.recordStack = recordStack;
		this.listRecord = listRecord;
	}

}
