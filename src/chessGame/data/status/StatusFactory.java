package chessGame.data.status;

public interface StatusFactory {
	public RecordInterface makeChessRecord();

	public LocationInterface makeChessLocation();

	public StatusInterface makeChessStatus();
}
