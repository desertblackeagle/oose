package Chess;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardManager manager = new BoardManager();

		Horse redHorse1 = new Horse(0, false, 1, 9);
		Horse redHorse2 = new Horse(0, false, 7, 9);
		Horse blackHorse1 = new Horse(1, false, 1, 0);
		Horse blackHorse2 = new Horse(1, false, 7, 0);
		Rook redRook1 = new Rook(0, false, 0, 9);
		Rook redRook2 = new Rook(0, false, 8, 9);
		Rook blackRook1 = new Rook(1, false, 0, 0);
		Rook blackRook2 = new Rook(1, false, 8, 0);
		Cannon redCannon1 = new Cannon(0, false, 1, 7);
		Cannon redCannon2 = new Cannon(0, false, 7, 7);
		Cannon blackCannon1 = new Cannon(1, false, 1, 2);
		Cannon blackCannon2 = new Cannon(1, false, 7, 2);
		Pawn redPawn1 = new Pawn(0, false, 0, 6);
		Pawn redPawn2 = new Pawn(0, false, 2, 6);
		Pawn redPawn3 = new Pawn(0, false, 4, 6);
		Pawn redPawn4 = new Pawn(0, false, 6, 6);
		Pawn redPawn5 = new Pawn(0, false, 8, 6);
		Pawn blackPawn1 = new Pawn(1, false, 0, 3);
		Pawn blackPawn2 = new Pawn(1, false, 2, 3);
		Pawn blackPawn3 = new Pawn(1, false, 4, 3);
		Pawn blackPawn4 = new Pawn(1, false, 6, 3);
		Pawn blackPawn5 = new Pawn(1, false, 8, 3);
		Elephant blackElephant1 = new Elephant(1, false, 2, 0);
		Elephant redElephant1 = new Elephant(0, false, 2, 9);
		King blackKing = new King(1, false, 4, 0);
		King redKing = new King(0, false, 4, 9);
		Warrior blackWarrior1 = new Warrior(1, false, 3, 0);
		Warrior redWarrior1 = new Warrior(0, false, 3, 9);

		manager.chineseChessLocationList[9][1] = redHorse1;
		manager.chineseChessLocationList[9][7] = redHorse2;
		manager.chineseChessLocationList[0][1] = blackHorse1;
		manager.chineseChessLocationList[0][7] = blackHorse2;
		manager.chineseChessLocationList[9][0] = redRook1;
		manager.chineseChessLocationList[9][8] = redRook2;
		manager.chineseChessLocationList[0][0] = blackRook1;
		manager.chineseChessLocationList[0][8] = blackRook2;
		manager.chineseChessLocationList[7][1] = redCannon1;
		manager.chineseChessLocationList[7][7] = redCannon2;
		manager.chineseChessLocationList[2][1] = blackCannon1;
		manager.chineseChessLocationList[2][7] = blackCannon2;
		manager.chineseChessLocationList[6][0] = redPawn1;
		manager.chineseChessLocationList[6][2] = redPawn2;
		manager.chineseChessLocationList[6][4] = redPawn3;
		manager.chineseChessLocationList[6][6] = redPawn4;
		manager.chineseChessLocationList[6][8] = redPawn5;
		manager.chineseChessLocationList[3][0] = blackPawn1;
		manager.chineseChessLocationList[3][2] = blackPawn2;
		manager.chineseChessLocationList[3][4] = blackPawn3;
		manager.chineseChessLocationList[3][6] = blackPawn4;
		manager.chineseChessLocationList[3][8] = blackPawn5;
		manager.chineseChessLocationList[0][2] = blackElephant1;
		manager.chineseChessLocationList[9][2] = redElephant1;
		manager.chineseChessLocationList[0][4] = blackKing;
		manager.chineseChessLocationList[9][4] = redKing;
		manager.chineseChessLocationList[0][3] = blackWarrior1;
		manager.chineseChessLocationList[9][3] = redWarrior1;
		// System.out.printf("%s\n","______________________________________________________");
		manager.printChess();
		manager.moveTo(redCannon1, 1, 0);
//		manager.moveTo(redHorse1, 1, 5);
//		manager.moveTo(redHorse1, 2, 3);
//		manager.moveTo(redHorse1, 4, 4);
		manager.moveTo(redCannon1, 1, 5);

//		manager.moveTo(blackPawn3, 5, 4);
//		manager.moveTo(blackRook1, 0, 1);
//		manager.moveTo(blackRook1, 1, 1);
//		manager.moveTo(blackElephant1, 3, 2);
		manager.moveTo(redElephant1, 4, 7);
		manager.moveTo(redWarrior1, 4, 8);
		manager.moveTo(blackWarrior1, 4, 1);
		manager.moveTo(redKing, 3, 9);
		manager.moveTo(blackKing, 3, 0);
		manager.moveTo(redKing, 3, 0);
		manager.moveTo(redWarrior1, 4, 9);
		manager.printChess();
	}
}
