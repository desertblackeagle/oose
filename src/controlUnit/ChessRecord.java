package controlUnit;

import java.util.Stack;

import chess.Chess;

public class ChessRecord {
	private Stack<String> recordStack;
	public ChessRecord() {
		// TODO Auto-generated constructor stub
		recordStack = new Stack<String>();
	}
	
	public void record(Chess chess, int toX, int toY) {
		String record = chess.getName() + " " + chess.getChineseName() + " " + chess.getColor() + " " + chess.getChessCover() + " " + chess.getX() + " " + chess.getY() + " " + toX + " " + toY;
		System.out.println("Chess record : " + chess.getName() + " " + chess.getChineseName() + " " + chess.getColor() + " " + chess.getChessCover() + " " + chess.getX() + " " + chess.getY() + " " + toX + " " + toY);
		recordStack.add(record);
	}
}
