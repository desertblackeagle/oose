package chessGame.frame;

import java.util.ArrayList;

import chessGame.data.ChessData;
import chessGame.data.ChessGameData;
import chessGame.data.LocationPoint;
import chessGame.frame.chess.Cannon;
import chessGame.frame.chess.Elephant;
import chessGame.frame.chess.Horse;
import chessGame.frame.chess.King;
import chessGame.frame.chess.Pawn;
import chessGame.frame.chess.Rook;
import chessGame.frame.chess.Warrior;

/* @author Red Rose
 * Function:a table to create and store chess
 * Last Update:2013/11/15
 */
public class ChessTable {
	static final int chinessChess = 1;
	static final int taiwanChess = 0;

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
	private ArrayList<Chess> chineseChessList = new ArrayList<Chess>();
	private ArrayList<Chess> taiwanChessList = new ArrayList<Chess>();

	private String file = "C:\\dark\\";

	public ChessTable(ChessGameData data) {
		// TODO Auto-generated constructor stub
		java.net.URL imUrl = getClass().getResource("/chess");
		System.out.println("999999999999999999999999999999999999999999999999999" + imUrl);
		file = imUrl.toString().substring(6, imUrl.toString().length());
		file = file + "/";
		System.out.println("999999999999999999999999999999999999999999999999999" + file);
		create(data);
	}

