package chessGame.data.chess;

import chessGame.data.ChessGameData;
import chessGame.data.LocationPoint;
import chessGame.data.status.GameStatus;

public class King extends ChessView {
	public King(String path, int color, boolean cover, int chessX, int chessY, ChessGameData data) {
		super(path, color, cover, chessX, chessY, data);
		// TODO Auto-generated constructor stub
		setPriority(7);
		setName("King");
		if (color == 0) {
			setChineseName("帥");
		} else {
			setChineseName("將");
		}
		setEatRule("Cannon,Elephant,Horse,King,Rook,Warrior");
	}

	public King(String path, int color, boolean cover, LocationPoint point, ChessGameData data) {
		super(path, color, cover, point, data);
		// TODO Auto-generated constructor stub
		setPriority(7);
		setName("King");
		if (color == 0) {
			setChineseName("帥");
		} else {
			setChineseName("將");
		}
		setEatRule("Cannon,Elephant,Horse,King,Rook,Warrior");
	}

	@Override
	public boolean moveRule(int toX, int toY) {
		if (getData().getGameStatus().getChessStatus().getWhichGame() == chinessChess) {

			if (this.getColor() == red) { // 假如為紅色
				if (getData().getGameStatus().getChessList().getChessList()[toY][toX] != null && getData().getGameStatus().getChessList().getChessList()[toY][toX].getName().equals("King"))// 飛將
				{
					for (int i = getChessY(); i > 0; i--) {
						if (getData().getGameStatus().getChessList().getChessList()[i][toX] != null) {
							return false;
						}
					}
					return true;
				}
				if (toX < 6 && toX > 2 && toY > 6 && toY < 10) {
					if (toX == getChessX() && Math.abs(toY - getChessY()) == 1) { // 只能移動Y軸
						return true;
					} else if (toY == getChessY() && Math.abs(toX - getChessX()) == 1) {
						return true;
					}
				} else {
					return false;
				}
			} else if (this.getColor() == black) { // 假如為黑色
				if (getData().getGameStatus().getChessList().getChessList()[toY][toX] != null && getData().getGameStatus().getChessList().getChessList()[toY][toX].getName().equals("King"))// 飛將
				{
					for (int i = getChessY(); i <= 9; i++) {
						if (getData().getGameStatus().getChessList().getChessList()[i][toX] != null) {
							return false;
						}
					}
					return true;
				}
				if (toX < 6 && toX > 2 && toY > -1 && toY < 5) {
					if (toX == getChessX() && Math.abs(toY - getChessY()) == 1) { // 只能移動Y軸
						return true;
					} else if (toY == getChessY() && Math.abs(toX - getChessX()) == 1) {
						return true;
					} else {
						return false;
					}
				}
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
