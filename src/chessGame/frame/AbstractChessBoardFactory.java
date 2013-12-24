package chessGame.frame;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import chessGame.controlUnit.ChessGameRule;
import chessGame.controlUnit.Save;
import chessGame.data.ChessGameData;
import chessGame.data.LocationPoint;
import chessGame.data.SaveData;
import chessGame.frame.board.InterfaceCrossChessBoardFrame;
import chessGame.frame.board.InterfaceStraightChessBoardFrame;
import chessGame.frame.chess.ChessView;

public abstract class AbstractChessBoardFactory extends AbstractFrameModel implements MouseListener, MouseMotionListener {
	private JButton backMain;
	private JButton surrend;
	private JButton save;
	private JButton saveChessPath;
	private JPanel infoPanel;
	private JLabel picLocationP1;
	private JLabel picLocationP2;
	private JLabel nameP1;
	private JLabel nameP2;
	private JLabel whichOrder;
	private TextArea infotArea;
	private int xMax, xMin;
	private int yMax, yMin;
	private int surrendP1Cnt = 0;
	private int surrendP2Cnt = 0;
	private ChessGameRule rule;
	private ArrayList<AcceptView> acceptList = new ArrayList<AcceptView>();

	int infoLocX = getLocation().x + (getWidth() / 2) - 200;
	int infoLocY = getLocation().y + (getHeight() / 2) - 100;

	public AbstractChessBoardFactory(boolean visable, ChessGameData data, ChessGameRule rule, int x, int y) {
		super(visable, data, rule);
		// TODO Auto-generated constructor stub

		setLocation(x, y);
		this.rule = rule;

		infoPanel = new JPanel();
		infotArea = new TextArea();

		infotArea.setBounds(0, 590, 310, 110);

		backMain = makeButton("返回主畫面");
		backMain.addActionListener(this);
		backMain.setBounds(0, 530, 100, 50);

		surrend = makeButton("投降");
		surrend.addActionListener(this);
		surrend.setBounds(0, 470, 100, 50);

		save = makeButton("存檔");
		save.addActionListener(this);
		save.setBounds(0, 410, 100, 50);

		saveChessPath = makeButton("匯出棋譜");
		saveChessPath.addActionListener(this);
		saveChessPath.setBounds(0, 350, 100, 50);

		picLocationP1 = new JLabel(data.getConfigData().getImgP1());
		picLocationP2 = new JLabel(data.getConfigData().getImgP2());
		picLocationP1.setBounds(0, 0, 100, 100);
		picLocationP2.setBounds(110, 0, 100, 100);

		nameP1 = new JLabel();
		nameP1.setFont(new Font(data.getConfigData().getPlayerNameP1(), Font.PLAIN, 25));
		nameP1.setText(data.getConfigData().getPlayerNameP1());
		nameP2 = new JLabel();
		nameP2.setFont(new Font(data.getConfigData().getPlayerNameP2(), Font.PLAIN, 25));
		nameP2.setText(data.getConfigData().getPlayerNameP2());
		nameP1.setBounds(0, 90, 100, 50);
		nameP2.setBounds(110, 90, 100, 50);

		whichOrder = new JLabel();
		whichOrder.setFont(new Font("輪到紅色", Font.PLAIN, 20));
		whichOrder.setText("輪到紅色");
		whichOrder.setBounds(0, 105, 100, 100);

		infoPanel.setLayout(null);
		infoPanel.setBounds(690, 0, 310, 739);

		infoPanel.add(saveChessPath);
		infoPanel.add(whichOrder);
		infoPanel.add(save);
		infoPanel.add(nameP1);
		infoPanel.add(nameP2);
		infoPanel.add(picLocationP1);
		infoPanel.add(picLocationP2);
		infoPanel.add(surrend);
		infoPanel.add(infotArea);
		infoPanel.add(backMain);
		add(infoPanel);

	}

	public void createBoard() {
		initBoard();
		chessRelocation();
	}

	public abstract void removeChessListener();

	public abstract void initBoard();

	public abstract InterfaceCrossChessBoardFrame makeCrossChessBoard();

	public abstract InterfaceStraightChessBoardFrame makeStraightChessBoard();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String buttonName = e.getActionCommand();

