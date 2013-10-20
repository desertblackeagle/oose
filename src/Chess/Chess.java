package Chess;

public class  Chess {
	private int x = 0;// position x
	private int y = 0;// position y
	private String chessName = "";
	private boolean chessCover = false; // false 為覆蓋 , true 為 掀開
	private int color = 0;// 0 為 紅色 , 1 為黑色;
	private String[] eatRule = {};

	public Chess()
	{
		
	}
	public Chess(String name )
	{
		chessName = name;
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public String getName()
	{
		return chessName;
	}
	public void setName(String name)
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
	public int getColor()
	{
		return color;
	}
	public void setColor(int color)
	{
		this.color = color;
	}
	public String[] getEatRule()
	{
		String[] temp = new String[eatRule.length];
		for(int i=0 ; i < eatRule.length ; i++)
		{
			temp[i] = eatRule[i];
		}
		return temp;
	}
	public boolean moveRule()
	{
		return false;
	};
}
