package Chess;

public class Elephant extends Chess{
	public Elephant(int color , boolean chessCover , int x ,int y)
	{
		super(color, chessCover, x, y);
		setName("Elephant");
//		setEatRule(eatRule);
	}
	@Override
	public boolean moveRule(int toX ,int toY ,int color)
	{
		
		return false;
	};
}