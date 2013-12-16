package chessGame.frame;

import interfaceGame.chessGame.InterfaceCrossChessBoardFrame;
import interfaceGame.chessGame.InterfaceStraightChessBoardFrame;

import javax.swing.JButton;

import abstractGame.chessGame.AbstractChessBoardFactory;
import chessGame.data.ChessGameData;
import chessGame.data.chess.Chess;
import chessGame.frame.frameElement.chineseChess.CrossChineseChessBoardFrame;
import chessGame.frame.frameElement.chineseChess.StraightChineseChessBoardFrame;

public class ChineseChessBoard extends AbstractChessBoardFactory {

//	private JButton backMain;
//	private JPanel panel;

	public ChineseChessBoard(boolean visable, ChessGameData data, int x, int y) {
		super(visable, data, x, y);
		// TODO Auto-generated constructor stub
//		panel = new JPanel();
//		initBoard();
	}

	@Override
	public void initBoard() {
		// TODO Auto-generated method stub

		for (Chess cv : data.getChessTable().getChineseChessList()) {
			cv.addMouseListener(this);
			cv.addMouseMotionListener(this);
			add(cv);
		}

		if (data.getConfigData().isBoardStraight()) {
			StraightChineseChessBoardFrame board = new StraightChineseChessBoardFrame(620, 690, "c:\\aa.jpg");
			board.setBounds(0, 0, this.getWidth(), this.getHeight());
			add(board);
		} else {
			CrossChineseChessBoardFrame board = new CrossChineseChessBoardFrame(690, 620, "c:\\aa.jpg");
			board.setBounds(0, 0, this.getWidth(), this.getHeight());
			add(board);
		}

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

	public static void main(String[] args) {
		ChineseChessBoard c = new ChineseChessBoard(true, ChessGameData.instance(), 0, 0);
	}

}
