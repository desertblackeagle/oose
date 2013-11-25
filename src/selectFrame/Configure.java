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
	private JButton decide;
	private JButton setPicture;
	private JLabel picLocation;
	private JLabel setID;
	private JLabel autoSave;
	private JLabel boardWay;
	private JTextField text;

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
		back.setBounds(10, 10, 256, 96);
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

		decide = makeButton("確定");
		decide.setFont(new Font("細明體", Font.PLAIN, 25));
		decide.setBounds(600, 380, 100, 40);
		decide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i;
				i = JOptionPane.showConfirmDialog(null, "確認修改此名字?", "修改確認", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (i == JOptionPane.YES_OPTION) {
					setUserName(text.getText());
					JOptionPane.showConfirmDialog(null, "已為您修改", "修改完成", JOptionPane.PLAIN_MESSAGE);
				} else {
					return;
				}
			}
		});
		add(decide);

		setPicture = makeButton("設定玩家照片");
		setPicture.setBounds(400, 220, 250, 60);
		setPicture.setFont(new Font("細明體", Font.PLAIN, 25));
		setPicture.addActionListener(this);
		add(setPicture);
	}

	public void createLabel() {
		setID = makeLabel("設定玩家ID");
		autoSave = makeLabel("自動存檔");
		boardWay = makeLabel("棋盤方向");
		setID.setFont(new Font("細明體", Font.PLAIN, 36));
		autoSave.setFont(new Font("細明體", Font.PLAIN, 36));
		boardWay.setFont(new Font("細明體", Font.PLAIN, 36));
		setID.setBounds(100, 350, 200, 100);
		autoSave.setBounds(100, 450, 200, 100);
		boardWay.setBounds(100, 550, 200, 100);
		add(setID);
		add(autoSave);
		add(boardWay);

		picLocation = makeLabel("");
		picLocation.setBounds(100, 150, 200, 200);
		if (img != null) {
			img.setImage(img.getImage().getScaledInstance(100, 150, Image.SCALE_DEFAULT));
			picLocation.setIcon(img);
		}
		add(picLocation);

	}

	public void createTextField() {
		text = new JTextField(18);
		text.setBounds(400, 380, 150, 40);
		text.setFont(new Font("細明體", Font.PLAIN, 25));
		text.setText(getUserName());
		add(text);
	}

	public JButton makeButton(String name) {
		return new JButton(name);
	}

	public JLabel makeLabel(String name) {
		return new JLabel(name);
	}

	public void btnFileAction() {
		FileDialog fd = new FileDialog(this, "選擇照片", FileDialog.LOAD);
		fd.setVisible(true);
		String file = fd.getFile();
		if (file == null)
			return;
		file = fd.getDirectory() + file;
		img = new ImageIcon(file);
		img.setImage(img.getImage().getScaledInstance(100, 150, Image.SCALE_DEFAULT));
		picLocation.setIcon(img);
		/*
		 * try { Runtime.getRuntime().exec( "cmd.exe /c start rundll32 url.dll,FileProtocolHandler " + file); } catch (IOException e) { e.printStackTrace(); }
		 */
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

		if (buttonName.equals("設定玩家照片")) {
			btnFileAction();
		}

	}

}
