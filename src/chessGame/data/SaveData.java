package chessGame.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class SaveData implements Serializable {
	private int whichGame = 0; // chinese 1 taiwan 0
	private int whichOrder = 0; // player 1 = 0 player2 = 1
	private Stack<String> recordStack;
	private ArrayList<ChessData> array;

//	private Stack<Chess[][]> listRecord;

	public SaveData(int whichGame, int whichOrder, Stack<String> recordStack, ArrayList<ChessData> array) {
		// TODO Auto-generated constructor stub
		this.whichGame = whichGame;
		this.whichOrder = whichOrder;
		this.recordStack = recordStack;
		this.array = array;
//		this.listRecord = listRecord;
	}

	public int getWhichGame() {
		return whichGame;
	}

	public int getWhichOrder() {
		return whichOrder;
	}

	public Stack<String> getRecordStack() {
		return recordStack;
	}

	public ArrayList<ChessData> getArray() {
		return array;
	}

	@Override
	public String toString() {
		return "SaveData [whichGame=" + whichGame + ", whichOrder=" + whichOrder + ", recordStack=" + recordStack + ", array=" + array + "]";
	}

}
