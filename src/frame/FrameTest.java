package frame;

import chess.ChessTable;
import controlUnit.BoardManager;
import controlUnit.LocationMap;

public class FrameTest {

	static final int chineseChess = 1;
	static final int taiwaneseChess = 0;

	public FrameTest(String from, int locationX, int locationY) {
		// TODO Auto-generated constructor stub
		LocationMap locationMap = new LocationMap();
		if (from.equals("中國棋")) {
			BoardManager manager = new BoardManager(chineseChess);
			ChessTable chessTable = new ChessTable(manager);
			ButtonChessArrayList buttonArrayList = new ButtonChessArrayList(manager, chessTable);
			new ChineseGameFrame(manager, buttonArrayList,from, locationX, locationY);
		} else {
			BoardManager manager = new BoardManager(taiwaneseChess);
			ChessTable chessTable = new ChessTable(manager);
			ButtonChessArrayList buttonArrayList = new ButtonChessArrayList(manager, chessTable);
			new TaiwanGameFrame(manager, buttonArrayList,from, locationX, locationY);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BoardManager manager = new BoardManager(chineseChess,locationMap);
		BoardManager manager = new BoardManager(taiwaneseChess);
		ChessTable chessTable = new ChessTable(manager);
//		ButtonChessArrayList buttonArrayList = new ButtonChessArrayList(manager, locationMap, chessTable);
//		ChineseGameFrame gameFrame = new ChineseGameFrame(manager,buttonArrayList);
//		TaiwanGameFrame gameFrame = new TaiwanGameFrame(manager, buttonArrayList);

	}
}
