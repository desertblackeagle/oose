package chess;

import controlUnit.LocationPoint;

public class Elephant extends Chess {
	static final int chinessChess = 1;
	static final int red = 0;
	static final int black = 1;

	public Elephant(int color, boolean chessCover, int x, int y, Chess[][] board) {
		super(color, chessCover, x, y, board);
		setName("Elephant");
		if (color == 0) {
			setChineseName("相");
		} else {
			setChineseName("象");
		}
		setEatRule("Rook,Horse,Cannon,Pawn");
	}

	public Elephant(int color, boolean chessCover, LocationPoint point, Chess[][] board) {
		super(color, chessCover, point.getX(), point.getY(), board);
		setName("Elephant");
		if (color == 0) {
			setChineseName("相");
		} else {
			setChineseName("象");
		}
		setEatRule("Rook,Horse,Cannon,Pawn");
	}

	@Override
	public boolean moveRule(int toX, int toY, int whichGame, Chess[][] board) {
		if (whichGame == chinessChess) {// 軍棋
			if (this.getColor() == red) { // 假如為紅色
				if (toY > 4 && toY < 10 && toX > -1 && toX < 9) { // 假如沒過河或超過範圍

					if ((getX() + 2) == toX && getY() + 2 == toY) { // 只能斜向移動 往右邊移動
						if (board[getY() + 1][getX() + 1] == null) { // 如果沒有塞象眼
							return true;
						} else {
							return false;
						}
					} else if ((getX() - 2) == toX && getY() + 2 == toY)// 往左邊移動
					{
						if (board[getY() + 1][getX() - 1] == null) { // 如果沒有塞象眼
							return true;
						} else {
							return false;
						}
					} else if ((getX() - 2) == toX && getY() - 2 == toY) { // 只能斜向移動
						if (board[getY() - 1][getX() - 1] == null) { // 如果沒有塞象眼
							return true;
						} else {
							return false;
						}
					} else if ((getX() + 2) == toX && getY() - 2 == toY) { // 只能斜向移動
						if (board[getY() - 1][getX() + 1] == null) { // 如果沒有塞象眼
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else if (this.getColor() == black) {// 假如為黑色
				if (toY > -1 && toY < 5 && toX > -1 && toX < 9) { // 假如沒過河或超過範圍
					if ((getX() + 2) == toX && getY() + 2 == toY) { // 只能斜向移動
						if (board[getY() + 1][getX() + 1] == null) { // 如果沒有塞象眼
							return true;
						} else {
							return false;
						}
					} else if ((getX() - 2) == toX && getY() + 2 == toY)// 往左邊移動
					{
						if (board[getY() + 1][getX() - 1] == null) { // 如果沒有塞象眼
							return true;
						} else {
							return false;
						}
					} else if ((getX() - 2) == toX && getY() - 2 == toY) { // 只能斜向移動
						if (board[getY() - 1][getX() - 1] == null) { // 如果沒有塞象眼
							return true;
						} else {
							return false;
						}
					} else if ((getX() + 2) == toX && getY() - 2 == toY) { // 只能斜向移動
						if (board[getY() - 1][getX() + 1] == null) { // 如果沒有塞象眼
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return false;
	}
}