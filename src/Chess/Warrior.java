package Chess;

public class Warrior extends Chess{
	public Warrior(int color , boolean chessCover , int x ,int y)
	{
		super(color, chessCover, x, y);
		setName("Warrior");
//		setEatRule(eatRule);
	}
	@Override
	public boolean moveRule(int toX ,int toY ,int color)
	{
		
		return false;
	};
}