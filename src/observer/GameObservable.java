package observer;

import java.util.ArrayList;

public abstract class GameObservable {
	protected ArrayList<ChessObserver> observerList = new ArrayList<ChessObserver>();

	public void addObserver(ChessObserver o) {
		observerList.add(o);
	}

	public void notifyAll(Object source, Object o1) {
		for (ChessObserver o : observerList) {
			o.update(source, o1);
		}
	}

	public void notifyAll(Object source, Object o1, Object o2) {
		for (ChessObserver o : observerList) {
			o.update(source, o1, o2);
		}
	}

	public void notifyObserver(Object source, String target, Object o1) {
		for (ChessObserver o : observerList) {
			if (o.getClass().getSimpleName().equals(target)) {
				o.update(source, o1);
			}
		}
	}

	public void notifyObserver(Object source, String target, Object o1, Object o2) {
		for (ChessObserver o : observerList) {
			if (o.getClass().getSimpleName().equals(target)) {
				o.update(source, o1, o2);
			}
		}
	}
}
