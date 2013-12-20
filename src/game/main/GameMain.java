package game.main;

import interfaceGame.GameFactoryInterface;
import chessGame.controlUnit.ChessGameRule;
import chessGame.data.ChessGameData;
import chessGame.frame.frameOption.MainView;

public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainView frame;
		ChessGameData data;
		ChessGameRule rule;

		GameFactoryInterface game = new ChessGame();

		data = (ChessGameData) game.makeData();
		rule = (ChessGameRule) game.makeRule(data);
		frame = (MainView) game.makeFrame(data,rule);

	}

}
