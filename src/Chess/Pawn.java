package Chess;

public class Pawn extends Chess{
	public Pawn(int color , boolean chessCover , int x ,int y)
	{
		super(color, chessCover, x, y);
		setName("Pawn");
//		setEatRule(eatRule);
	}
	@Override
	public boolean moveRule(int toX ,int toY ,int whichGame ,Chess[][] board)
	{
		
		return true;
	};
}
