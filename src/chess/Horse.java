package chess;

import chess.Chess;
import controlUnit.LocationPoint;

public class Horse extends Chess {
	static final int chinessChess = 1;

	public Horse(int color, boolean chessCover, int x, int y, Chess[][] board) {
		super(color, chessCover, x, y, board);
		setName("Horse");
		if (color == 0) {
			setChineseName("傌");
		} else {
			setChineseName("馬");
		}
//		System.out.println(getName()+"set rule");
		setEatRule("Horse,Cannon,Pawn");
	}

	public Horse(int color, boolean chessCover, LocationPoint point, Chess[][] board) {
		super(color, chessCover, point.getX(), point.getY(), board);
		setName("Horse");
		if (color == 0) {
			setChineseName("傌");
		} else {
			setChineseName("馬");
		}
//		System.out.println(getName()+"set rule");
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