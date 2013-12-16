package chessGame.data.status;

import java.util.Stack;

import chessGame.data.chess.Chess;

public class ChessRecord implements RecordInterface{
	private Stack<String> recordStack;
	public ChessRecord() {
		// TODO Auto-generated constructor stub
		recordStack = new Stack<String>();
	}
	
	public Stack<String> getRecordStack() {
		return recordStack;
	}

	public void record(Chess chess, int toX, int toY) {
//		String record = chess.getName() + " " + chess.getChineseName() + " " + chess.getColor() + " " + chess.isChessCover() + " " + chess.getX() + " " + chess.getY() + " " + toX + " " + toY;
//		System.out.println("Chess record : " + chess.getName() + " " + chess.getChineseName() + " " + chess.getColor() + " " + chess.isChessCover() + " " + chess.getX() + " " + chess.getY() + " " + toX + " " + toY);
//		recordStack.add(record);
	}
}
