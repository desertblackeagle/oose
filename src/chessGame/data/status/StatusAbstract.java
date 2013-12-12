package chessGame.data.status;

import chessGame.controlUnit.GameObserver;

public abstract class StatusAbstract implements GameObserver {
	public abstract void chessRecord();

	public abstract void chessLocation();

	public abstract void chessStatus();
}
