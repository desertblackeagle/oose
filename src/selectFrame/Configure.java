package selectFrame;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Configure extends FrameModel implements ActionListener {

	private String from;
	private String now;
	private JButton back;
	private JButton onOff;
	private JButton way;
	private JButton decideP1;
	private JButton decideP2;
	private JButton setPictureP1;
	private JButton setPictureP2;
	private JLabel picLocationP1;
	private JLabel picLocationP2;
	private JLabel setIDP1;
	private JLabel setIDP2;
	private JLabel autoSave;
	private JLabel boardWay;
	private JTextField textP1;
	private JTextField textP2;

	public Configure(String from, String now, int locationX, int locationY) {
		super();
		this.from = from;
		this.now = now;
		setTitle(now);
		setLocation(locationX, locationY);
		createButton();
		createLabel();
		createTextField();

	}

	public void createButton() {
		back = new JButton("返回前頁");
		back.setBounds(10, 10, 206, 46);
		back.setFont(new Font("細明體", Font.PLAIN, 36));
		back.addActionListener(this);
		add(back);

		onOff = makeButton("ON");
		onOff.setFont(new Font("細明體", Font.PLAIN, 25));
		onOff.setBounds(400, 470, 150, 60);
		onOff.addActionListener(this);
		add(onOff);

		way = makeButton("直式");
		way.setFont(new Font("細明體", Font.PLAIN, 25));
		way.setBounds(400, 570, 150, 60);
		way.addActionListener(this);
		add(way);

		decideP1 = makeButton("確定");
		decideP1.setFont(new Font("細明體", Font.PLAIN, 25));
		decideP1.setBounds(600, 330, 100, 40);
		decideP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i;
				i = JOptionPane.showConfirmDialog(null, "確認修改此名字?", "修改確認", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (i == JOptionPane.YES_OPTION) {
					setUserName(textP1.getText(), 1);
					JOptionPane.showConfirmDialog(null, "已為您修改", "修改完成", JOptionPane.PLAIN_MESSAGE);
				} else {
					return;
				}
			}
		});
		decideP2 = makeButton("確定");
		decideP2.setFont(new Font("細明體", Font.PLAIN, 25));
		decideP2.setBounds(600, 410, 100, 40);
		decideP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i;
				i = JOptionPane.showConfirmDialog(null, "確認修改此名字?", "修改確認", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (i == JOptionPane.YES_OPTION) {
					setUserName(textP2.getText(), 2);
					JOptionPane.showConfirmDialog(null, "已為您修改", "修改完成", JOptionPane.PLAIN_MESSAGE);
				} else {
					return;
				}
			}
		});
		add(decideP1);
		add(decideP2);

		setPictureP1 = makeButton("設定玩家一照片");
		setPictureP1.setBounds(50, 250, 250, 60);
		setPictureP1.setFont(new Font("細明體", Font.PLAIN, 25));
		setPictureP1.addActionListener(this);
		add(setPictureP1);

		setPictureP2 = makeButton("設定玩家二照片");
		setPictureP2.setBounds(400, 250, 250, 60);
		setPictureP2.setFont(new Font("細明體", Font.PLAIN, 25));
		setPictureP2.addActionListener(this);
		add(setPictureP2);
	}

	public void createLabel() {
		setIDP1 = makeLabel("設定玩家一ID");
		setIDP2 = makeLabel("設定玩家二ID");
		autoSave = makeLabel("自動存檔");
		boardWay = makeLabel("棋盤方向");
		setIDP1.setFont(new Font("細明體", Font.PLAIN, 30));
		setIDP2.setFont(new Font("細明體", Font.PLAIN, 30));
		autoSave.setFont(new Font("細明體", Font.PLAIN, 30));
		boardWay.setFont(new Font("細明體", Font.PLAIN, 30));
		setIDP1.setBounds(100, 300, 200, 100);
		setIDP2.setBounds(100, 380, 200, 100);
		autoSave.setBounds(100, 450, 200, 100);
		boardWay.setBounds(100, 550, 200, 100);
		add(setIDP1);
		add(setIDP2);
		add(autoSave);
		add(boardWay);

		picLocationP1 = makeLabel("");
		picLocationP2 = makeLabel("");
		picLocationP1.setBounds(130, 50, 200, 200);
		picLocationP2.setBounds(480, 50, 200, 200);
		if (imgP1 != null) {
			imgP1.setImage(imgP1.getImage().getScaledInstance(100, 150, Image.SCALE_DEFAULT));
			picLocationP1.setIcon(imgP1);
		}

		if (imgP2 != null) {
			imgP2.setImage(imgP2.getImage().getScaledInstance(100, 150, Image.SCALE_DEFAULT));
			picLocationP2.setIcon(imgP2);
		}
		add(picLocationP1);
		add(picLocationP2);

	}

	public void createTextField() {
		textP1 = new JTextField(18);
		textP1.setBounds(400, 330, 150, 40);
		textP1.setFont(new Font("細明體", Font.PLAIN, 25));
		textP1.setText(getUserName(1));
		textP2 = new JTextField(18);
		textP2.setBounds(400, 410, 150, 40);
		textP2.setFont(new Font("細明體", Font.PLAIN, 25));
		textP2.setText(getUserName(2));
		add(textP1);
		add(textP2);
	}

	public JButton makeButton(String name) {
		return new JButton(name);
	}

	public JLabel makeLabel(String name) {
		return new JLabel(name);
	}

	public void btnFileAction(int p) {
		FileDialog fd = new FileDialog(this, "選擇照片", FileDialog.LOAD);
		fd.setVisible(true);
		String file = fd.getFile();
		if (file == null)
			return;
		file = fd.getDirectory() + file;
		if (p == 1) {
			imgP1 = new ImageIcon(file);
			imgP1.setImage(imgP1.getImage().getScaledInstance(100, 150, Image.SCALE_DEFAULT));
			picLocationP1.setIcon(imgP1);
		} else {
			imgP2 = new ImageIcon(file);
			imgP2.setImage(imgP2.getImage().getScaledInstance(100, 150, Image.SCALE_DEFAULT));
			picLocationP2.setIcon(imgP2);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String buttonName = e.getActionCommand();

		if (buttonName.equals("返回前頁")) {
			setVisible(false);
			dispose();
			new SecondView(from, getLocation().x, getLocation().y);
		}

		if (buttonName.equals("ON")) {
			onOff.setText("OFF");
		} else if (buttonName.equals("OFF")) {
			onOff.setText("ON");
		}

		if (buttonName.equals("直式")) {
			way.setText("橫式");
		} else if (buttonName.equals("橫式")) {
			way.setText("直式");
		}

		if (buttonName.equals("設定玩家一照片")) {
			btnFileAction(1);
		}

		if (buttonName.equals("設定玩家二照片")) {
			btnFileAction(2);
		}
	}

}
