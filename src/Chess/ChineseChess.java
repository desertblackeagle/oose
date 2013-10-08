package Chess;

public class ChineseChess extends chess{
	
	private static int guardCountOfRed = 3;
	private static int guardCountOfBlack = 3;
	private static int bishopCountOfRed = 2;
	private static int bishopCountOfBlack = 2;
	private static int horseCountOfRed = 1;
	private static int horseCountOfBlack = 1;
	private static int rookCountOfRed = 0;
	private static int rookCountOfBlack = 0;
	private static int cannonCountOfRed = 1;
	private static int cannonCountOfBlack = 1;
	private static int pawnCountOfRed = 0;
	private static int pawnCountOfBlack = 0;
	

	public ChineseChess(String name, String color)
	{
		super(name,color);
		setStartPosition();
		setChessCover(false);
	}
//	public ChineseChess(String name, String color, position p)
//	{
//		super(name,color,p);
//	}
//	public ChineseChess(String name, String color, int x, int y)
//	{
//		super(name,color,x,y);
//	}
	
	public void setStartPosition()
	{
		switch(getChessName())
		{
			case "King":
//				System.out.println("king");
				setStartPositionX(4);
				if(getColor().equalsIgnoreCase("r"))
				{
//					System.out.println("r");
					setStartPositionY(9);
				}
					
				else
				{
//					System.out.println("b");
					setStartPositionY(0);
				}
				break;
			case "Guard":
				
//				System.out.println("Guard");
				if(getColor().equalsIgnoreCase("R"))
				{
//					System.out.println("r");
					setStartPositionX(guardCountOfRed);
					setStartPositionY(9);
					guardCountOfRed += 2;
				}
				else
				{
//					System.out.println("b");
					setStartPositionX(guardCountOfBlack);
					setStartPositionY(0);
					guardCountOfBlack += 2;
				}
				break;	
			case "Bishop":
				
//				System.out.println("bishop");
				if(getColor().equalsIgnoreCase("R"))
				{
//					System.out.println("r");
					setStartPositionX(bishopCountOfRed);
					setStartPositionY(9);
					bishopCountOfRed += 4;
				}
				else
				{
//					System.out.println("b");
					setStartPositionX(bishopCountOfBlack);
					setStartPositionY(0);
					bishopCountOfBlack += 4;
				}
				break;
			case "Horse":
				
//				System.out.println("horse");
				if(getColor().equalsIgnoreCase("R"))
				{
//					System.out.println("r");
					setStartPositionX(horseCountOfRed);
					setStartPositionY(9);
					horseCountOfRed += 6;
				}
				else
				{
//					System.out.println("b");
					setStartPositionX(horseCountOfBlack);
					setStartPositionY(0);
					horseCountOfBlack += 6;
				}
				break;
			case "Rook":
				
//				System.out.println("rook");
				if(getColor().equalsIgnoreCase("R"))
				{
//					System.out.println("r");
					setStartPositionX(rookCountOfRed);
					setStartPositionY(9);
					rookCountOfRed += 8;
				}
				else
				{
//					System.out.println("b");
					setStartPositionX(rookCountOfBlack);
					setStartPositionY(0);
					rookCountOfBlack += 8;
				}
				
//				if(getColor().equalsIgnoreCase("r"))
//				{
//					System.out.println("r");
//					setStartPositionY(9);
//				}
//					
//				else
//				{
//					System.out.println("b");
//					setStartPositionY(0);
//				}
				break;
			case "Cannon" :
				
//				System.out.println("cannon");
				if(getColor().equalsIgnoreCase("R"))
				{
//					System.out.println("r");
					setStartPositionY(7);
					setStartPositionX(cannonCountOfRed);
					cannonCountOfRed += 6;
				}
				else
				{
//					System.out.println("b");
					setStartPositionY(2);
					setStartPositionX(cannonCountOfBlack);
					cannonCountOfBlack += 6;
				}
				break;
			case "Pawn":
				
//				System.out.println("pawn");
				if(getColor().equalsIgnoreCase("R"))
				{
//					System.out.println("r");
					setStartPositionY(6);
					setStartPositionX(pawnCountOfRed);
					pawnCountOfRed += 2;
				}
				else
				{
//					System.out.println("b");
					setStartPositionY(3);
					setStartPositionX(pawnCountOfBlack);
					pawnCountOfBlack += 2;
				}
				break;
		}
		
	}
//	public boolean eat(chess other)
//	{
//		if(this.name)
//		{
//			
//		}
//				
//				
//	}
		
	

}
