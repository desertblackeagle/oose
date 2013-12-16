package chessGame.data.chess;

import chessGame.data.LocationPoint;

public class Pawn extends ChessView {
	public Pawn(String path, int color, boolean cover, int chessX, int chessY) {
		super(path, color, cover, chessX, chessY);
		// TODO Auto-generated constructor stub
		setPriority(1);
		setName("Pawn");
		setEatRule("King,Pawn");
	}

	public Pawn(String path, int color, boolean cover, LocationPoint point) {
		super(path, color, cover, point);
		// TODO Auto-generated constructor stub
		setPriority(1);
		setName("Pawn");
		setEatRule("King,Pawn");
	}

	@Override
	public boolean moveRule(int toX, int toY, int whichGame, Chess[][] board) {
		if (whichGame == chinessChess)// 軍棋
		{
			if (getColor() == red)// 紅色
			{
				if (getY() > 4)// 只能往前走
				{
					if (getY() - toY == 1 && toX == getX()) {
						return true;
					}
				} else if (getY() <= 4) {
					if (getY() - toY == 1 || Math.abs(getX() - toX) == 1)// 過河後可往前或左右
					{
						return true;
					}
				}
			} else// 黑色
			{
				if (getY() < 5)// 只能往前走
				{
					if (toY - getY() == 1 && toX == getX()) {
						return true;
					}
				} else if (getY() >= 5) {
					if (getY() - toY == -1 || Math.abs(getX() - toX) == 1)// 過河後可往前或左右
					{
						return true;
					}
				}
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