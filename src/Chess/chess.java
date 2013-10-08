package Chess;
class position
{
//	private int x;
//	private int y;
	public int x;
	public int y;
	
	public position(int x , int y)
	{
		this.x = x;
		this.y = y;
	}
	public position()
	{
		
	}
//	public int getY()
//	{
//		return y;
//	}
//	public void setY(int y)
//	{
//		this.y = y;
//	}
//	public int getX()
//	{
//		return x;
//	}
//	public void setX(int x)
//	{
//		this.x = x;
//	}
}
public class chess {
	
	private String chessName;//棋子名稱
	private boolean chessCover;//是否為覆蓋的(暗棋使用)
	private position boardPosition = new position(); //棋盤位置
	private String[] eatRule = new String[7];//可吃的棋子
	private int rank;//階級
	private position startPosition = new position() ;//初始位置
	private String color;//棋子的顏色
	//boolean moveRule ()//移動的規則
//	private int count;
//	private String[] chesses = new String[16];
//	public chess(String name)
//	{
//		chessName = name;
//		setRank();
//		setEatRule();
//		
//	}
	public chess(String name,String color)
	{
		chessName = name;
		this.color = color;
		setRank();
		setEatRule();
		
	}

////	public chess(String name,String color,position p)
//	{
//		chessName = name;
//		this.color = color;
//		startPosition.x = p.x;
//		startPosition.y = p.y;
//		setRank();
//		setEatRule();
//		
//	}
//	public chess(String name,String color,int x,int y)
//	{
//		chessName = name;
//		this.color = color;
//		startPosition.x = x;
//		startPosition.y = y;
//		setRank();
//		setEatRule();
//		
//	}
	
	
	public String getChessName()
	{
		return chessName;
	}
	public void setChessName(String name)
	{
		chessName = name;
	}
	public boolean getChessCover()
	{
		return chessCover;
	}
	public void setChessCover(boolean cover)
	{
		chessCover = cover;
	}
	public void setBoardPosition(position p)
	{
		boardPosition.x = p.x;
		boardPosition.y = p.y;
	}
//	public void setBoardPositionX(int x)
//	{
//		boardPosition.x = x;
//	}
//	public void setBoardPositionY(int y)
//	{
//		boardPosition.y = y;
//	}
	public int getBoardPositionX()
	{
		return boardPosition.x;
	}
	public int getBoardPositionY()
	{
		return boardPosition.y;
	}
//	public void setStartPosition(position p)
//	{
//		startPosition.x = p.x;
//		startPosition.y = p.y;
//	}
	public void setStartPositionX(int x)
	{
		startPosition.x = x;
	}
	public void setStartPositionY(int y)
	{
		startPosition.y = y;
	}
	public int getStartPositionX()
	{
		return startPosition.x;
	}
	public int getStartPositionY()
	{
		return startPosition.y;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	public String getColor()
	{
		return color;
	}
	private void setEatRule()
	{
		String[] chesses = new String[7];
		chesses[0]="King";
		chesses[1]="Guard";
		chesses[2]="Bishop";
		chesses[3]="Rook";
		chesses[4]="Horse";
		chesses[5]="Cannon";
		chesses[6]="Pawn";
		
		for(int i=0 ; i < 7 ;i=i+2)
		{
			if(chessName.equalsIgnoreCase("King") && i != 6)
			{
				eatRule[i] = chesses[i];
			}
			else if(chessName.equalsIgnoreCase("Pawn"))
			{
				if( i < 1 && i==6)
				{
					eatRule[i] = chesses[i];
				}
			}
			else if(!chessName.equalsIgnoreCase("Cannon"))
			{
				if(rank-1 <= i)
				{
					eatRule[i] = chesses[i];
				}
			}
			else
				eatRule[i] = chesses[i];
			
		}
	}
	public String[] getEatRule()
	{
		return eatRule;
	}
	public int getRank()
	{
		return rank;
	}
	private void setRank()
	{
		switch(getChessName())
		{
			case "King":
				rank = 1;
				break;
			case "Guard":
				rank = 2;
				break;
			case "Bishop":
				rank = 3;
				break;
			case "Rook":
				rank = 4;
				break;
			case "Horse":
				rank = 5;
				break;
			case "Cannon":
				rank = 6;
				break;
			case "Pawn":
				rank = 7;
				break;
		}
	}
//	public boolean eat(chess other)
//	{
//		if(chessName.equalsIgnoreCase("King") && other.getRank()!= 7 && !color.equalsIgnoreCase(other.getColor()))
//			return true;
//		else if (chessName.equalsIgnoreCase("Pawn")&& !color.equalsIgnoreCase(other.getColor()))
//		{
//			if(other.getRank()==7 || other.getRank()==1)
//			{
//				return true;
//			}
//		}
//		else if(chessName.equalsIgnoreCase("Cannon")&& !color.equalsIgnoreCase(other.getColor()))
//		{
//			if()//在兩點直線上另有中間一子時則可吃
//			{
//				return true;
//			}
//		}
//}
//	public void setCount(int number)
//	{
//		count = number;
//	}
//	public void setCount()
//	{
//		switch(getChessName())
//		{
//			case "King":
//				count = 1;
//				break;
//			case "Guard":
//				count = 2;
//				break;
//			case "Bishop":
//				count = 2;
//				break;
//			case "Rook":
//				count = 2;
//				break;
//			case "Horse":
//				count = 2;
//				break;
//			case "Cannon":
//				count = 2;
//				break;
//			case "Pawn":
//				count = 5;
//				break;
//		}
//	}
//	public int getCount()
//	{
//		return count;
//	}
//	private void newChesses()
//	{
//		chesses[0]="King";
//		chesses[1]="Guard";
//		chesses[2]="Guard";
//		chesses[3]="Bishop";
//		chesses[4]="Bishop";
//		chesses[5]="Horse";
//		chesses[6]="Horse";
//		chesses[7]="Rook";
//		chesses[8]="Rook";
//		chesses[9]="Cannon";
//		chesses[10]="Cannon";
//		chesses[11]="Pawn";
//		chesses[12]="Pawn";	
//		chesses[13]="Pawn";
//		chesses[14]="Pawn";
//		chesses[15]="Pawn";
//	}
//	private void setChesses(chess[] chess)
//	{
//		for(int i=0 ; i < 16 ; i++)
//		{
//			chess[i] = chesses[i];
//		}
//	}
}
