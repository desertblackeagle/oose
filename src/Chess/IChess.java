package Chess;

public interface IChess {
	int x=0;//position x
	int y=0;//position y
	String chessName="";
	boolean chessCover= false; // false ���л\ , true �� �ȶ}
	int color=0;// 0 �� ���� , 1 ���¦�;
	String[] eatRule ={};
	
	
	public boolean moveRule();
	
}
