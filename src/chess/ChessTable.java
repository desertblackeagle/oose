package chess;

import controlUnit.BoardManager;
import controlUnit.LocationPoint;
/* @author Red Rose
 * Function:a table to create and store chess
 * Last Update:2013/11/15
 */
public class ChessTable {
	private Horse redHorse1;
	private Horse redHorse2;
	private Horse blackHorse1;
	private Horse blackHorse2;
	private Rook redRook1;
	private Rook redRook2;
	private Rook blackRook1;
	private Rook blackRook2;
	private Cannon redCannon1;
	private Cannon redCannon2;
	private Cannon blackCannon1;
	private Cannon blackCannon2;
	private Pawn redPawn1;
	private Pawn redPawn2;
	private Pawn redPawn3;
	private Pawn redPawn4;
	private Pawn redPawn5;
	private Pawn blackPawn1;
	private Pawn blackPawn2;
	private Pawn blackPawn3;
	private Pawn blackPawn4;
	private Pawn blackPawn5;
	private King redKing;
	private King blackKing;
	private Elephant redElephant1;
	private Elephant redElephant2;
	private Elephant blackElephant1;
	private Elephant blackElephant2;
	private Warrior redWarrior1;
	private Warrior redWarrior2;
	private Warrior blackWarrior1;
	private Warrior blackWarrior2;

	static final int chinessChess = 1;
	static final int taiwanChess = 0;

	public ChessTable(BoardManager manager) {
		// TODO Auto-generated constructor stub
		if (manager.getWhichGame() == chinessChess) {
			redHorse1 = new Horse(0, false, 1, 9, manager.getChineseChessLocationList());
			redHorse2 = new Horse(0, false, 7, 9, manager.getChineseChessLocationList());
			blackHorse1 = new Horse(1, false, 1, 0, manager.getChineseChessLocationList());
			blackHorse2 = new Horse(1, false, 7, 0, manager.getChineseChessLocationList());
			redRook1 = new Rook(0, false, 0, 9, manager.getChineseChessLocationList());
			redRook2 = new Rook(0, false, 8, 9, manager.getChineseChessLocationList());
			blackRook1 = new Rook(1, false, 0, 0, manager.getChineseChessLocationList());
			blackRook2 = new Rook(1, false, 8, 0, manager.getChineseChessLocationList());
			redCannon1 = new Cannon(0, false, 1, 7, manager.getChineseChessLocationList());
			redCannon2 = new Cannon(0, false, 7, 7, manager.getChineseChessLocationList());
			blackCannon1 = new Cannon(1, false, 1, 2, manager.getChineseChessLocationList());
			blackCannon2 = new Cannon(1, false, 7, 2, manager.getChineseChessLocationList());
			redPawn1 = new Pawn(0, false, 0, 6, manager.getChineseChessLocationList());
			redPawn2 = new Pawn(0, false, 2, 6, manager.getChineseChessLocationList());
			redPawn3 = new Pawn(0, false, 4, 6, manager.getChineseChessLocationList());
			redPawn4 = new Pawn(0, false, 6, 6, manager.getChineseChessLocationList());
			redPawn5 = new Pawn(0, false, 8, 6, manager.getChineseChessLocationList());
			blackPawn1 = new Pawn(1, false, 0, 3, manager.getChineseChessLocationList());
			blackPawn2 = new Pawn(1, false, 2, 3, manager.getChineseChessLocationList());
			blackPawn3 = new Pawn(1, false, 4, 3, manager.getChineseChessLocationList());
			blackPawn4 = new Pawn(1, false, 6, 3, manager.getChineseChessLocationList());
			blackPawn5 = new Pawn(1, false, 8, 3, manager.getChineseChessLocationList());
			redKing = new King(0, false, 4, 9, manager.getChineseChessLocationList());
			blackKing = new King(1, false, 4, 0, manager.getChineseChessLocationList());
			redElephant1 = new Elephant(0, false, 2, 9, manager.getChineseChessLocationList());
			redElephant2 = new Elephant(0, false, 6, 9, manager.getChineseChessLocationList());
			blackElephant1 = new Elephant(1, false, 2, 0, manager.getChineseChessLocationList());
			blackElephant2 = new Elephant(1, false, 6, 0, manager.getChineseChessLocationList());
			redWarrior1 = new Warrior(0, false, 3, 9, manager.getChineseChessLocationList());
			redWarrior2 = new Warrior(0, false, 5, 9, manager.getChineseChessLocationList());
			blackWarrior1 = new Warrior(1, false, 3, 0, manager.getChineseChessLocationList());
			blackWarrior2 = new Warrior(1, false, 5, 0, manager.getChineseChessLocationList());
		} else {
			//location is store Locationpoing
			LocationPoint[] location = new LocationPoint[32];

			int count = 0;
			//initial LocationPoing for ChessTable
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					location[count] = new LocationPoint(j, i);
					count++;
				}
			}
			// random to change order
			for (int i = 0; i < 32; i++) {
				LocationPoint temp = location[i];
				int random = (int) (Math.random() * 32);
				location[i] = location[random];
				location[random] = temp;
			}
			
