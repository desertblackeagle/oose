package selectFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SecondView extends FrameModel implements ActionListener {

	private String from;
	private JButton startGame;
	private JButton configure;
	private JButton back;

	public SecondView(String temp, int locationX, int locationY) {
		super();
		from = temp;
		setTitle(from);
		createButton();
		setLocation(locationX, locationY);
	}

	public JButton makeButton(String name) {
		return new JButton(name);
	}

	public void createButton() {
		startGame = makeButton("開始遊戲");
		configure = makeButton("設定");
		back = makeButton("返回前頁");

		startGame.setBounds((this.getSize().width / 2) - 125, 150, 250, 100);
		configure.setBounds((this.getSize().width / 2) - 125, 300, 250, 100);
		back.setBounds(10, 10, 250, 100);

		startGame.setFont(new Font("細明體", Font.PLAIN, 36));
		configure.setFont(new Font("細明體", Font.PLAIN, 36));
		back.setFont(new Font("細明體", Font.PLAIN, 36));

		startGame.addActionListener(this);
		back.addActionListener(this);
		configure.addActionListener(this);
		
		add(startGame);
		add(configure);
		add(back);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String buttonName = e.getActionCommand();

		if (buttonName.equals("返回前頁")) {
			setVisible(false);
			dispose();
			new MainView();
		} else if (buttonName.equals("開始遊戲")) {
			setVisible(false);
			dispose();
			new ThirdView(from, buttonName, getLocation().x, getLocation().y);
		} else if (buttonName.equals("設定")) {
			setVisible(false);
			dispose();
			new Configure(from, buttonName, getLocation().x, getLocation().y);
		}

	}

}
