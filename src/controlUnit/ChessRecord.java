package controlUnit;

import chess.Chess;

public class ChessRecord {
	public void record(Chess chess, int toX, int toY) {
		System.out.println(chess.getName() +" "+ chess.getX() +" "+ chess.getY() +" "+ toX +" "+ toY );
	}
}
