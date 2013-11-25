package controlUnit;

public class RecordData {
	private String chessName;
	private String chineseName;
	private int color;
	private boolean cover;
	private int fromX;
	private int fromY;
	private int toX;
	private int toY;

	public String getChessName() {
		return chessName;
	}

	public void setChessName(String chessName) {
		this.chessName = chessName;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public boolean isCover() {
		return cover;
	}

	public void setCover(boolean cover) {
		this.cover = cover;
	}

	public int getFromX() {
		return fromX;
	}

	public void setFromX(int fromX) {
		this.fromX = fromX;
	}

	public int getFromY() {
		return fromY;
	}

	public void setFromY(int fromY) {
		this.fromY = fromY;
	}

	public int getToX() {
		return toX;
	}

	public void setToX(int toX) {
		this.toX = toX;
	}

	public int getToY() {
		return toY;
	}

	public void setToY(int toY) {
		this.toY = toY;
	}
	
	public String toSting(){
		return "Chess record : " + chessName + " " + chineseName + " " + color + " " + cover + " " + fromX + " " + fromY + " " + toX + " " + toY;
	}
}