		if (buttonName.equals("返回主畫面")) {
			setVisible(false);
			dispose();

			chessRecord.printListRecord(chessStatus.getWhichGame());
			chessRecord.printRecord();
			chessList.clearList();
			chessStatus.clear();
			chessRecord.clear();

			locationMap.clearIndex();
			chessRule.clearCnt();

			new MainView(true, data, rule, this.getLocation().x, this.getLocation().y);
		} else if (buttonName.equals("投降")) {
			if (chessStatus.getWhichOrder() == taiwaneseChess) {
				removeChessListener();
				InfoFrame.instance("黑色贏了", infoLocX, infoLocY);
			} else {
				removeChessListener();
				InfoFrame.instance("紅色贏了", infoLocX, infoLocY);
			}
		} else if (buttonName.equals("存檔")) {

			FileDialog fileDialog = new FileDialog(this, "Save...", FileDialog.SAVE);
			fileDialog.setVisible(true);
			String file = fileDialog.getFile();
			file = fileDialog.getDirectory() + file;

			Save save = new Save();
			if (chessStatus.getWhichGame() == chineseChess) {
				SaveData saveData = new SaveData(chessStatus.getWhichGame(), chessStatus.getWhichOrder(), chessRecord.getRecordStack(), chessTable.getAllChineseChessData());
				save.saveGame(file, saveData);
			} else {
				SaveData saveData = new SaveData(chessStatus.getWhichGame(), chessStatus.getWhichOrder(), chessRecord.getRecordStack(), chessTable.getAllTaiwanChessData());
				save.saveGame(file, saveData);
			}

		} else if (buttonName.equals("悔棋")) {
			if (chessStatus.getWhichOrder() == taiwaneseChess) {
				if (surrendP1Cnt < 1) {
					if (chessRecord.takeOneChess() != null) {
						chessRecord.getRecordStack().pop();
						chessRecord.getRecordStack().pop();
						chessRecord.getListRecord().pop();

						chessTable.setAllChess(chessRecord.getListRecord().peek());

						chessList.setChessList(chessRecord.getListRecord().peek());
						System.out.println("aft peek");
						chessList.print();
						chessList.reloadChessLoc();
						System.out.println("regret");
						chessRelocation();
						surrendP1Cnt++;
						infotArea.setText(chessRecord.recordToString());
						chessList.print();
					} else {
						InfoFrame.instance("您沒有上一步棋", infoLocX, infoLocY);
					}
				} else {
					InfoFrame.instance("你的悔棋coda已經沒了", infoLocX, infoLocY);
				}
			} else {
				if (surrendP2Cnt < 1) {
					if (chessRecord.takeOneChess() != null) {
						chessRecord.getRecordStack().pop();
						chessRecord.getRecordStack().pop();

						chessRecord.getListRecord().pop();

						chessTable.setAllChess(chessRecord.getListRecord().peek());

						chessList.setChessList(chessRecord.getListRecord().peek());
						System.out.println("aft peek");
						chessList.print();
						chessList.reloadChessLoc();
						System.out.println("regret");
						chessRelocation();
						surrendP2Cnt++;
						infotArea.setText(chessRecord.recordToString());
						chessList.print();
					} else {
						InfoFrame.instance("您沒有上一步棋", infoLocX, infoLocY);
					}
				} else {
					InfoFrame.instance("你的悔棋coda已經沒了", infoLocX, infoLocY);
				}
			}
		} else if (buttonName.equals("匯出棋譜")) {
			FileDialog fileDialog = new FileDialog(this, "Save...", FileDialog.SAVE);
			fileDialog.setVisible(true);
			String file = fileDialog.getFile();
			file = fileDialog.getDirectory() + file;

			File files = new File(file);

			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(files));

				if (chessStatus.getWhichGame() == taiwaneseChess) {
					bw.write("暗棋棋譜\r\n");
				} else {
					bw.write("中國象棋棋譜\r\n");
				}

