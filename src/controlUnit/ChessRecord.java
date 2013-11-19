package controlUnit;

import chess.Chess;

public class ChessRecord {
	public void record(Chess chess, int toX, int toY) {
		System.out.println("Chess record : " + chess.getName() + " " + chess.getChineseName() + " " + chess.getColor() + " " + chess.getChessCover() + " " + chess.getX() + " " + chess.getY() + " " + toX + " " + toY);
	}
}
