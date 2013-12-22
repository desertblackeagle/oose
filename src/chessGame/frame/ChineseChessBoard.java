package chessGame.frame;

import interfaceGame.chessGame.InterfaceCrossChessBoardFrame;
import interfaceGame.chessGame.InterfaceStraightChessBoardFrame;

import javax.swing.JButton;
import javax.swing.JPanel;

import abstractGame.chessGame.AbstractChessBoardFactory;
import chessGame.controlUnit.ChessGameRule;
import chessGame.data.ChessGameData;
import chessGame.data.chess.Chess;
import chessGame.frame.frameElement.chineseChess.CrossChineseChessBoardFrame;
import chessGame.frame.frameElement.chineseChess.StraightChineseChessBoardFrame;

public class ChineseChessBoard extends AbstractChessBoardFactory {
//	private static ChineseChessBoard board = null;
	private JButton regret;

//	private JButton backMain;
//	private JPanel panel;

	public ChineseChessBoard(boolean visable, ChessGameData data, ChessGameRule rule, int x, int y) {
		super(visable, data, rule, x, y);
		data.getGameStatus().getChessStatus().setWhichGame(1);
		System.out.println("which : " + data.getGameStatus().getChessStatus().getWhichGame());
		data.getChessTable().create(data);
		data.getGameStatus().getChessList().print();
		// TODO Auto-generated constructor stub
//		panel = new JPanel();
		initBoard();

	}

//	public static void instance(boolean visable, ChessGameData data, int x, int y) {
//		if (board == null) {
//			board = new ChineseChessBoard(visable, data, x, y);
//		} else {
//			System.out.println("4648646886868684884646884648648664864846");
//			System.out.println("CH dir " + data.getConfigData().isBoardStraight());
//			board.setVisibleS(visable);
//			data.getGameStatus().getChessStatus().setWhichGame(1);
//			data.getChessTable().create(data);
//		}
//	}

	@Override
	public void initBoard() {
		// TODO Auto-generated method stub
		regret = makeButton("悔棋");
		regret.addActionListener(this);
		regret.setBounds(0, 350, 100, 50);
		getInfoPanel().add(regret);
		System.out.println("create table");
		for (Chess cv : data.getChessTable().getChineseChessList()) {
			cv.addMouseListener(this);
			cv.addMouseMotionListener(this);
			add(cv);
//			System.out.println("add9486849484894984994848948498");
		}

		if (data.getConfigData().isBoardStraight()) {
//			StraightChineseChessBoardFrame board = new StraightChineseChessBoardFrame(620, 690, "c:\\aa.jpg");
			StraightChineseChessBoardFrame board = (StraightChineseChessBoardFrame) makeStraightChessBoard();
			board.setBounds(0, 0, this.getWidth(), this.getHeight());
			add(board);
		} else {
//			CrossChineseChessBoardFrame board = new CrossChineseChessBoardFrame(690, 620, "c:\\aa.jpg");
			CrossChineseChessBoardFrame board = (CrossChineseChessBoardFrame) makeCrossChessBoard();
			board.setBounds(0, 0, this.getWidth(), this.getHeight());
			add(board);
		}

		JPanel bottom = new JPanel();
		bottom.setBounds(0, 0, 1000, 1000);
		add(bottom);

		Chess[][] tmp;
		if (data.getGameStatus().getChessStatus().getWhichGame() == 1) {
			tmp = new Chess[10][9];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 9; j++) {
					tmp[i][j] = data.getGameStatus().getChessList().getChessList()[i][j];
				}
			}
		} else {
			tmp = new Chess[4][8];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					tmp[i][j] = data.getGameStatus().getChessList().getChessList()[i][j];
				}
			}
		}
		data.getGameStatus().getChessRecord().recordList(tmp, data.getGameStatus().getChessStatus().getWhichGame());
	}

	@Override
	public InterfaceStraightChessBoardFrame makeStraightChessBoard() {
		// TODO Auto-generated method stub
		setxMax(594);
		setxMin(-34);
		setyMax(664);
		setyMin(-34);
//		return new StraightChineseChessBoardFrame(620, 690, "c:\\aa.jpg");
		return new StraightChineseChessBoardFrame(820, 890, "c:\\aa.jpg");
	}

	@Override
	public InterfaceCrossChessBoardFrame makeCrossChessBoard() {
		// TODO Auto-generated method stub
		setxMax(664);
		setxMin(-34);
		setyMax(594);
		setyMin(-34);
//		return new CrossChineseChessBoardFrame(690, 620, "c:\\aa.jpg");
		return new CrossChineseChessBoardFrame(890, 820, "c:\\aa.jpg");
	}

	@Override
	public JButton makeButton(String text) {
		// TODO Auto-generated method stub
		return new JButton(text);
	}

//	public static void main(String[] args) {
//		
//		ChineseChessBoard c = new ChineseChessBoard(true, ChessGameData.instance(), ChessGameRule.instance(ChessGameData.instance()), 0, 0);
//	}

	@Override
	public void removeChessListener() {
		// TODO Auto-generated method stub
		for (Chess cv : data.getChessTable().getChineseChessList()) {
			cv.removeMouseListener(this);
			cv.removeMouseMotionListener(this);
		}
	}
}
