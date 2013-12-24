package game.main;

import chessGame.controlUnit.ChessGameRule;
import chessGame.controlUnit.RuleInterface;
import chessGame.data.ChessGameData;
import chessGame.data.DataInterface;
import chessGame.frame.board.FrameInterface;

public abstract class GameFactory {
	
	public abstract FrameInterface makeFrame(ChessGameData data, ChessGameRule rule);

	public abstract RuleInterface makeRule(ChessGameData data);

	public abstract DataInterface makeData();
}
