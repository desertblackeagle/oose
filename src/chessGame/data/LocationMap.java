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
			for (int j = 8; j < 8; j++) {
				taiwanDeadLocationPoint[i][j] = new LocationPoint(j * 70 + 40, i * 70 + 390);
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 8; j >= 0; j--) {
				chineseLocationPointCross[i][j] = new LocationPoint(i * 70 + 5, 565 - (j * 70 + 5));
//				System.out.printf("%d %d");
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 7; j >= 0; j--) {
//				System.out.printf("%d ::: %d",j,i);
				taiwanLocationPointCross[i][j] = new LocationPoint(i * 70 + 40, 570 - (j * 70 + 40));
			}
			System.out.println();
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				taiwanDeadLocationPointCross[i][j] = new LocationPoint(j * 70 + 40, i * 70 + 390);
			}
		}
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
		if (taiwanDeadChessLocIndexX >= 7) {
			taiwanDeadChessLocIndexX = 0;
			taiwanDeadChessLocIndexY++;
		} else {
			taiwanDeadChessLocIndexX++;
		}
		LocationPoint tmp = taiwanDeadLocationPoint[taiwanDeadChessLocIndexY][taiwanDeadChessLocIndexX];
//		System.out.println("XY : " + taiwanDeadChessLocIndexY + " " + taiwanDeadChessLocIndexX);
		return tmp;
	}

	public LocationPoint[][] getLocationMap() {
		if (data.getGameStatus().getChessStatus().getWhichGame() == 0) {
//			System.out.println("Taiwan game");
			if (data.getConfigData().isBoardStraight()) {
//				System.out.println("game strai");
				return taiwanLocationPoint;
			} else {
//				System.out.println("game cro");
				return taiwanLocationPointCross;
			}
		} else {
//			System.out.println("Chinese game");
			if (data.getConfigData().isBoardStraight()) {
//				System.out.println("game strai");
				return chineseLocationPoint;
			} else {
//				System.out.println("game cro");
				return chineseLocationPointCross;
			}
		}
	}
//	public static void main(String[] args) {
//		LocationMap lm = new LocationMap();
//
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 9; j++) {
//				System.out.printf("%3d:%3d ", lm.getChineseLocationMap()[i][j].getX(), lm.getChineseLocationMap()[i][j].getY());
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 8; j++) {
//				System.out.printf("%3d:%3d ", lm.getTaiwanLocationMap()[i][j].getX(), lm.getTaiwanLocationMap()[i][j].getY());
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 8; j++) {
//				System.out.printf("%3d:%3d ", lm.getTaiwanDeadLocationMap()[i][j].getX(), lm.getTaiwanDeadLocationMap()[i][j].getY());
//			}
//			System.out.println();
//		}
//	}
}
