package chessGame.data.chess;

import chessGame.data.ChessGameData;
import chessGame.data.LocationPoint;
import chessGame.data.status.GameStatus;

public class Elephant extends ChessView {

	public Elephant(String path, int color, boolean cover, int chessX, int chessY, ChessGameData data) {
		super(path, color, cover, chessX, chessY, data);
		// TODO Auto-generated constructor stub
		setPriority(5);
		setName("Elephant");
		if (color == 0) {
			setChineseName("相");
		} else {
			setChineseName("象");
		}
		setEatRule("Rook,Horse,Cannon,Pawn,Elephant");
	}

	public Elephant(String path, int color, boolean cover, LocationPoint point, ChessGameData data) {
		super(path, color, cover, point, data);
		// TODO Auto-generated constructor stub
		setPriority(5);
		setName("Elephant");
		if (color == 0) {
			setChineseName("相");
		} else {
			setChineseName("象");
		}
		setEatRule("Rook,Horse,Cannon,Pawn,Elephant");
	}

	@Override
	public boolean moveRule(int toX, int toY) {
		if (getData().getGameStatus().getChessStatus().getWhichGame() == chinessChess) {// 軍棋
			if (this.getColor() == red) { // 假如為紅色
				if (toY > 4 && toY < 10 && toX > -1 && toX < 9) { // 假如沒過河或超過範圍

					if ((getChessX() + 2) == toX && getChessY() + 2 == toY) { // 只能斜向移動 往右邊移動
						if (getData().getGameStatus().getChessList().getChessList()[getChessY() + 1][getChessX() + 1] == null) { // 如果沒有塞象眼
							return true;
						} else {
							return false;
						}
					} else if ((getChessX() - 2) == toX && getChessY() + 2 == toY)// 往左邊移動
					{
						if (getData().getGameStatus().getChessList().getChessList()[getChessY() + 1][getChessX() - 1] == null) { // 如果沒有塞象眼
							return true;
						} else {
							return false;
						}
					} else if ((getChessX() - 2) == toX && getChessY() - 2 == toY) { // 只能斜向移動
						if (getData().getGameStatus().getChessList().getChessList()[getChessY() - 1][getChessX() - 1] == null) { // 如果沒有塞象眼
							return true;
						} else {
							return false;
						}
					} else if ((getChessX() + 2) == toX && getChessY() - 2 == toY) { // 只能斜向移動
						if (getData().getGameStatus().getChessList().getChessList()[getChessY() - 1][getChessX() + 1] == null) { // 如果沒有塞象眼
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
					if ((getChessX() + 2) == toX && getChessY() + 2 == toY) { // 只能斜向移動
						if (getData().getGameStatus().getChessList().getChessList()[getChessY() + 1][getChessX() + 1] == null) { // 如果沒有塞象眼
							return true;
						} else {
							return false;
						}
					} else if ((getChessX() - 2) == toX && getChessY() + 2 == toY)// 往左邊移動
					{
						if (getData().getGameStatus().getChessList().getChessList()[getChessY() + 1][getChessX() - 1] == null) { // 如果沒有塞象眼
							return true;
						} else {
							return false;
						}
					} else if ((getChessX() - 2) == toX && getChessY() - 2 == toY) { // 只能斜向移動
						if (getData().getGameStatus().getChessList().getChessList()[getChessY() - 1][getChessX() - 1] == null) { // 如果沒有塞象眼
							return true;
						} else {
							return false;
						}
					} else if ((getChessX() + 2) == toX && getChessY() - 2 == toY) { // 只能斜向移動
						if (getData().getGameStatus().getChessList().getChessList()[getChessY() - 1][getChessX() + 1] == null) { // 如果沒有塞象眼
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
			if ((Math.abs(getChessX() - toX) == 1) && getChessY() == toY) {
				return true;
			} else if ((Math.abs(getChessY() - toY) == 1) && getChessX() == toX) {
				return true;
			}
		}
		return false;
	};
}