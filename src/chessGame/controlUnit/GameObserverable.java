package chessGame.controlUnit;

import java.util.ArrayList;

public class GameObserverable {
	ArrayList<GameObserver> list;

	public GameObserverable() {
		// TODO Auto-generated constructor stub
		list = new ArrayList<GameObserver>();
	}

	public void addObserver(GameObserver o){
		list.add(o);
	}
	
	public void notifyObserver(Object o) {
		for (GameObserver go : list) {
			go.update(o);
		}
	}
}
