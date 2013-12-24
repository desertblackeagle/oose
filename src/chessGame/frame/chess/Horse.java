package chessGame.frame.chess;

import chessGame.data.ChessGameData;
import chessGame.data.GameStatus;
import chessGame.data.LocationPoint;

public class Horse extends ChessView {
	public Horse(String path, int color, boolean cover, int chessX, int chessY, ChessGameData data) {
		super(path, color, cover, chessX, chessY, data);
		// TODO Auto-generated constructor stub
		setPriority(3);
		setName("Horse");
		if (color == 0) {
			setChineseName("傌");
		} else {
			setChineseName("馬");
		}
		setEatRule("Horse,Cannon,Pawn");
	}

	public Horse(String path, int color, boolean cover, LocationPoint point, ChessGameData data) {
		super(path, color, cover, point, data);
		// TODO Auto-generated constructor stub
		setPriority(3);
		setName("Horse");
		if (color == 0) {
			setChineseName("傌");
		} else {
			setChineseName("馬");
		}
		setEatRule("Horse,Cannon,Pawn");
	}

	@Override
	public boolean moveRule(int toX, int toY) {
		if (getData().getGameStatus().getChessStatus().getWhichGame() == chinessChess)// 軍棋
		{
			if (Math.abs(toX - getChessX()) == 2 && Math.abs(toY - getChessY()) == 1) {
				if (getData().getGameStatus().getChessList().getChessList()[getChessY()][getChessX() + ((toX - getChessX()) / 2)] != null) {
					return false;
				}
				return true;
			} else if (Math.abs(toY - getChessY()) == 2 && Math.abs(toX - getChessX()) == 1) {
				if (getData().getGameStatus().getChessList().getChessList()[getChessY() + ((toY - getChessY()) / 2)][getChessX()] != null) {
					return false;
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