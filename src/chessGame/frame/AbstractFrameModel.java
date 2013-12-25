package chessGame.frame;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import observer.ChessObserver;
import observer.ChessObservable;
import chessGame.controlUnit.ChessGameRule;
import chessGame.controlUnit.ChessRule;
import chessGame.data.ChessGameData;
import chessGame.data.ChessList;
import chessGame.data.ChessRecord;
import chessGame.data.ChessStatus;
import chessGame.data.ConfigData;
import chessGame.data.LocationMap;
import chessGame.frame.dialog.FrameCheckDialog;

public abstract class AbstractFrameModel extends JFrame implements ActionListener {

	public static final int chineseChess = 1;
	public static final int taiwaneseChess = 0;
	private ChessObservable chessObs = new ChessObservable();

	boolean visable = true;
	public ChessGameData data;
	public ChessGameRule rule;

	public ChessRecord chessRecord;
	public ChessList chessList;
	public ChessStatus chessStatus;
	public LocationMap locationMap;
	public ChessRule chessRule;
	public ChessTable chessTable;
	public ConfigData configData;

	public AbstractFrameModel(boolean visable, ChessGameData data, ChessGameRule rule) {
		this.visable = visable;
		initFrame();
		initFrameEventListeners();
		this.data = data;
		this.rule = rule;

		chessRecord = data.getGameStatus().getChessRecord();
		chessStatus = data.getGameStatus().getChessStatus();
		chessList = data.getGameStatus().getChessList();
		locationMap = data.getLocMap();
		chessRule = rule.getChessRule();
		chessTable = data.getChessTable();
		configData = data.getConfigData();
	}

	public void initFrame() {
		setSize(1000, 739);
		setVisible(visable);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
	}

	public void initFrameEventListeners() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				FrameCheckDialog.instance();
			}
		});
	}

	public void addObserver(ChessObserver o) {
		chessObs.addObserver(o);
	}

	public void notifyAll(Object o1) {
		chessObs.notifyAll(this, o1);
	}

	public void notifyAll(Object o1, Object o2) {
		chessObs.notifyAll(this, o1, o2);
	}

	public abstract JButton makeButton(String text);

}
