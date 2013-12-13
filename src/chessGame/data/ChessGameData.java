package chessGame.data;

import interfaceGame.DataInterface;

public class ChessGameData implements DataInterface {
	private static ChessGameData data = null;
	ConfigData config;
	LocationMap locMap;

	private ChessGameData() {
		// TODO Auto-generated constructor stub
		createData();
	}

	public void createData() {
		config = new ConfigData();
		locMap = new LocationMap();
	}

	public static ChessGameData instance() {
		if (data == null)
			data = new ChessGameData();
		return data;
	}

	public LocationMap getLocMap() {
		return locMap;
	}

	public ConfigData getConfigData() {
		return config;
	}
}
