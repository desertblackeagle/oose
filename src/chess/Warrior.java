package chess;

import controlUnit.LocationPoint;

public class Warrior extends Chess {
	static final int chinessChess = 1;
	static final int red = 0;
	static final int black = 1;

	public Warrior(int color, boolean chessCover, int x, int y, Chess[][] board) {
		super(color, chessCover, x, y, board);
		setName("Warrior");
		if (color == 0) {
			setChineseName("仕");
		} else {
			setChineseName("士");
		}
		setEatRule("Cannon,Elephant,Horse,Pawn,Rook,Warrior");
	}

	public Warrior(int color, boolean chessCover, LocationPoint point, Chess[][] board) {
		super(color, chessCover, point.getX(), point.getY(), board);
		setName("Warrior");
		if (color == 0) {
			setChineseName("仕");
		} else {
			setChineseName("士");
		}
		setEatRule("Cannon,Elephant,Horse,Pawn,Rook,Warrior");
	}

	@Override
	public boolean moveRule(int toX, int toY, int whichGame, Chess[][] board) {
		if (whichGame == chinessChess) {
			if (this.getColor() == red) { // 假如為紅色
				if (toX >= 3 && toX <= 5 && toY <= 9 && toY >= 7) { // 判斷是否在九宮格內
					if (Math.abs(toX - getX()) == 1 && getY() + 1 == toY) { // 只能斜向移動
						return true;
					} else if (Math.abs(toX - getX()) == 1 && getY() - 1 == toY) {// 只能斜向移動
						return true;
					}

				} else {
					return false;
				}
			}

			else if (this.getColor() == black) {// 假如為黑色
				if (toX >= 3 && toX <= 5 && toY <= 2 && toY >= 0) {// 判斷是否在九宮格內
					if ((getX() + 1) == toX && getY() + 1 == toY) { // 只能斜向移動
						return true;
					} else if ((getX() - 1) == toX && getY() - 1 == toY) {// 只能斜向移動
						return true;
					}

				} else {
					return false;
				}
			}
		}
		return false;
	}
}