package chessGame.frame;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JButton;

import chessGame.controlUnit.ChessGameRule;
import chessGame.controlUnit.Save;
import chessGame.data.ChessGameData;
import chessGame.data.SaveData;

public class ThirdView extends AbstractFrameModel {

	private String from;
	private JButton newGame;
	private JButton loadGame;
	private JButton back;

	ThirdView(boolean visable, ChessGameData data, ChessGameRule rule, String from, String now, int locationX, int locationY) {
		super(visable, data, rule);
		this.from = from;
		setTitle(now);
		createButton();
		setLocation(locationX, locationY);
	}

	public JButton makeButton(String name) {
		return new JButton(name);
	}

	public void createButton() {
		newGame = new JButton("開啟新局");
		loadGame = new JButton("讀取舊檔");
		back = new JButton("返回前頁");

		newGame.setBounds((this.getSize().width / 2) - 125, 150, 250, 100);
		loadGame.setBounds((this.getSize().width / 2) - 125, 300, 250, 100);
		back.setBounds(10, 10, 250, 100);

		newGame.setFont(new Font("細明體", Font.PLAIN, 36));
		loadGame.setFont(new Font("細明體", Font.PLAIN, 36));
		back.setFont(new Font("細明體", Font.PLAIN, 36));

		back.addActionListener(this);
		newGame.addActionListener(this);
		loadGame.addActionListener(this);

		add(newGame);
		add(loadGame);
		add(back);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String buttonName = e.getActionCommand();

		if (buttonName.equals("返回前頁")) {
			setVisible(false);
			dispose();
			new SecondView(true, data, rule, from, getLocation().x, getLocation().y);
		} else if (buttonName.equals("開啟新局")) {
			setVisible(false);
			dispose();
			if (from.equals("中國棋")) {
				new ChineseChessBoard(true, data, rule, null, getLocation().x, getLocation().y);
			} else if (from.equals("暗棋")) {
				new TaiwanChessBoard(true, data, rule, null, getLocation().x, getLocation().y);
			}
		} else if (buttonName.equals("讀取舊檔")) {
			FileDialog fileDialog = new FileDialog(this, "Load...", FileDialog.LOAD);
			fileDialog.setVisible(true);
			String file = fileDialog.getFile();
			file = fileDialog.getDirectory() + file;

			Save save = new Save();
			SaveData saveData = (SaveData) save.loadGame(file);
			System.out.println(saveData.toString());

			setVisible(false);
			dispose();
			if (from.equals("中國棋")) {
				new ChineseChessBoard(true, data, rule, saveData, getLocation().x, getLocation().y);
			} else if (from.equals("暗棋")) {
				new TaiwanChessBoard(true, data, rule, saveData, getLocation().x, getLocation().y);
			}
		}

	}

}
