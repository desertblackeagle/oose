package chessGame.data.chess;

import chessGame.data.LocationPoint;

public class Cannon extends ChessView {

	public Cannon(String path, int color, boolean cover, int chessX, int chessY) {
		super(path, color, cover, chessX, chessY);
		// TODO Auto-generated constructor stub
		setPriority(2);
		setName("Cannon");
		setEatRule("King,Warrior,Elephant,Rook,Horse,Cannon,Pawn");
	}

	public Cannon(String path, int color, boolean cover, LocationPoint point) {
		super(path, color, cover, point);
		// TODO Auto-generated constructor stub
		setPriority(2);
		setName("Cannon");
		setEatRule("King,Warrior,Elephant,Rook,Horse,Cannon,Pawn");
	}

	@Override
	public boolean moveRule(int toX, int toY, int whichGame, Chess[][] board) {
		int grid = 0;// 格子數
		int count;

		if (toX == getX()) {
			grid = Math.abs(toY - getY());
		} else if (toY == getY()) {
			grid = Math.abs(toX - getX());
		}

		if (board[toY][toX] != null) {
			count = 0;
			for (int i = 0; i < grid - 1; i++) {
				if (toX == getX()) {
					if (toY - getY() < 0) {
						if (board[getY() - 1 - i][toX] != null) {
							count++;
						}
					} else {
						if (board[getY() + 1 + i][toX] != null) {
							count++;
						}
					}
				} else if (toY == getY()) {
					if (toX - getX() < 0) {
						if (board[getY()][toX + 1 + i] != null) {
							count++;
						}
					} else {
						if (board[getY()][toX - 1 - i] != null) {
							count++;
						}
					}
				}

			}
			if (count == 1 && (toX == getX() || toY == getY())) {
				return true;
			} else {
				return false;
			}
		}
		if (whichGame == chinessChess)// 軍棋
		{
			if (toX == getX())// 只移動y軸座標
			{

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

}