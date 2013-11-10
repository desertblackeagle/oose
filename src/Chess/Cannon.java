package Chess;

import Chess.Chess;

public class Cannon extends Chess {
	public Cannon(int color, boolean chessCover, int x, int y) {
		super(color, chessCover, x, y);
		setName("Cannon");
		setEatRule("King,Guard,Bishop,Rook,Horse,Cannon,Pawn");
	}

	@Override
	public boolean moveRule(int toX, int toY, int whichGame, Chess[][] board) {
		int grid=0;// 格子數
		int count;
		
//		if(toX == getX())
//		{
//			grid = Math.abs(toY - getY());
//		}
//		else if(toY == getY())
//		{
//			grid = Math.abs(toX - getX());
//		}
		count=0;
		if(board[toY][toX] != null)
		{
			if(toX == getX()  )
			{
				if(toY -getY() > 0)
				{
					for(int i= getY() +1 ; i < toY -1 ; i++ )
					{
						if (board[i][toX] != null) {
							count++;
						}
					}
				}
				else
				{
					for(int i= toY +1 ; i < getY() -1 ; i++ )
					{
						if (board[i][toX] != null) {
							count++;
						}
					}
				}
				
			}
			else if(toY == getY()  )
			{
				if(toX -getX() > 0)
				{
					for(int i= getX() +1 ; i < toX -1 ; i++ )
					{
						if (board[i][toX] != null) {
							count++;
						}
					}
				}
				else
				{
					for(int i= toX +1 ; i < getX() -1 ; i++ )
					{
						if (board[i][toX] != null) {
							count++;
						}
					}
				}
				
			}
		
			if(count ==1 && toX == getX() || toY == getY() )
			{	
				return true;
			}
			else
			{
				return false;
			}
		}
		if (whichGame == 1)// 軍棋
		{
			if (toX == getX())// 只移動y軸座標
			{
				
				if(toY - getY() < 0){
					for (int i = 0; i < grid - 1; i++) {
						if (board[getY() - 1 - i][toX] != null) {
							return false;
						}
					}
				}else{
					for (int i = 0; i < grid - 1; i++) {
						if (board[getY() + 1 + i][toX] != null) {
							return false;
						}
					}
				}
				
				return true;
			} else if (toY == getY())// 只移動x軸座標
			{
				
				if(toX - getX() < 0){
					for (int i = 0; i < grid - 1; i++) {
						if (board[toY][getX() - i - 1] != null) {
							return false;
						}
					}
				}else{
					for (int i = 0; i < grid - 1; i++) {
						if (board[toY][getX() + i + 1] != null) {
							return false;
						}
					}
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