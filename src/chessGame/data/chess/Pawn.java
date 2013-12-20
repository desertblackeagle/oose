package chessGame.data.chess;

import chessGame.data.ChessGameData;
import chessGame.data.LocationPoint;
import chessGame.data.status.GameStatus;

public class Pawn extends ChessView {
	public Pawn(String path, int color, boolean cover, int chessX, int chessY, ChessGameData data) {
		super(path, color, cover, chessX, chessY, data);
		// TODO Auto-generated constructor stub
		setPriority(1);
		setName("Pawn");
		setEatRule("King,Pawn");
	}

	public Pawn(String path, int color, boolean cover, LocationPoint point, ChessGameData data) {
		super(path, color, cover, point, data);
		// TODO Auto-generated constructor stub
		setPriority(1);
		setName("Pawn");
		setEatRule("King,Pawn");
	}

	@Override
	public boolean moveRule(int toX, int toY) {
		if (getData().getGameStatus().getChessStatus().getWhichGame() == chinessChess)// 軍棋
		{
			if (getColor() == red)// 紅色
			{
				if (getChessY() > 4)// 只能往前走
				{
					if (getChessY() - toY == 1 && toX == getChessX()) {
						return true;
					}
				} else if (getChessY() <= 4) {
					if ((Math.abs(getChessX() - toX) + Math.abs(getChessY() - toY)) == 1) {
						if ((getChessY() - toY) != -1) {
//							System.out.println("Debug " + getChessX() + " " + getChessY() + "," + toX + " " + toY);
							return true;
						}
					}
//					if (getChessY() - toY == 1 || Math.abs(getChessX() - toX) == 1)// 過河後可往前或左右
//					{
//						return true;
//					}
				}
			} else// 黑色
			{
				if (getChessY() < 5)// 只能往前走
				{
					if (toY - getChessY() == 1 && toX == getChessX()) {
						return true;
					}
				} else if (getChessY() >= 5) {
					if ((Math.abs(getChessX() - toX) + Math.abs(getChessY() - toY)) == 1) {
						if ((getChessY() - toY) != 1) {
							System.out.println("Debug " + getChessX() + " " + getChessY() + "," + toX + " " + toY);
							return true;
						}
					}
//					if (getChessY() - toY == -1 || Math.abs(getChessX() - toX) == 1)// 過河後可往前或左右
//					{
////						System.out.println("Debug " + getChessX() + " " + getChessY() + "," + toX + " " + toY);
//						return true;
//					}
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