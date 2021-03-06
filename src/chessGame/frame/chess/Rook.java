package chessGame.frame.chess;

import chessGame.data.ChessGameData;
import chessGame.data.LocationPoint;

public class Rook extends ChessView {
	public Rook(String path, int color, boolean cover, int chessX, int chessY, ChessGameData data) {
		super(path, color, cover, chessX, chessY, data);
		// TODO Auto-generated constructor stub
		setPriority(4);
		setName("Rook");
		if (color == 0) {
			setChineseName("俥");
		} else {
			setChineseName("車");
		}
		setEatRule("Rook,Horse,Cannon,Pawn");
	}

	public Rook(String path, int color, boolean cover, LocationPoint point, ChessGameData data) {
		super(path, color, cover, point, data);
		// TODO Auto-generated constructor stub
		setPriority(4);
		setName("Rook");
		if (color == 0) {
			setChineseName("俥");
		} else {
			setChineseName("車");
		}
		setEatRule("Rook,Horse,Cannon,Pawn");
	}

	@Override
	public boolean moveRule(int toX, int toY) {
		int grid;// 格子數
		if (getData().getGameStatus().getChessStatus().getWhichGame() == chinessChess)// 軍棋
		{
			if (toX == getChessX())// 只移動y軸座標
			{
				grid = Math.abs(toY - getChessY());
				if (toY - getChessY() < 0) {
					for (int i = 0; i < grid - 1; i++) {
						if (getData().getGameStatus().getChessList().getChessList()[getChessY() - 1 - i][toX] != null) {
							return false;
						}
					}
				} else {
					for (int i = 0; i < grid - 1; i++) {
						if (getData().getGameStatus().getChessList().getChessList()[getChessY() + 1 + i][toX] != null) {
							return false;
						}
					}
				}
				return true;
			} else if (toY == getChessY())// 只移動x軸座標
			{
				grid = Math.abs(toX - getChessX());
				if (toX - getChessX() < 0) {
					for (int i = 0; i < grid - 1; i++) {
						if (getData().getGameStatus().getChessList().getChessList()[toY][getChessX() - i - 1] != null) {
							return false;
						}
					}
				} else {
					for (int i = 0; i < grid - 1; i++) {
						if (getData().getGameStatus().getChessList().getChessList()[toY][getChessX() + i + 1] != null) {
							return false;
						}
					}
				}
				return true;
			}
		} else// 暗棋
		{
			if ((Math.abs(getChessX() - toX) == 1) && getChessY() == toY) {
				return true;
			} else if ((Math.abs(getChessY() - toY) == 1) && getChessX() == toX) {
				return true;
			}
		}
		return false;

	};

}