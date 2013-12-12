package chessGame.data;

import interfaceGame.DataInterface;

public class ChessGameData implements DataInterface {
	PlayerInfo playerInfo;
	LocationMap locMap;

	public void createData() {
		playerInfo = new PlayerInfo();
		locMap = new LocationMap();
	}

	public LocationMap getLocMap() {
		return locMap;
	}

	public PlayerInfo getPlayerInfo() {
		return playerInfo;
	}
}
