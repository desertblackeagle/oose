package interfaceGame;

import chessGame.controlUnit.ChessGameRule;
import chessGame.data.ChessGameData;

public interface GameFactoryInterface {
	public FrameInterface makeFrame(ChessGameData data, ChessGameRule rule);

	public RuleInterface makeRule(ChessGameData data);

	public DataInterface makeData();
}
