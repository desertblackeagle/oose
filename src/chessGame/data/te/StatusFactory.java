package chessGame.data.te;


public interface StatusFactory {
	public RecordInterface makeChessRecord();

	public LocationInterface makeChessLocation();

	public StatusInterface makeChessStatus();
}
