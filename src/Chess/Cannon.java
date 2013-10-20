package Chess;

public class Cannon extends Chess{
	public Cannon(int color , boolean chessCover , int x ,int y)
	{
		super(color, chessCover, x, y);
		setName("Cannon");
//		setEatRule(eatRule);
	}
	@Override
	public boolean moveRule()
	{
		
		return false;
	};
}
