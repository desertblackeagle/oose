package chess;

import chess.Chess;
import controlUnit.LocationPoint;

public class Rook extends Chess {

	public Rook(int color, boolean chessCover, int x, int y, Chess[][] board) {
		super(color, chessCover, x, y, board);
		setName("Rook");
		if (color == red) {
			setChineseName("俥");
		} else {
			setChineseName("車");
		}
		setEatRule("Rook,Horse,Cannon,Pawn");
	}

	public Rook(int color, boolean chessCover, LocationPoint point, Chess[][] board) {
		super(color, chessCover, point.getX(), point.getY(), board);
		setName("Rook");
		setEatRule("Rook,Horse,Cannon,Pawn");
	}

	@Override
	public boolean moveRule(int toX, int toY, int whichGame, Chess[][] board) {
		int grid;// 格子數
		if (whichGame == chinessChess)// 軍棋
		{
			if (toX == getX())// 只移動y軸座標
			{
				grid = Math.abs(toY - getY());
				if (toY - getY() < 0) {
					for (int i = 0; i < grid - 1; i++) {
						if (board[getY() - 1 - i][toX] != null) {
							return false;
						}
					}
				} else {
					for (int i = 0; i < grid - 1; i++) {
						if (board[getY() + 1 + i][toX] != null) {
							return false;
						}
					}
				}

				return true;

			} else if (toY == getY())// 只移動x軸座標
			{
				grid = Math.abs(toX - getX());
				if (toX - getX() < 0) {
					for (int i = 0; i < grid - 1; i++) {
						if (board[toY][getX() - i - 1] != null) {
							return false;
						}
					}
				} else {
					for (int i = 0; i < grid - 1; i++) {
						if (board[toY][getX() + i + 1] != null) {
							return false;
						}
					}
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

	@Override
	public void setChessCover(boolean cover) {
		// TODO Auto-generated method stub
		super.setChessCover(cover);
		if (getColor() == red) {
			setChineseName("俥");
		} else {
			setChineseName("車");
		}
	};
}