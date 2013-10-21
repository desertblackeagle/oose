package Chess;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardManager manager = new BoardManager();

		Horse horse1 = new Horse( red, 1, 1);
		Horse horse2 = new Horse( red, 2, 2);
		// manager.moveTo(horse, 5, 5);
		manager.chineseChessLocationList[1][1] = horse1;
		manager.chineseChessLocationList[2][2] = horse2;
		// System.out.printf("%s\n","______________________________________________________");
		manager.printChess();
		manager.moveTo(horse1, 2, 2);
		manager.printChess();
	}

}
