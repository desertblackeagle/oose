package Chess;

public interface IChess {
	int x=0;//position x
	int y=0;//position y
	String chessName="";
	boolean chessCover= false; // false 為覆蓋 , true 為 掀開
	int color=0;// 0 為 紅色 , 1 為黑色;
	String[] eatRule ={};
	
	
	public boolean moveRule();
	
}
