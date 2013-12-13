package interfaceGame;

import chessGame.data.ChessGameData;

public interface GameFactoryInterface {
	public FrameInterface makeFrame(ChessGameData data);

	public RuleInterface makeRule();

	public DataInterface makeData();
}
