package chess;

import java.util.StringTokenizer;

public class Chess {
	private int x = 0;// position x
	private int y = 0;// position y
	private String chessName = "";
	private String chineseName = "";
	private boolean chessCover = false; // false 為覆蓋 , true 為 掀開
	private int color = 0;// 0 為 紅色 , 1 為黑色;
	static final int chinessChess = 1;
	static final int taiwanChess = 0;
	private String[] eatRule = new String[7];
	
	public Chess() {

	}

	public Chess(int color, boolean chessCover, int x, int y, Chess[][] board) {
		this.color = color;
		this.chessCover = chessCover;
		this.x = x;
		this.y = y;
		board[y][x] = this;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName() {
		return chessName;
	}

	public void setName(String name) {
		chessName = name;
	}

	public boolean getChessCover() {
		return chessCover;
	}

	public void setChessCover(boolean cover) {
		chessCover = cover;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String[] getEatRule() {
		String[] temp = new String[eatRule.length];
		for (int i = 0; i < eatRule.length; i++) {
			temp[i] = eatRule[i];
		}
		return temp;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	
	public void setEatRule(String eatRule) {
//		System.out.println("String : "+eatRule);
		String del = ",";
		StringTokenizer st = new StringTokenizer(eatRule, del);
//		System.out.println("Count : "+st.countTokens());
		int count = 0;
		while(st.hasMoreTokens()){
			this.eatRule[count] = st.nextToken();
//			System.out.println("rule: "+this.eatRule[count]);
			count++;
		}
//		for (int i = 0; i < st.countTokens(); i++) {
//			System.out.println("i : "+i);
//			this.eatRule[i] = st.nextToken();
//			System.out.println("rule: "+this.eatRule[i]);
//		}
	}

	public boolean moveRule(int toX, int toY, int whichGame, Chess[][] board) {
		return true;
	};
}
