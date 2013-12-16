package chessGame.data.chess;

import chessGame.data.LocationPoint;

public class Horse extends ChessView {
	public Horse(String path, int color, boolean cover, int chessX, int chessY) {
		super(path, color, cover, chessX, chessY);
		// TODO Auto-generated constructor stub
		setPriority(3);
		setName("Horse");
		setEatRule("Horse,Cannon,Pawn");
	}

	public Horse(String path, int color, boolean cover, LocationPoint point) {
		super(path, color, cover, point);
		// TODO Auto-generated constructor stub
		setPriority(3);
		setName("Horse");
		setEatRule("Horse,Cannon,Pawn");
	}

	@Override
	public boolean moveRule(int toX, int toY, int whichGame, Chess[][] board) {
		if (whichGame == chinessChess)// 軍棋
		{
			if (Math.abs(toX - getX()) == 2 && Math.abs(toY - getY()) == 1) {
				if (board[getY()][getX() + ((toX - getX()) / 2)] != null) {
					return false;
				}
				return true;
			} else if (Math.abs(toY - getY()) == 2 && Math.abs(toX - getX()) == 1) {
				if (board[getY() + ((toY - getY()) / 2)][getX()] != null) {
					return false;
				}
				return true;
			}
		} else// 暗棋
		{
			if ((Math.abs(getX() - toX) == 1) && getY() == toY) {
				return true;
			} else if ((Math.abs(getY() - toY) == 1) && getX() == toX) {
				return true;
			}
		}
		return false;
	};

}