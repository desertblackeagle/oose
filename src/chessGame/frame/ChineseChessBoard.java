package chessGame.frame;

import javax.swing.JButton;
import javax.swing.JPanel;

import chessGame.controlUnit.ChessGameRule;
import chessGame.data.ChessGameData;
import chessGame.data.SaveData;
import chessGame.frame.board.CrossChineseChessBoardFrame;
import chessGame.frame.board.InterfaceCrossChessBoardFrame;
import chessGame.frame.board.InterfaceStraightChessBoardFrame;
import chessGame.frame.board.StraightChineseChessBoardFrame;

public class ChineseChessBoard extends AbstractChessBoardFactory {

	private JButton regret;

	public ChineseChessBoard(boolean visable, ChessGameData data, ChessGameRule rule, SaveData saveData, int x, int y) {
		// TODO Auto-generated constructor stub
		super(visable, data, rule, x, y);

		chessStatus.setWhichGame(chineseChess);

		if (saveData != null) {
			chessTable.create(data);
			chessTable.loadAllChineseChessData(saveData.getArray());
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
		regret = makeButton("悔棋");
		regret.addActionListener(this);
		regret.setBounds(0, 290, 100, 50);
		getInfoPanel().add(regret);

		for (Chess cv : chessTable.getChineseChessList()) {
			cv.addMouseListener(this);
			cv.addMouseMotionListener(this);
			add(cv);
		}

		if (configData.isBoardStraight()) {
			StraightChineseChessBoardFrame board = (StraightChineseChessBoardFrame) makeStraightChessBoard();
			board.setBounds(0, 0, this.getWidth(), this.getHeight());
			add(board);
		} else {
			CrossChineseChessBoardFrame board = (CrossChineseChessBoardFrame) makeCrossChessBoard();
			board.setBounds(0, 0, this.getWidth(), this.getHeight());
			add(board);
		}

		JPanel bottom = new JPanel();
		bottom.setBounds(0, 0, 1000, 1000);
		add(bottom);

		Chess[][] tmp;
		tmp = new Chess[10][9];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				tmp[i][j] = chessList.getChessList()[i][j];
			}
		}
		chessRecord.recordList(tmp, chessStatus.getWhichGame());
	}

	@Override
	public InterfaceStraightChessBoardFrame makeStraightChessBoard() {
		// TODO Auto-generated method stub
		setxMax(594);
		setxMin(-34);
		setyMax(664);
		setyMin(-34);
		return new StraightChineseChessBoardFrame(820, 890, "c:\\aa.jpg");
	}

	@Override
	public InterfaceCrossChessBoardFrame makeCrossChessBoard() {
		// TODO Auto-generated method stub
		setxMax(664);
		setxMin(-34);
		setyMax(594);
		setyMin(-34);
		return new CrossChineseChessBoardFrame(890, 820, "c:\\aa.jpg");
	}

	@Override
	public JButton makeButton(String text) {
		// TODO Auto-generated method stub
		return new JButton(text);
	}

	@Override
	public void removeChessListener() {
		// TODO Auto-generated method stub
		for (Chess cv : chessTable.getChineseChessList()) {
			cv.removeMouseListener(this);
			cv.removeMouseMotionListener(this);
		}
	}
}