	public void create(ChessGameData data) {
		if (data.getGameStatus().getChessStatus().getWhichGame() == chinessChess) {
			if (!chineseChessList.isEmpty()) {
				chineseChessList.clear();
			}

			redHorse1 = new Horse(file + "redHorse.png", 0, false, 1, 9, data);
			redHorse2 = new Horse(file + "redHorse.png", 0, false, 7, 9, data);
			blackHorse1 = new Horse(file + "blackHorse.png", 1, false, 1, 0, data);
			blackHorse2 = new Horse(file + "blackHorse.png", 1, false, 7, 0, data);
			redRook1 = new Rook(file + "redRook.png", 0, false, 0, 9, data);
			redRook2 = new Rook(file + "redRook.png", 0, false, 8, 9, data);
			blackRook1 = new Rook(file + "blackRook.png", 1, false, 0, 0, data);
			blackRook2 = new Rook(file + "blackRook.png", 1, false, 8, 0, data);
			redCannon1 = new Cannon(file + "redCannon.png", 0, false, 1, 7, data);
			redCannon2 = new Cannon(file + "redCannon.png", 0, false, 7, 7, data);
			blackCannon1 = new Cannon(file + "blackCannon.png", 1, false, 1, 2, data);
			blackCannon2 = new Cannon(file + "blackCannon.png", 1, false, 7, 2, data);
			redPawn1 = new Pawn(file + "redPawn.png", 0, false, 0, 6, data);
			redPawn2 = new Pawn(file + "redPawn.png", 0, false, 2, 6, data);
			redPawn3 = new Pawn(file + "redPawn.png", 0, false, 4, 6, data);
			redPawn4 = new Pawn(file + "redPawn.png", 0, false, 6, 6, data);
			redPawn5 = new Pawn(file + "redPawn.png", 0, false, 8, 6, data);
			blackPawn1 = new Pawn(file + "blackPawn.png", 1, false, 0, 3, data);
			blackPawn2 = new Pawn(file + "blackPawn.png", 1, false, 2, 3, data);
			blackPawn3 = new Pawn(file + "blackPawn.png", 1, false, 4, 3, data);
			blackPawn4 = new Pawn(file + "blackPawn.png", 1, false, 6, 3, data);
			blackPawn5 = new Pawn(file + "blackPawn.png", 1, false, 8, 3, data);
			redKing = new King(file + "redKing.png", 0, false, 4, 9, data);
			blackKing = new King(file + "blackKing.png", 1, false, 4, 0, data);
			redElephant1 = new Elephant(file + "redElephant.png", 0, false, 2, 9, data);
			redElephant2 = new Elephant(file + "redElephant.png", 0, false, 6, 9, data);
			blackElephant1 = new Elephant(file + "blackElephant.png", 1, false, 2, 0, data);
			blackElephant2 = new Elephant(file + "blackElephant.png", 1, false, 6, 0, data);
			redWarrior1 = new Warrior(file + "redWarrior.png", 0, false, 3, 9, data);
			redWarrior2 = new Warrior(file + "redWarrior.png", 0, false, 5, 9, data);
			blackWarrior1 = new Warrior(file + "blackWarrior.png", 1, false, 3, 0, data);
			blackWarrior2 = new Warrior(file + "blackWarrior.png", 1, false, 5, 0, data);
			chineseChessList.add(redHorse1);
			chineseChessList.add(redHorse2);
			chineseChessList.add(blackHorse1);
			chineseChessList.add(blackHorse2);
			chineseChessList.add(redRook1);
			chineseChessList.add(redRook2);
			chineseChessList.add(blackRook1);
			chineseChessList.add(blackRook2);
			chineseChessList.add(redCannon1);
			chineseChessList.add(redCannon2);
			chineseChessList.add(blackCannon1);
			chineseChessList.add(blackCannon2);
			chineseChessList.add(redPawn1);
			chineseChessList.add(redPawn2);
			chineseChessList.add(redPawn3);
			chineseChessList.add(redPawn4);
			chineseChessList.add(redPawn5);
			chineseChessList.add(blackPawn1);
			chineseChessList.add(blackPawn2);
			chineseChessList.add(blackPawn3);
			chineseChessList.add(blackPawn4);
			chineseChessList.add(blackPawn5);
			chineseChessList.add(redKing);
			chineseChessList.add(blackKing);
			chineseChessList.add(redElephant1);
			chineseChessList.add(redElephant2);
			chineseChessList.add(blackElephant1);
			chineseChessList.add(blackElephant2);
			chineseChessList.add(redWarrior1);
			chineseChessList.add(redWarrior2);
			chineseChessList.add(blackWarrior1);
			chineseChessList.add(blackWarrior2);

		} else {
			// location is store Locationpoing
			LocationPoint[] location = new LocationPoint[32];

			int count = 0;
			// initial LocationPoing for ChessTable
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
			for (int i = 0; i < 32; i++) {
				LocationPoint temp = location[i];
				int random = (int) (Math.random() * 32);
				location[i] = location[random];
				location[random] = temp;
			}
			if (!taiwanChessList.isEmpty()) {
				taiwanChessList.clear();
			}

			redHorse1 = new Horse(file + "redHorse.png", 0, true, location[0], data);
			redHorse2 = new Horse(file + "redHorse.png", 0, true, location[1], data);
			blackHorse1 = new Horse(file + "blackHorse.png", 1, true, location[2], data);
			blackHorse2 = new Horse(file + "blackHorse.png", 1, true, location[3], data);
			redRook1 = new Rook(file + "redRook.png", 0, true, location[4], data);
			redRook2 = new Rook(file + "redRook.png", 0, true, location[5], data);
			blackRook1 = new Rook(file + "blackRook.png", 1, true, location[6], data);
			blackRook2 = new Rook(file + "blackRook.png", 1, true, location[7], data);
			redCannon1 = new Cannon(file + "redCannon.png", 0, true, location[8], data);
			redCannon2 = new Cannon(file + "redCannon.png", 0, true, location[9], data);
			blackCannon1 = new Cannon(file + "blackCannon.png", 1, true, location[10], data);
			blackCannon2 = new Cannon(file + "blackCannon.png", 1, true, location[11], data);
			redPawn1 = new Pawn(file + "redPawn.png", 0, true, location[12], data);
			redPawn2 = new Pawn(file + "redPawn.png", 0, true, location[13], data);
			redPawn3 = new Pawn(file + "redPawn.png", 0, true, location[14], data);
			redPawn4 = new Pawn(file + "redPawn.png", 0, true, location[15], data);
			redPawn5 = new Pawn(file + "redPawn.png", 0, true, location[16], data);
			blackPawn1 = new Pawn(file + "blackPawn.png", 1, true, location[17], data);
			blackPawn2 = new Pawn(file + "blackPawn.png", 1, true, location[18], data);
			blackPawn3 = new Pawn(file + "blackPawn.png", 1, true, location[19], data);
			blackPawn4 = new Pawn(file + "blackPawn.png", 1, true, location[20], data);
			blackPawn5 = new Pawn(file + "blackPawn.png", 1, true, location[21], data);
			redKing = new King(file + "redKing.png", 0, true, location[22], data);
			blackKing = new King(file + "blackKing.png", 1, true, location[23], data);
			redElephant1 = new Elephant(file + "redElephant.png", 0, true, location[24], data);
			redElephant2 = new Elephant(file + "redElephant.png", 0, true, location[25], data);
			blackElephant1 = new Elephant(file + "blackElephant.png", 1, true, location[26], data);
			blackElephant2 = new Elephant(file + "blackElephant.png", 1, true, location[27], data);
			redWarrior1 = new Warrior(file + "redWarrior.png", 0, true, location[28], data);
			redWarrior2 = new Warrior(file + "redWarrior.png", 0, true, location[29], data);
			blackWarrior1 = new Warrior(file + "blackWarrior.png", 1, true, location[30], data);
			blackWarrior2 = new Warrior(file + "blackWarrior.png", 1, true, location[31], data);
			taiwanChessList.add(redHorse1);
			taiwanChessList.add(redHorse2);
			taiwanChessList.add(blackHorse1);
			taiwanChessList.add(blackHorse2);
			taiwanChessList.add(redRook1);
			taiwanChessList.add(redRook2);
			taiwanChessList.add(blackRook1);
			taiwanChessList.add(blackRook2);
			taiwanChessList.add(redCannon1);
			taiwanChessList.add(redCannon2);
			taiwanChessList.add(blackCannon1);
			taiwanChessList.add(blackCannon2);
			taiwanChessList.add(redPawn1);
			taiwanChessList.add(redPawn2);
			taiwanChessList.add(redPawn3);
			taiwanChessList.add(redPawn4);
			taiwanChessList.add(redPawn5);
			taiwanChessList.add(blackPawn1);
			taiwanChessList.add(blackPawn2);
			taiwanChessList.add(blackPawn3);
			taiwanChessList.add(blackPawn4);
			taiwanChessList.add(blackPawn5);
			taiwanChessList.add(redKing);
			taiwanChessList.add(blackKing);
			taiwanChessList.add(redElephant1);
			taiwanChessList.add(redElephant2);
			taiwanChessList.add(blackElephant1);
			taiwanChessList.add(blackElephant2);
			taiwanChessList.add(redWarrior1);
			taiwanChessList.add(redWarrior2);
			taiwanChessList.add(blackWarrior1);
			taiwanChessList.add(blackWarrior2);
		}
	}

//	public void clearTable() {
//		if (!taiwanChessList.isEmpty()) {
//			taiwanChessList.clear();
//		}
//		if (!chineseChessList.isEmpty()) {
//			chineseChessList.clear();
//		}
////		System.out.println("get " + taiwanChessList.get(5));
////		System.out.println("size " + taiwanChessList.size());
////		System.out.println("size " + chineseChessList.size());
//	}

//	public void allReLocation() {
//		int co = 0;
//		if (!taiwanChessList.isEmpty()) {
//			for (Chess c : taiwanChessList) {
//				co++;
//				System.out.print(co + " ");
//				((ChessView) c).reLocation();
//			}
//		} else {
//			System.out.println("taiwanChessList is Empty");
//		}
//
//		if (!chineseChessList.isEmpty()) {
//			for (Chess c : chineseChessList) {
//				co++;
//				System.out.print(co + " ");
//				((ChessView) c).reLocation();
//			}
//		} else {
//			System.out.println("chineseChessList is Empty");
//		}
//		System.out.println("table clear");
//	}

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

