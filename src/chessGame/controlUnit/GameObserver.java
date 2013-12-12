package chessGame.controlUnit;

public interface GameObserver {
	public void update(Object obs, Object o);

	public void update(Object obs, Object o, Object o1);
}
