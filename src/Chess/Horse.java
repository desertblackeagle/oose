package Chess;

public class Horse extends Chess{

	public Horse(int color , boolean chessCover , int x ,int y)
	{
		super(color, chessCover, x, y);
		setName("Horse");
//		setEatRule(eatRule);
	}
	@Override
	public boolean moveRule(int toX ,int toY ,int color)
	{
		
		return false;
	};
}
