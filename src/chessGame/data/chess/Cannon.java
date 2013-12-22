package chessGame.data.chess;

import chessGame.data.ChessGameData;
import chessGame.data.LocationPoint;
import chessGame.data.status.GameStatus;

public class Cannon extends ChessView {

	public Cannon(String path, int color, boolean cover, int chessX, int chessY, ChessGameData data) {
		super(path, color, cover, chessX, chessY, data);
		// TODO Auto-generated constructor stub
//		data.getGameStatus().getChessList().getChineseChessList()[chessY][chessX] = this;
		setPriority(2);
		setName("Cannon");
		if (color == 0) {
			setChineseName("炮");
		} else {
			setChineseName("包");
		}
		setEatRule("King,Warrior,Elephant,Rook,Horse,Cannon,Pawn");
	}

	public Cannon(String path, int color, boolean cover, LocationPoint point, ChessGameData data) {
		super(path, color, cover, point, data);
		// TODO Auto-generated constructor stub
//		data.getGameStatus().getChessList().getTaiwanChessList()[point.getY()][point.getX()] = this;
		setPriority(2);
		setName("Cannon");
		if (color == 0) {
			setChineseName("炮");
		} else {
			setChineseName("包");
		}
		setEatRule("King,Warrior,Elephant,Rook,Horse,Cannon,Pawn");
	}

	@Override
	public boolean moveRule(int toX, int toY) {
		int grid = 0;// 格子數
		int count;

		if (toX == getChessX()) {
			grid = Math.abs(toY - getChessY());
		} else if (toY == getChessY()) {
			grid = Math.abs(toX - getChessX());
		}

		if (getData().getGameStatus().getChessList().getChessList()[toY][toX] != null) {
			count = 0;
			for (int i = 0; i < grid - 1; i++) {
				if (toX == getChessX()) {
					if (toY - getChessY() < 0) {
						if (getData().getGameStatus().getChessList().getChessList()[getChessY() - 1 - i][toX] != null) {
							count++;
						}
					} else {
						if (getData().getGameStatus().getChessList().getChessList()[getChessY() + 1 + i][toX] != null) {
							count++;
						}
					}
				} else if (toY == getChessY()) {
					if (toX - getChessX() < 0) {
						if (getData().getGameStatus().getChessList().getChessList()[getChessY()][toX + 1 + i] != null) {
							count++;
						}
					} else {
						if (getData().getGameStatus().getChessList().getChessList()[getChessY()][toX - 1 - i] != null) {
							count++;
						}
					}
				}

			}
			if (count == 1 && (toX == getChessX() || toY == getChessY())) {
				return true;
			} else {
				return false;
			}
		}
		if (getData().getGameStatus().getChessStatus().getWhichGame() == chinessChess)// 軍棋
		{
			if (toX == getChessX())// 只移動y軸座標
			{

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