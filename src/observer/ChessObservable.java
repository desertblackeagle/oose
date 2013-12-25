package observer;

public class ChessObservable extends GameObservable {
	public void setObserverConnect() {
		for (ChessObserver co : observerList) {
			co.connectTarget();
		}
	}
}
