package frame;

import chess.ChessTable;
import controlUnit.BoardManager;
import controlUnit.LocationMap;

public class FrameTest {

	static final int chineseChess = 1;
	static final int taiwaneseChess = 0;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocationMap locationMap = new LocationMap();
//		BoardManager manager = new BoardManager(chineseChess,locationMap);
		BoardManager manager = new BoardManager(taiwaneseChess,locationMap);
		ChessTable chessTable = new ChessTable(manager);
		ButtonChessArrayList buttonArrayList = new ButtonChessArrayList(manager, locationMap, chessTable);
//		ChineseGameFrame gameFrame = new ChineseGameFrame(manager,buttonArrayList);
		TaiwanGameFrame gameFrame = new TaiwanGameFrame(manager, buttonArrayList);
		
		manager.printChess();
		
		
		
		manager.printChess();
		
	}
}
