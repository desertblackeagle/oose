package chess;

import controlUnit.LocationPoint;

public class King extends Chess {
	static final int chinessChess = 1;
	static final int red = 0;
	static final int black = 1;

	public King(int color, boolean chessCover, int x, int y, Chess[][] board) {
		super(color, chessCover, x, y, board);
		setName("King");
		if (color == 0) {
			setChineseName("帥");
		} else {
			setChineseName("將");
		}
		setEatRule("Cannon,Elephant,Horse,King,Rook,Warrior");
	}

	public King(int color, boolean chessCover, LocationPoint point, Chess[][] board) {
		super(color, chessCover, point.getX(), point.getY(), board);
		setName("King");
//		if (color == 0) {
//			setChineseName("帥");
//		} else {
//			setChineseName("將");
//		}
		setEatRule("Cannon,Elephant,Horse,King,Rook,Warrior");
	}

	@Override
	public boolean moveRule(int toX, int toY, int whichGame, Chess[][] board) {
		if (whichGame == chinessChess) {

			if (this.getColor() == red) { // 假如為紅色
				if (board[toY][toX] != null && board[toY][toX].getName().equals("King"))// 飛將
				{
					for (int i = getY(); i > 0; i--) {
						if (board[i][toX] != null) {
							return false;
						}
					}
					return true;
				}
				if (toX < 6 && toX > 2 && toY > 6 && toY < 10) {
					if (toX == getX() && Math.abs(toY - getY()) == 1) { // 只能移動Y軸
						return true;
					} else if (toY == getY() && Math.abs(toX - getX()) == 1) {
						return true;
					}
				} else {
					return false;
				}
			} else if (this.getColor() == black) { // 假如為黑色
				if (board[toY][toX] != null && board[toY][toX].getName().equals("King"))// 飛將
				{
					for (int i = getY(); i <= 9; i++) {
						if (board[i][toX] != null) {
							return false;
						}
					}
					return true;
				}
				if (toX < 6 && toX > 2 && toY > -1 && toY < 5) {
					if (toX == getX() && Math.abs(toY - getY()) == 1) { // 只能移動Y軸
						return true;
					} else if (toY == getY() && Math.abs(toX - getX()) == 1) {
						return true;
					} else {
						return false;
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
			setChineseName("帥");
		} else {
			setChineseName("將");
		}
	};
}
