package Chess;

import Chess.Chess;

public class Pawn extends Chess{
	public Pawn(int color , boolean chessCover , int x ,int y)
	{
		super(color, chessCover, x, y);
		setName("Pawn");
		setEatRule("King,Pawn");
	}
	@Override
	public boolean moveRule(int toX ,int toY ,int whichGame ,Chess[][] board)
	{
		if(whichGame == 1)//軍棋
		{
			if(getColor()==0)//紅色
			{
				if(getY() > 4 )//只能往前走
				{
					if(getY() - toY ==1)
					{
						return true;
					}
				}
				else if (getY() <= 4)
				{
					if(getY() - toY ==1 || Math.abs(getX() - toX) ==1 )//過河後可往前或左右
					{
						return true;
					}
				}
			}
			else//黑色
			{
				if(getY() < 5 )//只能往前走
				{
					if(getY() - toY == -1)
					{
						return true;
					}
				}
				else if (getY() >= 5)
				{
					if(getY() - toY == -1 || Math.abs(getX() - toX) ==1 )//過河後可往前或左右
					{
						return true;
					}
				}
			}
		}
		else//暗棋
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
