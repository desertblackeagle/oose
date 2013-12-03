package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import selectFrame.MainView;
import chineseGameFrameElement.ChineseChessBoardPanel;
import controlUnit.BoardManager;

public class ChineseGameFrame extends GameFrame {

	public ChineseGameFrame(BoardManager manager, ButtonChessArrayList buttonArrayList, String title, int locationX, int locationY) {
		this.manager = manager;
		this.buttonArrayList = buttonArrayList;
		setLocation(locationX, locationY);
		setTitle(title);
		if (imgP1 == null) {
			picLocationP1 = initImage(picLocationP1, new ImageIcon("C:\\Users\\rose\\Dropbox\\JavaWorspace\\OOSE1\\src\\rose.jpg"), 1, 680, 0, 100, 100);
		} else {
			picLocationP1 = initImage(picLocationP1, null, 1, 680, 0, 100, 100);
		}

		if (imgP2 == null) {
			picLocationP2 = initImage(picLocationP2, new ImageIcon("C:\\Users\\rose\\Dropbox\\JavaWorspace\\OOSE1\\src\\rose.jpg"), 2, 830, 0, 100, 100);
		} else {
			picLocationP2 = initImage(picLocationP2, null, 2, 830, 0, 100, 100);
		}

		userOrder = initLabel(userOrder, "輪到紅色", 680, 150, 200, 50, 25);
		nameP1 = initLabel(nameP1, getUserName(1), 680, 100, 200, 50, 25);
		nameP2 = initLabel(nameP2, getUserName(2), 830, 100, 200, 50, 25);
		add(picLocationP1);
		add(picLocationP2);
		add(userOrder);
		add(nameP1);
		add(nameP2);

		backMainView = new JButton("返回主畫面");
		backMainView.setFont(new Font("細明體", Font.PLAIN, 25));
		backMainView.setBounds(700, 600, 200, 50);
		backMainView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				new MainView(getLocation().x, getLocation().y);
			}
		});
		add(backMainView);

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
