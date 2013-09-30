package Chess;
public interface Chess {
	String chessName = "";			//棋子名稱
	String[] eatRule = {};			//可吃的棋子
	int[] bordPosition = {};		//棋盤位置
	boolean chessCover = false;		//是否為覆蓋的(暗棋使用)
	
	public boolean moveRule();		//移動的規則
}
