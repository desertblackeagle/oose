package chessGame.controlUnit;

import interfaceGame.RuleInterface;

public class ChessGameRule implements RuleInterface {
	private static ChessGameRule rule = null;

	private ChessGameRule() {
		// TODO Auto-generated constructor stub
		createData();
	}

	public void createData() {

	}

	public static ChessGameRule instance() {
		if (rule == null)
			rule = new ChessGameRule();
		return rule;
	}
}
