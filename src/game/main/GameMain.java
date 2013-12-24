package game.main;

import chessGame.controlUnit.ChessGameRule;
import chessGame.data.ChessGameData;
import chessGame.frame.MainView;

public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainView frame;
		ChessGameData data;
		ChessGameRule rule;

		GameFactory game = new ChessGame();

		data = (ChessGameData) game.makeData();
		rule = (ChessGameRule) game.makeRule(data);
		frame = (MainView) game.makeFrame(data,rule);

	}

}
