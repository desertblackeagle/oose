package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import selectFrame.MainView;
import taiwanGameFrameElement.TaiwanChessBoardPanel;
import controlUnit.BoardManager;

public class TaiwanGameFrame extends GameFrame {

	public TaiwanGameFrame(BoardManager manager, ButtonChessArrayList buttonArrayList, String title, int locationX, int locationY) {
		this.manager = manager;
		this.whichGame = manager.getWhichGame();
		this.buttonArrayList = buttonArrayList;
		setLocation(locationX, locationY);
		setTitle(title);
		if (imgP1 == null) {
			picLocationP1 = initImage(picLocationP1, new ImageIcon("C:\\Users\\rose\\Dropbox\\JavaWorspace\\OOSE1\\src\\rose.jpg"), 1, 750, 0, 100, 100);
		} else {
			picLocationP1 = initImage(picLocationP1, null, 1, 750, 0, 100, 100);
		}
		userOrder = initLabel(userOrder, "決定顏色", 750, 100, 100, 50, 25);
		add(picLocationP1);
		add(userOrder);

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

		TaiwanChessBoardPanel cp = new TaiwanChessBoardPanel();
		cp.setBounds(0, 0, 630, 700);
		cp.setBackground(Color.BLACK);
		add(cp);
		setVisible(true);
	}

}
