package Chess;

import Chess.Chess;

public class Cannon extends Chess{
	public Cannon(int color , boolean chessCover , int x ,int y)
	{
		super(color, chessCover, x, y);
		setName("Cannon");
		setEatRule("King,Guard,Bishop,Rook,Horse,Cannon,Pawn");
	}
	@Override
	public boolean moveRule(int toX ,int toY ,int whichGame ,Chess[][] board)
	{
		int grid;//��l��
		if(whichGame == 1)//�x��
		{
			if(toX == getX() )//�u����y�b�y��
			{
				grid = Math.abs(toY - getY());
			
				for(int i=0; i < grid-1 ; i++)
				{
					if(board[getY()+1+i][toX] != null)
					{
						return false;
					}
				}
				return true;		
			}
			else if(toY == getY())//�u����x�b�y��
			{
				grid = Math.abs(toY - getY());
				
				for(int i=0; i < grid-1 ; i++)
				{
					if(board[toY][getX()+i+1] != null)
					{
						return false;
					}
				}
				return true;
			}
		}
		else//�t��
		{
			if((Math.abs(getX() - toX) == 1) && getY() == toY)
			{
				return true;
			}
			else if((Math.abs(getY() - toY) == 1) && getX() == toX)
			{
				return true;
			}
		}
		return false;
	};
}
