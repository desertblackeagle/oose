package chessGame.frame.dialog;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FrameCheckDialog extends JDialog implements ActionListener {
	private JButton yes;
	private JButton no;
	private JLabel text;
	private JFrame toFrame = null; // 要跳到的視窗
	private JFrame source = null; // 呼叫此Dialog的視窗

	public FrameCheckDialog() {
		setVisible(true);
		initDialog();
		initTextLabel("");
	}

	public FrameCheckDialog(JFrame source, String alertText, JFrame toFrame) {
		setVisible(true);
		initDialog();
		initTextLabel(alertText);
		this.toFrame = toFrame;
		this.source = source;
	}

	private void initTextLabel(String alertText) {
		if (alertText.equals("")) {
			text = new JLabel("請問真的要關閉遊戲嗎？");
		} else {
			text = new JLabel(alertText);
		}
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setSize(150, 40);
		text.setBounds(0, 40, getSize().width, 40);
		text.setFont(new Font("細明體", Font.PLAIN, 18));
		add(text);
	}

	private void initDialog() {
		setSize(400, 200);
		setTitle("離開確認");
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		setLayout(null);

		yes = makeButton("YES");
		no = makeButton("NO");

		yes.setBounds(80, 100, 80, 40);
		no.setBounds(240, 100, 80, 40);

		yes.addActionListener(this);
		no.addActionListener(this);

		add(yes);
		add(no);
	}

	private JButton makeButton(String name) {
		return new JButton(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String temp = e.getActionCommand();
		if (temp.equals("YES")) {
			if (source != null && toFrame != null) {
				toFrame.setVisible(true);
				source.setVisible(false);
				source.dispose();
				dispose();
			} else {
				System.exit(0);
			}
		} else if (temp.equals("NO")) {
			setVisible(false);
			dispose();
		}
	}
}
