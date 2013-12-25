package chessGame.data;

import chessGame.data.interfaceData.LocationInterface;
import chessGame.data.interfaceData.RecordInterface;
import chessGame.data.interfaceData.StatusFactory;
import chessGame.data.interfaceData.StatusInterface;


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
