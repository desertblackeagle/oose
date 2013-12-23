package chessGame.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InfoFrame extends JFrame implements ActionListener {
	private static InfoFrame infoFrame = null;
	private JButton confirm;
	private JLabel textLabel;

	private InfoFrame(String text, int locX, int locY) {
		// TODO Auto-generated constructor stub
		setSize(400, 200);
		setVisible(true);
		setLayout(null);
		setResizable(false);
		setLocation(locX, locY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		confirm = new JButton("確定");
		confirm.setBounds(150, 100, 100, 50);
		confirm.addActionListener(this);
		add(confirm);

		textLabel = new JLabel();

		textLabel.setFont(new Font(text, Font.PLAIN, 25));
		textLabel.setHorizontalAlignment(SwingConstants.CENTER);
		textLabel.setText(text);
//		setLocationRelativeTo(null);
		textLabel.setBounds(50, 25, 300, 50);
		add(textLabel);
	}

	public static InfoFrame instance(String text, int locX, int locY) {
//		if (infoFrame == null) {
			infoFrame = new InfoFrame(text, locX, locY);
//		}
		
//		infoFrame.setVisible(true);
		return infoFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("確定")) {
			dispose();
		}
	}

	public static void main(String[] args) {
		InfoFrame iff = new InfoFrame("錯誤", 100, 100);
	}
}
