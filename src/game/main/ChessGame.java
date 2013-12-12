package game.main;

import interfaceGame.DataInterface;
import interfaceGame.FrameInterface;
import interfaceGame.GameFactoryInterface;
import interfaceGame.RuleInterface;
import chessGame.data.ChessGameData;
import chessGame.frame.MainView;

public class ChessGame implements GameFactoryInterface {

	@Override
	public FrameInterface makeFrame() {
		// TODO Auto-generated method stub
		return new MainView(true);
	}

	@Override
	public RuleInterface makeRule() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataInterface makeData() {
		// TODO Auto-generated method stub
		return new ChessGameData();
	}

}
