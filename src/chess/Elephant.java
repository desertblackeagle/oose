package chess;

import controlUnit.LocationPoint;

public class Elephant extends Chess {

	public Elephant(int color, boolean chessCover, int x, int y, Chess[][] board) {
		super(color, chessCover, x, y, board);
		setName("Elephant");
		if (color == red) {
			setChineseName("相");
		} else {
			setChineseName("象");
		}
		setEatRule("Rook,Horse,Cannon,Pawn,Elephant");
	}

	public Elephant(int color, boolean chessCover, LocationPoint point, Chess[][] board) {
		super(color, chessCover, point.getX(), point.getY(), board);
		setName("Elephant");
//		if (color == 0) {
//			setChineseName("相");
//		} else {
//			setChineseName("象");
//		}
		setEatRule("Rook,Horse,Cannon,Pawn,Elephant");
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

	@Override
	public void setChessCover(boolean cover) {
		// TODO Auto-generated method stub
		super.setChessCover(cover);
		if (getColor() == red) {
			setChineseName("相");
		} else {
			setChineseName("象");
		}
	};
}