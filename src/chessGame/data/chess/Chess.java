package chessGame.data.chess;

import java.util.StringTokenizer;

import javax.swing.JComponent;

import chessGame.data.ChessGameData;
import chessGame.data.LocationMap;
import chessGame.data.LocationPoint;
import chessGame.data.status.GameStatus;

public class Chess extends JComponent {
	static final int chinessChess = 1;
	static final int taiwanChess = 0;
	static final int red = 0;
	static final int black = 1;

	private ChessGameData data;
//	private LocationMap lm = new LocationMap();
	private int chessX = 0; // position x
	private int chessY = 0; // position y
	private String chessName = "";
	private String chineseName = "";
	private boolean chessCover = false; // false 為覆蓋 , true 為 掀開
	private boolean chessDead = false;
	private int color = 0; // 0 為 紅色 , 1 為黑色;
	private String[] eatRule = new String[7];
	private int priority;

	public Chess(int color, boolean chessCover, int x, int y, ChessGameData data) {
		this.color = color;
		this.chessCover = chessCover;
		this.chessX = x;
		this.chessY = y;
		this.data = data;
	}

	public Chess(int color, boolean chessCover, LocationPoint point, ChessGameData data) {
		this.color = color;
		this.chessCover = chessCover;
		this.chessX = point.getX();
		this.chessY = point.getY();
		this.data = data;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getChessX() {
		return chessX;
	}

	public int getChessY() {
		return chessY;
	}

	public void setChessX(int x) {
		this.chessX = x;
	}

	public void setChessY(int y) {
		this.chessY = y;
	}

	public String getName() {
		return chessName;
	}

	public void setName(String name) {
		chessName = name;
	}

	public boolean isChessCover() {
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

	public boolean isChessDead() {
		return chessDead;
	}

	public void setChessDead(boolean chessDead) {
		this.chessDead = chessDead;
	}

	public ChessGameData getData() {
		return data;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String[] getEatRule() {
		String[] temp = new String[eatRule.length];
		for (int i = 0; i < eatRule.length; i++) {
			temp[i] = eatRule[i];
		}
		return temp;
	}

	public LocationMap getLocationMap() {
		return data.getLocMap();
	}

	public void setEatRule(String eatRule) {
		String del = ",";
		StringTokenizer st = new StringTokenizer(eatRule, del);
		int count = 0;
		while (st.hasMoreTokens()) {
			this.eatRule[count] = st.nextToken();
			count++;
		}
	}

	public boolean moveRule(int toX, int toY) {
		return true;
	};
}
