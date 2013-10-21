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
		if(whichGame == 1)//�x��
		{
			if(getColor()==0)//����
			{
				if(getY() > 4 )//�u�੹�e��
				{
					if(getY() - toY ==1)
					{
						return true;
					}
				}
				else if (getY() <= 4)
				{
					if(getY() - toY ==1 || Math.abs(getX() - toX) ==1 )//�L�e��i���e�Υ��k
					{
						return true;
					}
				}
			}
			else//�¦�
			{
				if(getY() < 5 )//�u�੹�e��
				{
					if(getY() - toY == -1)
					{
						return true;
					}
				}
				else if (getY() >= 5)
				{
					if(getY() - toY == -1 || Math.abs(getX() - toX) ==1 )//�L�e��i���e�Υ��k
					{
						return true;
					}
				}
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