			redHorse1 = new Horse(0, true, location[0], manager.getChineseChessLocationList());
			redHorse2 = new Horse(0, true, location[1], manager.getChineseChessLocationList());
			blackHorse1 = new Horse(1, true, location[2], manager.getChineseChessLocationList());
			blackHorse2 = new Horse(1, true, location[3], manager.getChineseChessLocationList());
			redRook1 = new Rook(0, true, location[4], manager.getChineseChessLocationList());
			redRook2 = new Rook(0, true, location[5], manager.getChineseChessLocationList());
			blackRook1 = new Rook(1, true, location[6], manager.getChineseChessLocationList());
			blackRook2 = new Rook(1, true, location[7], manager.getChineseChessLocationList());
			redCannon1 = new Cannon(0, true, location[8], manager.getChineseChessLocationList());
			redCannon2 = new Cannon(0, true, location[9], manager.getChineseChessLocationList());
			blackCannon1 = new Cannon(1, true, location[10], manager.getChineseChessLocationList());
			blackCannon2 = new Cannon(1, true, location[11], manager.getChineseChessLocationList());
			redPawn1 = new Pawn(0, true, location[12], manager.getChineseChessLocationList());
			redPawn2 = new Pawn(0, true, location[13], manager.getChineseChessLocationList());
			redPawn3 = new Pawn(0, true, location[14], manager.getChineseChessLocationList());
			redPawn4 = new Pawn(0, true, location[15], manager.getChineseChessLocationList());
			redPawn5 = new Pawn(0, true, location[16], manager.getChineseChessLocationList());
			blackPawn1 = new Pawn(1, true, location[17], manager.getChineseChessLocationList());
			blackPawn2 = new Pawn(1, true, location[18], manager.getChineseChessLocationList());
			blackPawn3 = new Pawn(1, true, location[19], manager.getChineseChessLocationList());
			blackPawn4 = new Pawn(1, true, location[20], manager.getChineseChessLocationList());
			blackPawn5 = new Pawn(1, true, location[21], manager.getChineseChessLocationList());
			redKing = new King(0, true, location[22], manager.getChineseChessLocationList());
			blackKing = new King(1, true, location[23], manager.getChineseChessLocationList());
			redElephant1 = new Elephant(0, true, location[24], manager.getChineseChessLocationList());
			redElephant2 = new Elephant(0, true, location[25], manager.getChineseChessLocationList());
			blackElephant1 = new Elephant(1, true, location[26], manager.getChineseChessLocationList());
			blackElephant2 = new Elephant(1, true, location[27], manager.getChineseChessLocationList());
			redWarrior1 = new Warrior(0, true, location[28], manager.getChineseChessLocationList());
			redWarrior2 = new Warrior(0, true, location[29], manager.getChineseChessLocationList());
			blackWarrior1 = new Warrior(1, true, location[30], manager.getChineseChessLocationList());
			blackWarrior2 = new Warrior(1, true, location[31], manager.getChineseChessLocationList());
		}
	}

	public Horse getRedHorse1() {
		return redHorse1;
	}

	public Horse getRedHorse2() {
		return redHorse2;
	}

	public Horse getBlackHorse1() {
		return blackHorse1;
	}

	public Horse getBlackHorse2() {
		return blackHorse2;
	}

	public Rook getRedRook1() {
		return redRook1;
	}

	public Rook getRedRook2() {
		return redRook2;
	}

	public Rook getBlackRook1() {
		return blackRook1;
	}

	public Rook getBlackRook2() {
		return blackRook2;
	}

	public Cannon getRedCannon1() {
		return redCannon1;
	}

	public Cannon getRedCannon2() {
		return redCannon2;
	}

	public Cannon getBlackCannon1() {
		return blackCannon1;
	}

	public Cannon getBlackCannon2() {
		return blackCannon2;
	}

	public Pawn getRedPawn1() {
		return redPawn1;
	}

	public Pawn getRedPawn2() {
		return redPawn2;
	}

	public Pawn getRedPawn3() {
		return redPawn3;
	}

	public Pawn getRedPawn4() {
		return redPawn4;
	}

	public Pawn getRedPawn5() {
		return redPawn5;
	}

	public Pawn getBlackPawn1() {
		return blackPawn1;
	}

	public Pawn getBlackPawn2() {
		return blackPawn2;
	}

	public Pawn getBlackPawn3() {
		return blackPawn3;
	}

	public Pawn getBlackPawn4() {
		return blackPawn4;
	}

	public Pawn getBlackPawn5() {
		return blackPawn5;
	}

	public King getRedKing() {
		return redKing;
	}

	public King getBlackKing() {
		return blackKing;
	}

	public Elephant getRedElephant1() {
		return redElephant1;
	}

	public Elephant getRedElephant2() {
		return redElephant2;
	}

	public Elephant getBlackElephant1() {
		return blackElephant1;
	}

	public Elephant getBlackElephant2() {
		return blackElephant2;
	}

	public Warrior getRedWarrior1() {
		return redWarrior1;
	}

	public Warrior getRedWarrior2() {
		return redWarrior2;
	}

	public Warrior getBlackWarrior1() {
		return blackWarrior1;
	}

	public Warrior getBlackWarrior2() {
		return blackWarrior2;
	}

}
