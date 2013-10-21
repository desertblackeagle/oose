package Chess;

import Chess.Chess;

public class Horse extends Chess {

	public Horse(int color, boolean chessCover, int x, int y) {
		super(color, chessCover, x, y);
		setName("Horse");
		setEatRule("Horse,Cannon,Pawn");
	}

	@Override
	public boolean moveRule(int toX, int toY, int whichGame, Chess[][] board) {
		if (whichGame == 1)// 軍棋
		{
			if (Math.abs(toX - getX()) == 2 && Math.abs(toY - getY()) == 1) {
				if (board[getY()][getX() + 1] != null || board[getY()][getX() - 1] != null) {
					return false;
				}
				return true;
			} else if (Math.abs(toY - getY()) == 2 && Math.abs(toX - getX()) == 1) {
				if (board[getY() + 1][getX()] != null || board[getY() - 1][getX()] != null) {
					return false;
				}
				return true;
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