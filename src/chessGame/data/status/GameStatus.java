package chessGame.data.status;

import chessGame.data.ChessGameData;

public class GameStatus implements StatusFactory {
	private ChessRecord chessRecord;
	private ChessList chessList;
	private ChessStatus chessStatus;
	private ChessGameData data;

	public GameStatus(ChessGameData data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		chessRecord = (ChessRecord) makeChessRecord();
		chessList = (ChessList) makeChessLocation();
		chessStatus = (ChessStatus) makeChessStatus();
	}

	@Override
	public RecordInterface makeChessRecord() {
		// TODO Auto-generated method stub
		return new ChessRecord();
	}

	@Override
	public LocationInterface makeChessLocation() {
		// TODO Auto-generated method stub
		return new ChessList(data);
	}

	@Override
	public StatusInterface makeChessStatus() {
		// TODO Auto-generated method stub
		return new ChessStatus();
	}

	public ChessRecord getChessRecord() {
		return chessRecord;
	}

	public ChessList getChessList() {
		return chessList;
	}

	public ChessStatus getChessStatus() {
		return chessStatus;
	}

}
