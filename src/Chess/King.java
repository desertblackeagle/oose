package Chess;

public class King extends Chess{
	public King(int color , boolean chessCover , int x ,int y)
	{
		super(color, chessCover, x, y);
		setName("King");
//		setEatRule(eatRule);
	}
	@Override
	public boolean moveRule(int toX ,int toY ,int color ,Chess[][] board)
	{
		
		return false;
	};
}

