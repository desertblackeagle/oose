package controlUnit;

public class LocationMap {
	private LocationPoint[][] chineseLocationPoint;
	private LocationPoint[][] taiwaneseLocationPoint;

	public LocationMap() {
		// TODO Auto-generated constructor stub
		chineseLocationPoint = new LocationPoint[10][9];
		taiwaneseLocationPoint = new LocationPoint[4][8];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				chineseLocationPoint[i][j] = new LocationPoint(i * 70 + 5, j * 70 + 5);
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				taiwaneseLocationPoint[i][j] = new LocationPoint(i * 70 + 40, j * 70 + 40);
			}
		}
	}

	public LocationPoint[][] getChineseLocationMap() {
		LocationPoint[][] temp = chineseLocationPoint.clone();
		return temp;
	}

	public LocationPoint[][] getTaiwaneseLocationMap() {
		LocationPoint[][] temp = taiwaneseLocationPoint.clone();
		return temp;
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
	}
}
