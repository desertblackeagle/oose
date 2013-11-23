package frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InfoFrame extends JDialog implements ActionListener {
	private JButton confirm;
	private JLabel text;

	public InfoFrame(String alertText, String alertTitle, int locationX, int locationY) {
		setTitle(alertTitle);
		setSize(400, 200);
		setModal(true);
		setLocationRelativeTo(null);
		setLayout(null);
		setLocation(locationX, locationY);
		
		confirm = makeButton("確定");
		confirm.setBounds((getSize().width / 2) - 45, 100, 80, 40);
		confirm.addActionListener(this);

		text = new JLabel(alertText);
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setSize(150, 40);
		text.setBounds(0, 40, getSize().width, 40);
		text.setFont(new Font("細明體", Font.PLAIN, 18));

		add(confirm);
		add(text);
		setVisible(true);
	}

	private JButton makeButton(String name) {
		return new JButton(name);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InfoFrame test = new InfoFrame("紅色贏了", "獲勝通知", 0, 0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String temp = e.getActionCommand();
		if (temp.equals("確定")) {
			System.exit(0);
		}
	}

}