				for (String s : chessRecord.getRecordStack()) {
					bw.write(s + "\r\n");
				}
				bw.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void chessRelocationForAbs() {
		if (chessStatus.getWhichGame() == taiwaneseChess) {
			for (Chess c : chessTable.getTaiwanChessList()) {
				int locX = locationMap.getLocationMap()[c.getChessY()][c.getChessX()].getX();
				int locY = locationMap.getLocationMap()[c.getChessY()][c.getChessX()].getY();
				c.setLocation(locX, locY);
			}
		} else {
			for (Chess c : chessTable.getChineseChessList()) {
				int locX = locationMap.getLocationMap()[c.getChessY()][c.getChessX()].getX();
				int locY = locationMap.getLocationMap()[c.getChessY()][c.getChessX()].getY();
				c.setLocation(locX, locY);
			}
		}
	}

	public void chessRelocation() {
		if (chessStatus.getWhichGame() == taiwaneseChess) {
			for (Chess c : chessTable.getTaiwanChessList()) {
				if (!c.isChessDead()) {
					System.out.println(c.getName());
					c.setVisible(true);
					int locX = locationMap.getLocationMap()[c.getChessY()][c.getChessX()].getX();
					int locY = locationMap.getLocationMap()[c.getChessY()][c.getChessX()].getY();
					c.setLocation(locX, locY);
				} else {
					c.setVisible(false);
				}
			}
		} else {
			for (Chess c : chessTable.getChineseChessList()) {
				if (!c.isChessDead()) {
					c.setVisible(true);
					int locX = locationMap.getLocationMap()[c.getChessY()][c.getChessX()].getX();
					int locY = locationMap.getLocationMap()[c.getChessY()][c.getChessX()].getY();
					c.setLocation(locX, locY);
				} else {
					c.setVisible(false);
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		chessRule.taiwanChessOrder(((ChessView) e.getSource()), this);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (((ChessView) e.getSource()).isChessDead()) {
			return;
		}
		System.out.println("mousePressed start" + e.getX() + " " + e.getY());
		if (chessStatus.getWhichGame() == chineseChess) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 10; j++) {
					if (chessRule.moveToNoAction(((ChessView) e.getSource()), i, j)) {
						AcceptView av = new AcceptView();
						av.setLocation(locationMap.getLocationMap()[j][i].getX(), locationMap.getLocationMap()[j][i].getY());
						add(av);
						getContentPane().setComponentZOrder(av, 0);
						acceptList.add(av);
						this.repaint();
					}
				}
			}
		}
		this.repaint();

		System.out.println("mousePressed end" + e.getX() + " " + e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (((ChessView) e.getSource()).isChessDead()) {
			return;
		}
		for (AcceptView av : acceptList) {
			remove(av);
		}
		this.repaint();

		if (!((ChessView) e.getSource()).isChessCover()) {
			LocationPoint point = chessRule.findChessInBoardLoc(e, this);
			if (point != null) {
				chessRule.moveTo(((ChessView) e.getSource()), this, point.getX(), point.getY());
			}
		}
		if (((ChessView) e.getSource()).isChessCover()) {
			chessRule.swapUserOrder(((ChessView) e.getSource()), this);
			((ChessView) e.getSource()).setChessCover(false);
			((ChessView) e.getSource()).repaint();
		}
		System.out.println("mouseReleased : ");
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int locX = (e.getX() + ((ChessView) e.getSource()).getLocation().x - ((ChessView) e.getSource()).getWidth() / 2);
		int locY = (e.getY() + ((ChessView) e.getSource()).getLocation().y - ((ChessView) e.getSource()).getHeight() / 2);

		if (!((ChessView) e.getSource()).isChessDead()) {
			if (!((ChessView) e.getSource()).isChessCover()) {
				getContentPane().setComponentZOrder(((ChessView) e.getSource()), 0);
				((ChessView) e.getSource()).setLocation(locX, locY);
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void setInfotAreaText(String text) {
		infotArea.setText(text);
	}

	public JPanel getInfoPanel() {
		return infoPanel;
	}

	public int getxMax() {
		return xMax;
	}

	public void setxMax(int xMax) {
		this.xMax = xMax;
	}

	public int getxMin() {
		return xMin;
	}

	public void setxMin(int xMin) {
		this.xMin = xMin;
	}

	public int getyMax() {
		return yMax;
	}

	public void setyMax(int yMax) {
		this.yMax = yMax;
	}

	public int getyMin() {
		return yMin;
	}

	public void setyMin(int yMin) {
		this.yMin = yMin;
	}

	public JLabel getWhichOrder() {
		return whichOrder;
	}

	public TextArea getInfotArea() {
		return infotArea;
	}
}
