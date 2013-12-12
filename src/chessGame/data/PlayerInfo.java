package chessGame.data;

import javax.swing.ImageIcon;

import chessGame.controlUnit.GameObserver;
import chessGame.frame.ConfigureView;

public class PlayerInfo implements GameObserver {
	private static String playerNameP1 = "Player1";
	private static String playerNameP2 = "Player2";
	public static ImageIcon imgP1 = new ImageIcon("C:\\Users\\rose\\Dropbox\\JavaWorspace\\OOSE1\\src\\rose.jpg");
	public static ImageIcon imgP2 = new ImageIcon("C:\\Users\\rose\\Dropbox\\JavaWorspace\\OOSE1\\src\\rose.jpg");

	@Override
	public void update(Object obs, Object o) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(Object obs, Object o, Object o1) {
		// TODO Auto-generated method stub
		if (obs instanceof ConfigureView) {
			if (o instanceof Integer) {
				if ((Integer) o == 1) {
					if (o1 instanceof String) {
						playerNameP1 = String.valueOf(o1);
					} else if (o1 instanceof ImageIcon) {
						imgP1 = (ImageIcon) o1;
					}
				} else if ((Integer) o == 2) {
					if (o1 instanceof String) {
						playerNameP2 = String.valueOf(o1);
					} else if (o1 instanceof ImageIcon) {
						imgP2 = (ImageIcon) o1;
					}
				}
			}
		}
		System.out.println(playerNameP1 + " : " + playerNameP2 + " : " + imgP1.getDescription() + " : " + imgP2.getDescription());
	}
}
