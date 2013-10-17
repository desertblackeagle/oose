package Chess;
import java.util.LinkedList;
import java.util.Random;
public class DarkChess extends Chess{
//	int[] xTimes= {0,0,0,0,0,0,0,0} ;
//	int[] yTimes = {0,0,0,0};
	private static LinkedList<position> position = new LinkedList<position>();

	public DarkChess(String name,String color)
	{
		super(name,color);
		setChessCover(true);
		setStartPosition();
	}
//	public DarkChess(String name, String color, position p)
//	{
//		super(name,color,p);
//	}
//	public DarkChess(String name, String color, int x, int y)
//	{
//		super(name,color,x,y);
//	}
	public void setStartPosition()
	{
		Random ran = new Random();
		int x;
		int y;
		boolean set = false;
		position p;
//		int randomNumber;
//		for(int i =0 ;i < 8 ;i++)
//		{
//			xTimes[i] = 0;
//		}
//		for(int i =0 ;i < 4 ;i++)
//		{
//			yTimes[i] = 0;
//		}
		
//		for(int i=0 ; i < 31 ; i++)//X�b
//		{
		
		x = ran.nextInt(8);//0~7
		y = ran.nextInt(4)+1;//1~4
//		System.out.println("\n\n" + getChessName()+"  " + x + "," + y);
		
		if(position.isEmpty())
		{
//			System.out.println("Empty\n");
			
//			System.out.println("1x,y = " + x + "," + y);
			position.add(new position(x,y));
//			System.out.println("1put = " + x + "," + y);
			setStartPositionX(x);
			setStartPositionY(y);
//			System.out.println("size = " + position.size());
			
		}
		else
		{
			
			while(!set)
			{
				for(int i = 0; i < position.size() ; i++)
				{
					p = position.get(i);
//					System.out.println("i = " + i + "   " + p.x + "," + p.y);
					if(x == p.x && y == p.y)
					{
//						System.out.println(p.x + "," + p.y);
						x = ran.nextInt(8);//0~7
						y = ran.nextInt(4)+1;//1~4
//						System.out.println("2x,y = " + x + "," + y);
						break;
					}
					else if( (i+1) == position.size())
					{
						position.add(new position(x,y));
//						System.out.println("2put = " + x + "," + y);
						setStartPositionX(x);
						setStartPositionY(y);
//						System.out.println("size = " + position.size());
						set = true;
						break;
					}
				}
					
//				int i=0;
//				
//				for (Entry<Integer,Integer> ent : position.entrySet())
//				{
//					i++;
//					System.out.println("i = " + i);
//					System.out.println(ent.getKey() + "," + ent.getValue());
//					if(ent.getKey() == x && ent.getValue()== y)
//					{
//						System.out.println(ent.getKey() + "," + ent.getValue());
//						x = ran.nextInt(8);//0~7
//						y = ran.nextInt(4)+1;//1~4
//						System.out.println("2x,y = " + x + "," + y);
//						break;
//					}
//					else if( i == position.size())
//					{
//						
//						position.put(x, y);
//						System.out.println("2put = " + x + "," + y);
//						setStartPositionX(x);
//						setStartPositionY(y);
//						set = true;
//						System.out.println("size = " + position.size());
//					}
//				}
				
			}
			
		}
//		printHash();
		
//			randomNumber = ran.nextInt(8);//0~7
//			System.out.println("1ranNum = " + randomNumber);
//			while(x[randomNumber]++ > 4)
//			{
//				System.out.println("x++ > 4");
//				x[randomNumber]--;
//				randomNumber = ran.nextInt(8);//0~7
//				System.out.println("2ranNum = " + randomNumber);
//			}
//			setStartPositionX(randomNumber);
//			
//			for(int k=0 ; k<4; k++)//Y�b
//			{
//				randomNumber = ran.nextInt(4)+1;//1~4
//				System.out.println("3ranNum = " + randomNumber);
//				while(y[randomNumber-1]++ > 8)
//				{
//					System.out.println("y++ > 8");
//					y[randomNumber-1]--;
//					randomNumber = ran.nextInt(4)+1;
//					System.out.println("4ranNum = " + randomNumber);
//				}
//				setStartPositionY(randomNumber);
//			}
		}
//	public static void printHash()
//	{
//		System.out.println("\n\n");
//		for (Entry<Integer,Integer> ent : position.entrySet())
//		{
//			System.out.println("x,y = " + ent.getKey() + "," + ent.getValue());
//		}
//	}
}