	public ArrayList<Chess> getChessList(int w) {
		if (w == taiwanChess) {
			return taiwanChessList;
		} else {
			return chineseChessList;
		}
	}

	public ArrayList<Chess> getChineseChessList() {
		return chineseChessList;
	}

	public ArrayList<Chess> getTaiwanChessList() {
		return taiwanChessList;
	}

	public ArrayList<ChessData> getAllChineseChessData() {
		ArrayList<ChessData> array = new ArrayList<ChessData>();
		for (Chess c : chineseChessList) {
			LocationPoint tmp = new LocationPoint(c.getChessX(), c.getChessY());
			ChessData chessData = new ChessData(tmp, c.isChessDead(), c.isChessCover());
			array.add(chessData);
		}
		return array;
	}

	public ArrayList<ChessData> getAllTaiwanChessData() {
		ArrayList<ChessData> array = new ArrayList<ChessData>();
		for (Chess c : taiwanChessList) {
			LocationPoint tmp = new LocationPoint(c.getChessX(), c.getChessY());
			ChessData chessData = new ChessData(tmp, c.isChessDead(), c.isChessCover());
			array.add(chessData);
		}
		return array;
	}

	public void loadAllChineseChessData(ArrayList<ChessData> array) {
		int cnt = 0;
		for (Chess c : chineseChessList) {
			c.setChessX(array.get(cnt).getPoint().getX());
			c.setChessY(array.get(cnt).getPoint().getY());
			c.setChessCover(array.get(cnt).isChessCover());
			c.setChessDead(array.get(cnt).isChessDead());
			cnt++;
		}
	}

	public void loadAllTaiwanChessData(ArrayList<ChessData> array) {
		int cnt = 0;
		for (Chess c : taiwanChessList) {
			c.setChessX(array.get(cnt).getPoint().getX());
			c.setChessY(array.get(cnt).getPoint().getY());
			c.setChessCover(array.get(cnt).isChessCover());
			c.setChessDead(array.get(cnt).isChessDead());
			cnt++;
		}
	}

	public void setAllChess(Chess[][] chess) {
		for (Chess c : chineseChessList) {
			if (chess[c.getChessY()][c.getChessX()] != null) {
				if (!c.isChessDead()) {
					c.setChessDead(chess[c.getChessY()][c.getChessX()].isChessDead());
					c.setChessCover(chess[c.getChessY()][c.getChessX()].isChessCover());
				}
			}
		}
	}
}
