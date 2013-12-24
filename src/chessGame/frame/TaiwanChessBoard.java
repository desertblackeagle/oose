package chessGame.frame;

import javax.swing.JButton;
import javax.swing.JPanel;

import chessGame.controlUnit.ChessGameRule;
import chessGame.data.ChessGameData;
import chessGame.data.SaveData;
import chessGame.frame.board.CrossTaiwanChessBoardFrame;
import chessGame.frame.board.InterfaceCrossChessBoardFrame;
import chessGame.frame.board.InterfaceStraightChessBoardFrame;
import chessGame.frame.board.StraightTaiwanChessBoardFrame;

public class TaiwanChessBoard extends AbstractChessBoardFactory {
//	private static TaiwanChessBoard board = null;

//	private JButton backMain;

	public TaiwanChessBoard(boolean visable, ChessGameData data, ChessGameRule rule, SaveData saveData, int x, int y) {
		// TODO Auto-generated constructor stub
		super(visable, data, rule, x, y);

		chessStatus.setWhichGame(taiwaneseChess);

		if (saveData != null) {
			chessTable.create(data);
			chessTable.loadAllTaiwanChessData(saveData.getArray());
			chessStatus.setWhichGame(saveData.getWhichGame());
			chessStatus.setWhichOrder(saveData.getWhichOrder());
			chessRecord.setRecordStack(saveData.getRecordStack());
			chessList.reloadChessList(chessTable.getChessList(chessStatus.getWhichGame()));
		} else {
			chessTable.create(data);
		}

		createBoard();
		getInfotArea().setText(chessRecord.recordToString());
	}

	@Override
	public void initBoard() {
		// TODO Auto-generated method stub

		for (Chess cv : chessTable.getTaiwanChessList()) {
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
		tmp = new Chess[4][8];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				tmp[i][j] = chessList.getChessList()[i][j];
			}
		}
		chessRecord.recordList(tmp, chessStatus.getWhichGame());
	}

	@Override
	public InterfaceStraightChessBoardFrame makeStraightChessBoard() {
		// TODO Auto-generated method stub
		setxMax(524);
		setxMin(-34);
		setyMax(244);
		setyMin(-34);
		return new StraightTaiwanChessBoardFrame(820, 890, "c:\\aa.jpg");
	}

	@Override
	public InterfaceCrossChessBoardFrame makeCrossChessBoard() {
		// TODO Auto-generated method stub
		setxMax(244);
		setxMin(-34);
		setyMax(524);
		setyMin(-34);
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
		for (Chess cv : chessTable.getTaiwanChessList()) {
			cv.removeMouseListener(this);
			cv.removeMouseMotionListener(this);
		}
	}

}
