package frame;

import java.util.ArrayList;

import chess.ChessTable;
import controlUnit.BoardManager;
import controlUnit.LocationMap;
import frameChess.ButtonChess;

public class ButtonChessArrayList {

	private ButtonChess btnRedHorse1, btnRedHorse2, btnBlackHorse1, btnBlackHorse2, btnRedRook1, btnRedRook2, btnBlackRook1, btnBlackRook2, btnRedCannon1, btnRedCannon2, btnBlackCannon1, btnBlackCannon2, btnRedPawn1, btnRedPawn2, btnRedPawn3, btnRedPawn4, btnRedPawn5, btnBlackPawn1, btnBlackPawn2,
			btnBlackPawn3, btnBlackPawn4, btnBlackPawn5, redKing, blackKing, redElephant1, redElephant2, blackElephant1, blackElephant2, redWarrior1, redWarrior2, blackWarrior1, blackWarrior2;
	ArrayList<ButtonChess> btnArrayList;
	ChessTable chessTable;

	public ButtonChessArrayList(BoardManager manager, LocationMap locationMap, ChessTable chessTable) {
		// TODO Auto-generated constructor stub
		this.chessTable = chessTable;
		btnArrayList = new ArrayList<ButtonChess>();
		btnRedHorse1 = new ButtonChess(chessTable.getRedHorse1().getChineseName(), chessTable.getRedHorse1(), locationMap, manager.getWhichGame());
		btnRedHorse2 = new ButtonChess(chessTable.getRedHorse2().getChineseName(), chessTable.getRedHorse2(), locationMap, manager.getWhichGame());
		btnBlackHorse1 = new ButtonChess(chessTable.getBlackHorse1().getChineseName(), chessTable.getBlackHorse1(), locationMap, manager.getWhichGame());
		btnBlackHorse2 = new ButtonChess(chessTable.getBlackHorse2().getChineseName(), chessTable.getBlackHorse2(), locationMap, manager.getWhichGame());
		btnRedRook1 = new ButtonChess(chessTable.getRedRook1().getChineseName(), chessTable.getRedRook1(), locationMap, manager.getWhichGame());
		btnRedRook2 = new ButtonChess(chessTable.getRedRook2().getChineseName(), chessTable.getRedRook2(), locationMap, manager.getWhichGame());
		btnBlackRook1 = new ButtonChess(chessTable.getBlackRook1().getChineseName(), chessTable.getBlackRook1(), locationMap, manager.getWhichGame());
		btnBlackRook2 = new ButtonChess(chessTable.getBlackRook2().getChineseName(), chessTable.getBlackRook2(), locationMap, manager.getWhichGame());
		btnRedCannon1 = new ButtonChess(chessTable.getRedCannon1().getChineseName(), chessTable.getRedCannon1(), locationMap, manager.getWhichGame());
		btnRedCannon2 = new ButtonChess(chessTable.getRedCannon2().getChineseName(), chessTable.getRedCannon2(), locationMap, manager.getWhichGame());
		btnBlackCannon1 = new ButtonChess(chessTable.getBlackCannon1().getChineseName(), chessTable.getBlackCannon1(), locationMap, manager.getWhichGame());
		btnBlackCannon2 = new ButtonChess(chessTable.getBlackCannon2().getChineseName(), chessTable.getBlackCannon2(), locationMap, manager.getWhichGame());
		btnRedPawn1 = new ButtonChess(chessTable.getRedPawn1().getChineseName(), chessTable.getRedPawn1(), locationMap, manager.getWhichGame());
		btnRedPawn2 = new ButtonChess(chessTable.getRedPawn2().getChineseName(), chessTable.getRedPawn2(), locationMap, manager.getWhichGame());
		btnRedPawn3 = new ButtonChess(chessTable.getRedPawn3().getChineseName(), chessTable.getRedPawn3(), locationMap, manager.getWhichGame());
		btnRedPawn4 = new ButtonChess(chessTable.getRedPawn4().getChineseName(), chessTable.getRedPawn4(), locationMap, manager.getWhichGame());
		btnRedPawn5 = new ButtonChess(chessTable.getRedPawn5().getChineseName(), chessTable.getRedPawn5(), locationMap, manager.getWhichGame());
		btnBlackPawn1 = new ButtonChess(chessTable.getBlackPawn1().getChineseName(), chessTable.getBlackPawn1(), locationMap, manager.getWhichGame());
		btnBlackPawn2 = new ButtonChess(chessTable.getBlackPawn2().getChineseName(), chessTable.getBlackPawn2(), locationMap, manager.getWhichGame());
		btnBlackPawn3 = new ButtonChess(chessTable.getBlackPawn3().getChineseName(), chessTable.getBlackPawn3(), locationMap, manager.getWhichGame());
		btnBlackPawn4 = new ButtonChess(chessTable.getBlackPawn4().getChineseName(), chessTable.getBlackPawn4(), locationMap, manager.getWhichGame());
		btnBlackPawn5 = new ButtonChess(chessTable.getBlackPawn5().getChineseName(), chessTable.getBlackPawn5(), locationMap, manager.getWhichGame());
		redKing = new ButtonChess(chessTable.getRedKing().getChineseName(), chessTable.getRedKing(), locationMap, manager.getWhichGame());
		blackKing = new ButtonChess(chessTable.getBlackKing().getChineseName(), chessTable.getBlackKing(), locationMap, manager.getWhichGame());
		redElephant1 = new ButtonChess(chessTable.getRedElephant1().getChineseName(), chessTable.getRedElephant1(), locationMap, manager.getWhichGame());
		redElephant2 = new ButtonChess(chessTable.getRedElephant2().getChineseName(), chessTable.getRedElephant2(), locationMap, manager.getWhichGame());
		blackElephant1 = new ButtonChess(chessTable.getBlackElephant1().getChineseName(), chessTable.getBlackElephant1(), locationMap, manager.getWhichGame());
		blackElephant2 = new ButtonChess(chessTable.getBlackElephant2().getChineseName(), chessTable.getBlackElephant2(), locationMap, manager.getWhichGame());
		redWarrior1 = new ButtonChess(chessTable.getRedWarrior1().getChineseName(), chessTable.getRedWarrior1(), locationMap, manager.getWhichGame());
		redWarrior2 = new ButtonChess(chessTable.getRedWarrior2().getChineseName(), chessTable.getRedWarrior2(), locationMap, manager.getWhichGame());
		blackWarrior1 = new ButtonChess(chessTable.getBlackWarrior1().getChineseName(), chessTable.getBlackWarrior1(), locationMap, manager.getWhichGame());
		blackWarrior2 = new ButtonChess(chessTable.getBlackWarrior2().getChineseName(), chessTable.getBlackWarrior2(), locationMap, manager.getWhichGame());

		btnArrayList.add(btnRedHorse1);
		btnArrayList.add(btnRedHorse2);
		btnArrayList.add(btnBlackHorse1);
		btnArrayList.add(btnBlackHorse2);
		btnArrayList.add(btnRedRook1);
		btnArrayList.add(btnRedRook2);
		btnArrayList.add(btnBlackRook1);
		btnArrayList.add(btnBlackRook2);
		btnArrayList.add(btnRedCannon1);
		btnArrayList.add(btnRedCannon2);
		btnArrayList.add(btnBlackCannon1);
		btnArrayList.add(btnBlackCannon2);
		btnArrayList.add(btnRedPawn1);
		btnArrayList.add(btnRedPawn2);
		btnArrayList.add(btnRedPawn3);
		btnArrayList.add(btnRedPawn4);
		btnArrayList.add(btnRedPawn5);
		btnArrayList.add(btnBlackPawn1);
		btnArrayList.add(btnBlackPawn2);
		btnArrayList.add(btnBlackPawn3);
		btnArrayList.add(btnBlackPawn4);
		btnArrayList.add(btnBlackPawn5);
		btnArrayList.add(redKing);
		btnArrayList.add(blackKing);
		btnArrayList.add(redElephant1);
		btnArrayList.add(redElephant2);
		btnArrayList.add(blackElephant1);
		btnArrayList.add(blackElephant2);
		btnArrayList.add(redWarrior1);
		btnArrayList.add(redWarrior2);
		btnArrayList.add(blackWarrior1);
		btnArrayList.add(blackWarrior2);
	}

	public ArrayList<ButtonChess> getBtnArrayList() {
		return btnArrayList;
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		BoardManager manager = new BoardManager(1);
//		LocationMap locationMap = new LocationMap();
//		ButtonChessArrayList test = new ButtonChessArrayList(manager, locationMap);
//		for (int i = 0; i < test.btnArrayList.size(); i++) {
//			System.out.println(test.btnArrayList.get(i).getClass());
//		}
//	}

}
