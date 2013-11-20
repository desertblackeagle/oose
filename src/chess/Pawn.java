package chess;

import controlUnit.LocationPoint;

public class Pawn extends Chess {
//	static final int chinessChess = 1;
//	static final int red = 0;

	public Pawn(int color, boolean chessCover, int x, int y, Chess[][] board) {
		super(color, chessCover, x, y, board);
		setName("Pawn");
		if (color == 0) {
			setChineseName("兵");
		} else {
			setChineseName("卒");
		}

		setEatRule("King,Pawn");
	}

	public Pawn(int color, boolean chessCover, LocationPoint point, Chess[][] board) {
		super(color, chessCover, point.getX(), point.getY(), board);
		setName("Pawn");
//		if (color == 0) {
//			setChineseName("兵");
//		} else {
//			setChineseName("卒");
//		}
		setEatRule("King,Pawn");
	}

	@Override
	public boolean moveRule(int toX, int toY, int whichGame, Chess[][] board) {
		if (whichGame == chineseChess)// 軍棋
		{
			if (getColor() == red)// 紅色
			{
				if (getY() > 4)// 只能往前走
				{
					if (getY() - toY == 1 && toX == getX()) {
						return true;
					}
				} else if (getY() <= 4) {
					if (getY() - toY == 1 || Math.abs(getX() - toX) == 1)// 過河後可往前或左右
					{
						return true;
					}
				}
			} else// 黑色
			{
				if (getY() < 5)// 只能往前走
				{
					if (toY - getY() == 1 && toX == getX()) {
						return true;
					}
				} else if (getY() >= 5) {
					if (getY() - toY == -1 || Math.abs(getX() - toX) == 1)// 過河後可往前或左右
					{
						return true;
					}
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
		if (getColor() == 0) {
			setChineseName("兵");
		} else {
			setChineseName("卒");
		}
	};
}