package chessGame.data.status;

import chessGame.controlUnit.GameObserver;

public abstract class StatusAbstract implements GameObserver {
	public abstract void makeChessRecord();

	public abstract void makeChessLocation();

	public abstract void makeChessStatus();
}
