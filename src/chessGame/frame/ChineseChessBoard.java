package chessGame.frame;

import interfaceGame.chessGame.InterfaceCrossChessBoardFrame;
import interfaceGame.chessGame.InterfaceStraightChessBoardFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import abstractGame.chessGame.AbstractChessBoardFactory;
import chessGame.data.ChessGameData;
import chessGame.frame.frameElement.chineseChess.CrossChineseChessBoardFrame;
import chessGame.frame.frameElement.chineseChess.StraightChineseChessBoardFrame;
import chessGame.frame.frameOption.MainView;

public class ChineseChessBoard extends AbstractChessBoardFactory {

	private JButton backMain;
	private JPanel panel;

	public ChineseChessBoard(boolean visable, ChessGameData data, int x, int y) {
		super(visable, data, x, y);
		// TODO Auto-generated constructor stub
//		panel = new JPanel();
//		initBoard();
	}

	@Override
	public void initBoard() {
		// TODO Auto-generated method stub
		if (data.getConfigData().isBoardStraight()) {
			StraightChineseChessBoardFrame board = new StraightChineseChessBoardFrame(620, 690, "c:\\aa.jpg");
			board.setBounds(0, 0, this.getWidth(), this.getHeight());
			add(board);
		} else {
			CrossChineseChessBoardFrame board = new CrossChineseChessBoardFrame(690, 620, "c:\\aa.jpg");
			board.setBounds(0, 0, this.getWidth(), this.getHeight());
			add(board);
		}

//		backMain = makeButton("返回主畫面");
//		backMain.addActionListener(this);
//		backMain.setBounds(50, 500, 100, 50);
////		add(backMain);
//		
//		
//		panel.setLayout(null);
//		panel.setBounds(700, 0, 300, 739);
//		add(panel);
//		panel.add(backMain);
		
	}

	@Override
	public InterfaceStraightChessBoardFrame makeStraightChessBoard() {
		// TODO Auto-generated method stub
		return new StraightChineseChessBoardFrame(620, 690, "c:\\aa.jpg");
	}

	@Override
	public InterfaceCrossChessBoardFrame makeCrossChessBoard() {
		// TODO Auto-generated method stub
		return new CrossChineseChessBoardFrame(620, 690, "c:\\aa.jpg");
	}

	@Override
	public JButton makeButton(String text) {
		// TODO Auto-generated method stub
		return new JButton(text);
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		String buttonName = e.getActionCommand();
//
//		if (buttonName.equals("返回主畫面")) {
//			setVisible(false);
//			dispose();
//			new MainView(true, this.getLocation().x, this.getLocation().y, data);
//		}
//	}

	public static void main(String[] args) {
		ChineseChessBoard c = new ChineseChessBoard(true, ChessGameData.instance(), 0, 0);
	}
}
