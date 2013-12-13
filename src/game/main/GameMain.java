package game.main;

import chessGame.controlUnit.ChessGameRule;
import chessGame.data.ChessGameData;
import chessGame.frame.frameOption.MainView;
import interfaceGame.GameFactoryInterface;

public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainView frame;
		ChessGameData data;
		ChessGameRule rule;

		GameFactoryInterface game = new ChessGame();

		data = (ChessGameData) game.makeData();
		frame = (MainView) game.makeFrame(data);
		rule = (ChessGameRule) game.makeRule();

	}

}
