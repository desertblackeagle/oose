package abstractGame.chessGame;

import java.awt.ScrollPane;
import java.io.Serializable;
import java.util.Stack;

import chessGame.data.chess.Chess;

public class Data implements Serializable {
	String data = "i am data";
	ScrollPane sp = new ScrollPane();
	private int whichGame = 0; // chinese 1 taiwan 0
	private int whichOrder = 0; // player 1 = 0 player2 = 1
	private Stack<String> recordStack;
	private Stack<Chess[][]> listRecord;

	public Data(int whichGame, int whichOrder, Stack<String> recordStack, Stack<Chess[][]> listRecord) {
		// TODO Auto-generated constructor stub
		this.whichGame = whichGame;
		this.whichOrder = whichOrder;
		this.recordStack = recordStack;
		this.listRecord = listRecord;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ScrollPane getSp() {
		return sp;
	}

	public void setSp(ScrollPane sp) {
		this.sp = sp;
	}

	@Override
	public String toString() {
		return "Data [data=" + data + ", sp=" + sp + "]";
	}

}
