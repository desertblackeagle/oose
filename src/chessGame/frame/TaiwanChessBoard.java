package chessGame.frame;

import interfaceGame.chessGame.InterfaceCrossChessBoardFrame;
import interfaceGame.chessGame.InterfaceStraightChessBoardFrame;

import javax.swing.JButton;
import javax.swing.JPanel;

import abstractGame.chessGame.AbstractChessBoardFactory;
import chessGame.controlUnit.ChessGameRule;
import chessGame.data.ChessGameData;
import chessGame.data.chess.Chess;
import chessGame.frame.frameElement.taiwanChess.CrossTaiwanChessBoardFrame;
import chessGame.frame.frameElement.taiwanChess.StraightTaiwanChessBoardFrame;

public class TaiwanChessBoard extends AbstractChessBoardFactory {
//	private static TaiwanChessBoard board = null;

//	private JButton backMain;

	public TaiwanChessBoard(boolean visable, ChessGameData data, ChessGameRule rule, int x, int y) {
		super(visable, data, rule, x, y);
		// TODO Auto-generated constructor stub
		data.getGameStatus().getChessStatus().setWhichGame(0);
		data.getChessTable().create(data);
		data.getGameStatus().getChessList().print();
		initBoard();
	}

//	public static void instance(boolean visable, ChessGameData data, int x, int y) {
//		if (board == null) {
//			board = new TaiwanChessBoard(visable, data, x, y);
//		} else {
//			System.out.println("4648646886868684884646884648648664864846");
//			System.out.println("Ta dir " + data.getConfigData().isBoardStraight());
//			board.setVisible(visable);
//			data.getGameStatus().getChessStatus().setWhichGame(0);
//			data.getChessTable().create(data);
//		}
//	}

	@Override
	public void initBoard() {
		// TODO Auto-generated method stub

		for (Chess cv : data.getChessTable().getTaiwanChessList()) {
			cv.addMouseListener(this);
			cv.addMouseMotionListener(this);
			add(cv);
		}

		if (data.getConfigData().isBoardStraight()) {
			StraightTaiwanChessBoardFrame board = (StraightTaiwanChessBoardFrame) makeStraightChessBoard();
			board.setBounds(0, 0, this.getWidth(), this.getHeight());
			add(board);
		} else {
			CrossTaiwanChessBoardFrame board = (CrossTaiwanChessBoardFrame) makeCrossChessBoard();
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
		setxMax(524);
		setxMin(-34);
		setyMax(244);
		setyMin(-34);
//		return new StraightTaiwanChessBoardFrame(620, 690, "c:\\aa.jpg");
		return new StraightTaiwanChessBoardFrame(820, 890, "c:\\aa.jpg");
	}

	@Override
	public InterfaceCrossChessBoardFrame makeCrossChessBoard() {
		// TODO Auto-generated method stub
		setxMax(244);
		setxMin(-34);
		setyMax(524);
		setyMin(-34);
//		return new CrossTaiwanChessBoardFrame(690, 620, "c:\\aa.jpg");
		return new CrossTaiwanChessBoardFrame(890, 820, "c:\\aa.jpg");
	}

	@Override
	public JButton makeButton(String text) {
		// TODO Auto-generated method stub
		return new JButton(text);
	}

	@Override
	public void removeChessListener() {
		// TODO Auto-generated method stub
		System.out.println("remove listener");
		for (Chess cv : data.getChessTable().getTaiwanChessList()) {
			cv.removeMouseListener(this);
			cv.removeMouseMotionListener(this);
		}
	}

//	public static void main(String[] args) {
//		TaiwanChessBoard c = new TaiwanChessBoard(true, ChessGameData.instance(), 0, 0);
//	}
}
