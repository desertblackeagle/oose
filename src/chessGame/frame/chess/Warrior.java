package chessGame.frame.chess;

import chessGame.data.ChessGameData;
import chessGame.data.LocationPoint;

public class Warrior extends ChessView {
	public Warrior(String path, int color, boolean cover, int chessX, int chessY, ChessGameData data) {
		super(path, color, cover, chessX, chessY, data);
		// TODO Auto-generated constructor stub
		setPriority(6);
		setName("Warrior");
		if (color == 0) {
			setChineseName("仕");
		} else {
			setChineseName("士");
		}
		setEatRule("Cannon,Elephant,Horse,Pawn,Rook,Warrior");
	}

	public Warrior(String path, int color, boolean cover, LocationPoint point, ChessGameData data) {
		super(path, color, cover, point, data);
		// TODO Auto-generated constructor stub
		setPriority(6);
		setName("Warrior");
		if (color == 0) {
			setChineseName("仕");
		} else {
			setChineseName("士");
		}
		setEatRule("Cannon,Elephant,Horse,Pawn,Rook,Warrior");
	}

	@Override
	public boolean moveRule(int toX, int toY) {
		if (getData().getGameStatus().getChessStatus().getWhichGame() == chinessChess) {
			if (this.getColor() == red) { // 假如為紅色
				if (toX >= 3 && toX <= 5 && toY <= 9 && toY >= 7) { // 判斷是否在九宮格內
					if (Math.abs(toX - getChessX()) == 1 && Math.abs(toY - getChessY()) == 1) { // 只能斜向移動
						return true;
					}
				} else {
					return false;
				}
			} else if (this.getColor() == black) {// 假如為黑色
				if (toX >= 3 && toX <= 5 && toY <= 2 && toY >= 0) {// 判斷是否在九宮格內
					if (Math.abs(toX - getChessX()) == 1 && Math.abs(toY - getChessY()) == 1) { // 只能斜向移動
						return true;
					}
				} else {
					return false;
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