package Chess;

public class Rook extends Chess{

	public Rook(int color , boolean chessCover , int x ,int y)
	{
		super(color, chessCover, x, y);
		setName("Rook");
		setEatRule("Rook,Horse,Cannon,Pawn");
	}
	@Override
	public boolean moveRule(int toX ,int toY ,int whichGame ,Chess[][] board)
	{
		if(whichGame == 1)//無法判斷中途是否有棋子
		{
			if(toX == getX())//只移動y軸座標
			{
				return true;
			}
			else if(toY == getY())//只移動x軸座標
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			if((getX()+ 1) == toX || (getX()- 1) == toX)//
			{
				return true;
			}
			else if((getY()+ 1) == toY || (getY()- 1) == toY)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
	};
}
