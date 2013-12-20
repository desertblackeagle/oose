package game.main;

import interfaceGame.DataInterface;
import interfaceGame.FrameInterface;
import interfaceGame.GameFactoryInterface;
import interfaceGame.RuleInterface;
import chessGame.controlUnit.ChessGameRule;
import chessGame.data.ChessGameData;
import chessGame.frame.frameOption.MainView;

public class ChessGame implements GameFactoryInterface {

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
