package chessGame.data;

import java.io.Serializable;

public class ChessData implements Serializable {
	private LocationPoint point;
	private boolean chessDead = false;
	private boolean chessCover = false; // false 為覆蓋 , true 為 掀開

	public ChessData(LocationPoint point, boolean chessDead, boolean chessCover) {
		// TODO Auto-generated constructor stub
		this.point = point;
		this.chessDead = chessDead;
		this.chessCover = chessCover;
	}

	public LocationPoint getPoint() {
		return point;
	}

	public boolean isChessDead() {
		return chessDead;
	}

	public boolean isChessCover() {
		return chessCover;
	}
}
