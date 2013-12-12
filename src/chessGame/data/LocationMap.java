package chessGame.data;

public class LocationMap {
	private LocationPoint[][] chineseLocationPoint;
	private LocationPoint[][] taiwanLocationPoint;
	private LocationPoint[][] taiwanDeadLocationPoint;
	private int taiwanDeadChessLocIndexX = -1;
	private int taiwanDeadChessLocIndexY = 0;

	public LocationMap() {
		// TODO Auto-generated constructor stub
		chineseLocationPoint = new LocationPoint[10][9];
		taiwanLocationPoint = new LocationPoint[4][8];
		taiwanDeadLocationPoint = new LocationPoint[4][8];

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
	}

	public LocationPoint[][] getChineseLocationMap() {
		LocationPoint[][] temp = chineseLocationPoint.clone();
		return temp;
	}

	public LocationPoint[][] getTaiwaneseLocationMap() {
		LocationPoint[][] temp = taiwanLocationPoint.clone();
		return temp;
	}

	public LocationPoint[][] getTaiwanDeadLocationMap() {
		LocationPoint[][] temp = taiwanDeadLocationPoint.clone();
		return temp;
	}

	public LocationPoint getDeadLocation() {
		if (taiwanDeadChessLocIndexX >= 7) {
			taiwanDeadChessLocIndexX = 0;
			taiwanDeadChessLocIndexY++;
		} else {
			taiwanDeadChessLocIndexX++;
		}
		LocationPoint tmp = taiwanDeadLocationPoint[taiwanDeadChessLocIndexY][taiwanDeadChessLocIndexX];
		System.out.println("XY : " + taiwanDeadChessLocIndexY + " " + taiwanDeadChessLocIndexX);
		return tmp;
	}

	public static void main(String[] args) {
		LocationMap lm = new LocationMap();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.printf("%3d:%3d ", lm.getChineseLocationMap()[i][j].getX(), lm.getChineseLocationMap()[i][j].getY());
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.printf("%3d:%3d ", lm.getTaiwaneseLocationMap()[i][j].getX(), lm.getTaiwaneseLocationMap()[i][j].getY());
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.printf("%3d:%3d ", lm.getTaiwanDeadLocationMap()[i][j].getX(), lm.getTaiwanDeadLocationMap()[i][j].getY());
			}
			System.out.println();
		}
	}
}
