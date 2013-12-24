package chessGame.data;

public class LocationMap {
	private LocationPoint[][] chineseLocationPoint;
	private LocationPoint[][] chineseLocationPointCross;
	private LocationPoint[][] taiwanLocationPoint;
	private LocationPoint[][] taiwanLocationPointCross;
	private LocationPoint[][] taiwanDeadLocationPoint;
	private LocationPoint[][] taiwanDeadLocationPointCross;
	private int taiwanDeadChessLocIndexX = -1;
	private int taiwanDeadChessLocIndexY = 0;
	private int taiwanCrossDeadChessLocIndexX = -1;
	private int taiwanCrossDeadChessLocIndexY = 0;
	private ChessGameData data;

	public LocationMap(ChessGameData data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		chineseLocationPoint = new LocationPoint[10][9];
		taiwanLocationPoint = new LocationPoint[4][8];

		chineseLocationPointCross = new LocationPoint[10][9];
		taiwanLocationPointCross = new LocationPoint[4][8];

		taiwanDeadLocationPoint = new LocationPoint[4][8];
		taiwanDeadLocationPointCross = new LocationPoint[4][8];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				chineseLocationPoint[i][j] = new LocationPoint(j * 70 + 5, i * 70 + 5);
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				taiwanLocationPoint[i][j] = new LocationPoint(j * 70 + 40, i * 70 + 40);
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				taiwanDeadLocationPoint[i][j] = new LocationPoint(j * 70 + 40, i * 70 + 390);
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 8; j >= 0; j--) {
				chineseLocationPointCross[i][j] = new LocationPoint(i * 70 + 5, 565 - (j * 70 + 5));
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 7; j >= 0; j--) {
				taiwanLocationPointCross[i][j] = new LocationPoint(i * 70 + 40, 570 - (j * 70 + 40));
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 7; j >= 0; j--) {
				taiwanDeadLocationPointCross[i][j] = new LocationPoint(i * 70 + 390, (920 - (j * 70 + 390)));
			}
		}
	}

	public void clearIndex() {
		taiwanDeadChessLocIndexX = -1;
		taiwanDeadChessLocIndexY = 0;
		taiwanCrossDeadChessLocIndexX = -1;
		taiwanCrossDeadChessLocIndexY = 0;
	}

	public LocationPoint[][] getChineseLocationMap() {
		LocationPoint[][] temp = chineseLocationPoint.clone();
		return temp;
	}

	public LocationPoint[][] getTaiwanLocationMap() {
		LocationPoint[][] temp = taiwanLocationPoint.clone();
		return temp;
	}

	public LocationPoint[][] getTaiwanDeadLocationMap() {
		LocationPoint[][] temp = taiwanDeadLocationPoint.clone();
		return temp;
	}

	public LocationPoint[][] getChineseLocationPointCross() {
		return chineseLocationPointCross;
	}

	public LocationPoint[][] getTaiwanLocationPointCross() {
		return taiwanLocationPointCross;
	}

	public LocationPoint[][] getTaiwanDeadLocationPointCross() {
		return taiwanDeadLocationPointCross;
	}

	public LocationPoint getDeadLocation() {
		LocationPoint tmp;
		if (data.getConfigData().isBoardStraight()) {
			if (taiwanDeadChessLocIndexX >= 7) {
				taiwanDeadChessLocIndexX = 0;
				taiwanDeadChessLocIndexY++;
			} else {
				taiwanDeadChessLocIndexX++;
			}
			tmp = getTaiwanDeadLocationPoint()[taiwanDeadChessLocIndexY][taiwanDeadChessLocIndexX];
		} else {
			if (taiwanCrossDeadChessLocIndexX >= 7) {
				taiwanCrossDeadChessLocIndexX = 0;
				taiwanCrossDeadChessLocIndexY++;
			} else {
				taiwanCrossDeadChessLocIndexX++;
			}
			tmp = getTaiwanDeadLocationPointCross()[taiwanCrossDeadChessLocIndexY][taiwanCrossDeadChessLocIndexX];
		}
		return tmp;
	}

	public LocationPoint[][] getLocationMap() {
		if (data.getGameStatus().getChessStatus().getWhichGame() == 0) {
			if (data.getConfigData().isBoardStraight()) {
				return taiwanLocationPoint;
			} else {
				return taiwanLocationPointCross;
			}
		} else {
			if (data.getConfigData().isBoardStraight()) {
				return chineseLocationPoint;
			} else {
				return chineseLocationPointCross;
			}
		}
	}

	public LocationPoint[][] getTaiwanDeadLocationPoint() {
		return taiwanDeadLocationPoint;
	}

	public LocationPoint[][] getDeadLocationMap() {
		if (data.getConfigData().isBoardStraight()) {
			return taiwanDeadLocationPoint;
		} else {
			return taiwanDeadLocationPointCross;
		}
	}
}
