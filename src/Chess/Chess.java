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
	
	
	public boolean moveRule()
	{
		
	};
}
