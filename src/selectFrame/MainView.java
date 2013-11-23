package selectFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MainView extends FrameModel implements ActionListener {

	private JButton chinaChess;
	private JButton kuroChess;
	private JButton exit;

	public MainView() {
		super();
		setTitle("主畫面");
		createButton();
	}

	public JButton makeButton(String name) {
		return new JButton(name);
	}

	public void createButton() {
		chinaChess = makeButton("中國棋");
		kuroChess = makeButton("暗棋");
		exit = makeButton("離開");

		chinaChess.setBounds((this.getSize().width / 2) - 125, 150, 250, 100);
		kuroChess.setBounds((this.getSize().width / 2) - 125, 300, 250, 100);
		exit.setBounds((this.getSize().width / 2) - 125, 450, 250, 100);

		chinaChess.setFont(new Font("細明體", Font.PLAIN, 36));
		kuroChess.setFont(new Font("細明體", Font.PLAIN, 36));
		exit.setFont(new Font("細明體", Font.PLAIN, 36));

		chinaChess.addActionListener(this);
		kuroChess.addActionListener(this);
		exit.addActionListener(this);

		add(chinaChess);
		add(kuroChess);
		add(exit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonName = e.getActionCommand();
		if (buttonName.equals("離開")) {
			new FrameCheck("請問真的要離開遊戲嗎？");
		} else {
			setVisible(false);
			dispose();
			new SecondView(buttonName, getLocation().x, getLocation().y);
		}
	}

	public static void main(String[] args) {
		new MainView();
	}

}
