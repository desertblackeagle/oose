package chessGame.frame.frameOption;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import abstractGame.chessGame.AbstractFrameModel;
import chessGame.data.ChessGameData;
import chessGame.frame.ChineseChessBoard;
import chessGame.frame.TaiwanChessBoard;

public class ThirdView extends AbstractFrameModel {

	static final int chineseChess = 1;
	static final int taiwaneseChess = 0;

	private String from;
	private JButton newGame;
	private JButton loadGame;
	private JButton deleteGame;
	private JButton back;

	ThirdView(boolean visable, ChessGameData data, String from, String now, int locationX, int locationY) {
		super(visable, data);
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
		deleteGame = new JButton("刪除存檔");
		back = new JButton("返回前頁");

		newGame.setBounds((this.getSize().width / 2) - 125, 150, 250, 100);
		loadGame.setBounds((this.getSize().width / 2) - 125, 300, 250, 100);
		deleteGame.setBounds((this.getSize().width / 2) - 125, 450, 250, 100);
		back.setBounds(10, 10, 250, 100);

		newGame.setFont(new Font("細明體", Font.PLAIN, 36));
		loadGame.setFont(new Font("細明體", Font.PLAIN, 36));
		deleteGame.setFont(new Font("細明體", Font.PLAIN, 36));
		back.setFont(new Font("細明體", Font.PLAIN, 36));

		back.addActionListener(this);
		newGame.addActionListener(this);

		add(newGame);
		add(loadGame);
		add(deleteGame);
		add(back);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String buttonName = e.getActionCommand();

		if (buttonName.equals("返回前頁")) {
			setVisible(false);
			dispose();
			new SecondView(true, data, from, getLocation().x, getLocation().y);
		} else if (buttonName.equals("開啟新局")) {
			setVisible(false);
			dispose();

			if (from.equals("中國棋")) {
//				new CChineseChessBoard(true, data, getLocation().x, getLocation().y);
				new ChineseChessBoard(true, data, getLocation().x, getLocation().y);
//				BoardManager manager = new BoardManager(chineseChess);
//				ChessTable chessTable = new ChessTable(manager);
//				ButtonChessArrayList buttonArrayList = new ButtonChessArrayList(manager, chessTable);
//				new ChineseGameFrame(manager, buttonArrayList, from, getLocation().x, getLocation().y);
			} else if (from.equals("暗棋")) {
//				new TTaiwanChessBoard(true, data, getLocation().x, getLocation().y);
				new TaiwanChessBoard(true, data, getLocation().x, getLocation().y);
//				BoardManager manager = new BoardManager(taiwaneseChess);
//				ChessTable chessTable = new ChessTable(manager);
//				ButtonChessArrayList buttonArrayList = new ButtonChessArrayList(manager, chessTable);
//				new TaiwanGameFrame(manager, buttonArrayList, from, getLocation().x, getLocation().y);
			}
		}

	}

}
