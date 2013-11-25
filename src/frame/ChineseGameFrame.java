package frame;

import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import chineseGameFrameElement.ChineseChessBoardPanel;
import controlUnit.BoardManager;

public class ChineseGameFrame extends GameFrame {

	public ChineseGameFrame(BoardManager manager, ButtonChessArrayList buttonArrayList, String title, int locationX, int locationY) {
		this.manager = manager;
		this.buttonArrayList = buttonArrayList;
		setLocation(locationX, locationY);
		setTitle(title);
		if (img == null) {
			try {
				picLocation = initImage(picLocation, new ImageIcon(new URL("http://i.imgur.com/NFaCYMo.jpg")), 750, 0, 100, 100);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			picLocation = initImage(picLocation, null, 750, 0, 100, 100);
		}
		userOrder = initLabel(userOrder, "輪到紅色", 750, 100, 200, 50, 25);
		add(picLocation);
		add(userOrder);

		for (int i = 0; i < buttonArrayList.getBtnArrayList().size(); i++) {
			add(buttonArrayList.getBtnArrayList().get(i));
			buttonArrayList.getBtnArrayList().get(i).addMouseListener(this);
			buttonArrayList.getBtnArrayList().get(i).addMouseMotionListener(this);
		}

		ChineseChessBoardPanel cp = new ChineseChessBoardPanel();
		cp.setBounds(0, 0, 630, 700);
		cp.setBackground(Color.BLACK);

		add(cp);
		setVisible(true);
	}

	public JLabel getUserOrder() {
		return userOrder;
	}

}
