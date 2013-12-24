package game.main;

import chessGame.controlUnit.ChessGameRule;
import chessGame.controlUnit.RuleInterface;
import chessGame.data.ChessGameData;
import chessGame.data.DataInterface;
import chessGame.frame.MainView;
import chessGame.frame.board.FrameInterface;

public class ChessGame extends GameFactory {

	@Override
	public FrameInterface makeFrame(ChessGameData data, ChessGameRule rule) {
		// TODO Auto-generated method stub
		return new MainView(true, data, rule);
	}

	@Override
	public RuleInterface makeRule(ChessGameData data) {
		// TODO Auto-generated method stub
		return ChessGameRule.instance(data);
	}

	@Override
	public DataInterface makeData() {
		// TODO Auto-generated method stub
		return ChessGameData.instance();
	}

}
