package chessGame.data.chess;

import chessGame.data.LocationPoint;

public class Warrior extends ChessView {
	public Warrior(String path, int color, boolean cover, int chessX, int chessY) {
		super(path, color, cover, chessX, chessY);
		// TODO Auto-generated constructor stub
		setPriority(6);
		setName("Warrior");
		setEatRule("Cannon,Elephant,Horse,Pawn,Rook,Warrior");
	}

	public Warrior(String path, int color, boolean cover, LocationPoint point) {
		super(path, color, cover, point);
		// TODO Auto-generated constructor stub
		setPriority(6);
		setName("Warrior");
		setEatRule("Cannon,Elephant,Horse,Pawn,Rook,Warrior");
	}

	@Override
	public boolean moveRule(int toX, int toY, int whichGame, Chess[][] board) {
		if (whichGame == chinessChess) {
			if (this.getColor() == red) { // 假如為紅色
				if (toX >= 3 && toX <= 5 && toY <= 9 && toY >= 7) { // 判斷是否在九宮格內
					if (Math.abs(toX - getX()) == 1 && Math.abs(toY - getY()) == 1) { // 只能斜向移動
						return true;
					}
				} else {
					return false;
				}
			} else if (this.getColor() == black) {// 假如為黑色
				if (toX >= 3 && toX <= 5 && toY <= 2 && toY >= 0) {// 判斷是否在九宮格內
					if (Math.abs(toX - getX()) == 1 && Math.abs(toY - getY()) == 1) { // 只能斜向移動
						return true;
					}
				} else {
					return false;
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