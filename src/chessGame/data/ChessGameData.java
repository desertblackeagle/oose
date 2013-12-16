package chessGame.data;

import interfaceGame.DataInterface;
import chessGame.data.chess.ChessTable;
import chessGame.data.status.GameStatus;

public class ChessGameData implements DataInterface {
	private static ChessGameData data = null;
	private ConfigData config;
	private LocationMap locMap;
	private ChessTable ct;
	private GameStatus gameStatus;

	private ChessGameData() {
		// TODO Auto-generated constructor stub
		createData();
	}

	public void createData() {
		config = new ConfigData();
		locMap = new LocationMap();
		ct = new ChessTable();
		gameStatus = new GameStatus();
	}

	public static ChessGameData instance() {
		if (data == null)
			data = new ChessGameData();
		return data;
	}

//	public LocationMap getLocMap() {
//		return locMap;
//	}

	public ConfigData getConfigData() {
		return config;
	}

	public ChessTable getChessTable() {
		return ct;
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}

}
