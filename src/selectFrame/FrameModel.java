package selectFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FrameModel extends JFrame {

	private static String userName = "";
	public static ImageIcon img = null;

	public FrameModel() {
		initComponents();
		initEventListeners();
		setVisible(true);
	}

	public void initComponents() {
		setSize(1000, 739);
		setLocationRelativeTo(null);
		setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
	}

	public void initEventListeners() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new FrameCheck();
			}
		});
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String temp) {
		userName = temp;
	}

	public void changeLabelText(JLabel label, String text) {
		if (label == null) {
			System.out.println("LABEl is NULL");
		}
		label.setText(text);
	}

	public JLabel initImage(JLabel label, ImageIcon image, int x, int y, int width, int height) {
		if (image != null) {
			img = image;
		}
		label = new JLabel(img);
		label.setBounds(x, y, width, height);
		return label;
	}

	public JLabel initLabel(JLabel label, String text, int x, int y, int width, int height, int size) {
		label = new JLabel(text);
		label.setFont(new Font("細明體", Font.PLAIN, size));
		label.setBounds(x, y, width, height);
		return label;
	}
}

class FrameCheck extends JDialog implements ActionListener {

	private JButton yes;
	private JButton no;
	private JLabel text;

	public FrameCheck() {
		initDialog();
		initTextLabel("");
		setVisible(true);
	}

	public FrameCheck(String alertText) {
		initDialog();
		initTextLabel(alertText);
		setVisible(true);
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
		setTitle("離開確認");
		setSize(400, 200);
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
			System.exit(0);
		} else if (temp.equals("NO")) {
			setVisible(false);
			dispose();
		}
	}
}
