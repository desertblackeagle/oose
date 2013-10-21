package Chess;

public class Rook extends Chess{

	public Rook(int color , boolean chessCover , int x ,int y)
	{
		super(color, chessCover, x, y);
		setName("Rook");
		setEatRule("Rook,Horse,Cannon,Pawn");
	}
	@Override
	public boolean moveRule()
	{
		
		return false;
	};
}
