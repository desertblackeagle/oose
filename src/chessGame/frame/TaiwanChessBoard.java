package chessGame.frame;

import interfaceGame.chessGame.InterfaceCrossChessBoardFrame;
import interfaceGame.chessGame.InterfaceStraightChessBoardFrame;

import javax.swing.JButton;

import abstractGame.chessGame.AbstractChessBoardFactory;
import chessGame.data.ChessGameData;
import chessGame.data.chess.Chess;
import chessGame.frame.frameElement.taiwanChess.CrossTaiwanChessBoardFrame;
import chessGame.frame.frameElement.taiwanChess.StraightTaiwanChessBoardFrame;

public class TaiwanChessBoard extends AbstractChessBoardFactory {

//	private JButton backMain;

	public TaiwanChessBoard(boolean visable, ChessGameData data, int x, int y) {
		super(visable, data, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initBoard() {
		// TODO Auto-generated method stub

		for (Chess cv : data.getChessTable().getTaiwanChessList()) {
			cv.addMouseListener(this);
			cv.addMouseMotionListener(this);
			add(cv);
		}

		if (data.getConfigData().isBoardStraight()) {
			StraightTaiwanChessBoardFrame board = new StraightTaiwanChessBoardFrame(620, 690, "c:\\aa.jpg");
			board.setBounds(0, 0, this.getWidth(), this.getHeight());
			add(board);
		} else {
			CrossTaiwanChessBoardFrame board = new CrossTaiwanChessBoardFrame(690, 620, "c:\\aa.jpg");
			board.setBounds(0, 0, this.getWidth(), this.getHeight());
			add(board);
		}
	}

	@Override
	public InterfaceStraightChessBoardFrame makeStraightChessBoard() {
		// TODO Auto-generated method stub
		return new StraightTaiwanChessBoardFrame(620, 690, "c:\\aa.jpg");
	}

	@Override
	public InterfaceCrossChessBoardFrame makeCrossChessBoard() {
		// TODO Auto-generated method stub
		return new CrossTaiwanChessBoardFrame(620, 690, "c:\\aa.jpg");
	}

	@Override
	public JButton makeButton(String text) {
		// TODO Auto-generated method stub
		return new JButton(text);
	}

	public static void main(String[] args) {
		TaiwanChessBoard c = new TaiwanChessBoard(true, ChessGameData.instance(), 0, 0);
	}
}
