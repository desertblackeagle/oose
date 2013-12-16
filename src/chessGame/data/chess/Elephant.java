package chessGame.data.chess;

import chessGame.data.LocationPoint;

public class Elephant extends ChessView {

	public Elephant(String path, int color, boolean cover, int chessX, int chessY) {
		super(path, color, cover, chessX, chessY);
		// TODO Auto-generated constructor stub
		setPriority(5);
		setName("Elephant");
		setEatRule("Rook,Horse,Cannon,Pawn,Elephant");
	}

	public Elephant(String path, int color, boolean cover, LocationPoint point) {
		super(path, color, cover, point);
		// TODO Auto-generated constructor stub
		setPriority(5);
		setName("Elephant");
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
}