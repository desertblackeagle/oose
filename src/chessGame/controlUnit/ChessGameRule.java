package chessGame.controlUnit;

import chessGame.data.ChessGameData;
import interfaceGame.RuleInterface;

public class ChessGameRule implements RuleInterface {
	private static ChessGameRule rule = null;
	private BoardManager boardMgr;
	private ChessRule chessRule;

	private ChessGameRule(ChessGameData data) {
		// TODO Auto-generated constructor stub
		createData(data);
	}

	public void createData(ChessGameData data) {
		chessRule = new ChessRule();
//		boardMgr = new BoardManager(data.getGameStatus().getChessStatus().getWhichGame());
	}

	public static ChessGameRule instance(ChessGameData data) {
		if (rule == null)
			rule = new ChessGameRule(data);
		return rule;
	}

	public ChessRule getChessRule() {
		return chessRule;
	}

}
