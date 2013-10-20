package Chess;

public class Rook extends Chess{
//	String[] eatRule = new String[4];
//	eatRule[0]="Rook";
//	eatRule[1]="Horse";
//	eatRule[2]="Cannon";
//	eatRule[3]="Pawn";
	public Rook(int color , boolean chessCover , int x ,int y)
	{
		super(color, chessCover, x, y);
		setName("Rook");
//		setEatRule(eatRule);
	}
	@Override
	public boolean moveRule()
	{
		
		return false;
	};
}
