package abstractGame.chessGame;

import interfaceGame.chessGame.InterfaceCrossChessBoardFrame;
import interfaceGame.chessGame.InterfaceStraightChessBoardFrame;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import chessGame.controlUnit.ChessGameRule;
import chessGame.controlUnit.Save;
import chessGame.data.ChessGameData;
import chessGame.data.LocationPoint;
import chessGame.data.SaveData;
import chessGame.data.chess.AcceptView;
import chessGame.data.chess.Chess;
import chessGame.data.chess.ChessView;
import chessGame.frame.InfoFrame;
import chessGame.frame.frameOption.MainView;

public abstract class AbstractChessBoardFactory extends AbstractFrameModel implements MouseListener, MouseMotionListener {
	private JButton backMain;
	private JButton surrend;
	private JButton save;
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

	public AbstractChessBoardFactory(boolean visable, ChessGameData data, ChessGameRule rule, int x, int y) {
		super(visable, data, rule);
		// TODO Auto-generated constructor stub
		setLocation(x, y);
		this.rule = rule;
//		data.getGameStatus().getChessList();
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

//		initBoard();
	}

	public abstract void removeChessListener();

	public void setInfotAreaText(String text) {
//		infotArea.append(text + "\n");
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

	public abstract void initBoard();

	public abstract InterfaceCrossChessBoardFrame makeCrossChessBoard();

	public abstract InterfaceStraightChessBoardFrame makeStraightChessBoard();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String buttonName = e.getActionCommand();
		int infoLocX = getLocation().x + (getWidth() / 2) - 200;
		int infoLocY = getLocation().y + (getHeight() / 2) - 100;
		if (buttonName.equals("返回主畫面")) {
			setVisible(false);
//			data.getChessTable().clearTable();
			dispose();

			data.getGameStatus().getChessRecord().printListRecord(data.getGameStatus().getChessStatus().getWhichGame());
			data.getGameStatus().getChessRecord().printRecord();
			data.getGameStatus().getChessList().clearList();
			data.getGameStatus().getChessStatus().clear();
			data.getGameStatus().getChessRecord().clear();
			new MainView(true, data, rule, this.getLocation().x, this.getLocation().y);
		} else if (buttonName.equals("投降")) {
			if (data.getGameStatus().getChessStatus().getWhichOrder() == 0) {
				removeChessListener();
				new InfoFrame("黑色贏了", infoLocX, infoLocY);
			} else {
				removeChessListener();
				new InfoFrame("紅色贏了", infoLocX, infoLocY);
			}
		} else if (buttonName.equals("存檔")) {
			FileDialog fileDialog = new FileDialog(this, "Save...", FileDialog.SAVE);
			fileDialog.setVisible(true);
			String file = fileDialog.getFile();
			file = fileDialog.getDirectory() + file;
			System.out.println(file);

			File files = new File(file);
			SaveData saveData = new SaveData(data.getGameStatus().getChessStatus().getWhichGame(), data.getGameStatus().getChessStatus().getWhichOrder(), data.getGameStatus().getChessRecord().getRecordStack(), data.getGameStatus().getChessRecord().getListRecord());
//			Data ddd = new Data(data.getGameStatus().getChessStatus().getWhichGame(), data.getGameStatus().getChessStatus().getWhichOrder(), data.getGameStatus().getChessRecord().getRecordStack(), data.getGameStatus().getChessRecord().getListRecord());
			Save save = new Save();

		} else if (buttonName.equals("悔棋")) {
			if (data.getGameStatus().getChessStatus().getWhichOrder() == 0) {
				if (surrendP1Cnt < 1) {
					surrendP1Cnt++;
					if (data.getGameStatus().getChessRecord().takeOneChess() != null) {
						data.getGameStatus().getChessRecord().getRecordStack().pop();
						data.getGameStatus().getChessRecord().getRecordStack().pop();
						data.getGameStatus().getChessRecord().getListRecord().pop();
						data.getGameStatus().getChessList().setChessList(data.getGameStatus().getChessRecord().getListRecord().peek());
						data.getGameStatus().getChessList().reloadChessLoc();
						chessRelocation();
						infotArea.setText(data.getGameStatus().getChessRecord().recordToString());
					} else {
						new InfoFrame("您沒有上一步棋", infoLocX, infoLocY);
					}
				} else {
					new InfoFrame("你的悔棋coda已經沒了", infoLocX, infoLocY);
				}
			} else {
				if (surrendP2Cnt < 1) {
					surrendP2Cnt++;
					if (data.getGameStatus().getChessRecord().takeOneChess() != null) {
						data.getGameStatus().getChessRecord().getRecordStack().pop();
						data.getGameStatus().getChessRecord().getRecordStack().pop();

						data.getGameStatus().getChessRecord().getListRecord().pop();
						data.getGameStatus().getChessList().setChessList(data.getGameStatus().getChessRecord().getListRecord().peek());
						data.getGameStatus().getChessList().reloadChessLoc();
						chessRelocation();
						infotArea.setText(data.getGameStatus().getChessRecord().recordToString());
					} else {
						new InfoFrame("您沒有上一步棋", infoLocX, infoLocY);
					}
				} else {
					new InfoFrame("你的悔棋coda已經沒了", infoLocX, infoLocY);
				}
			}

		}
	}

	public void chessRelocation() {
		if (data.getGameStatus().getChessStatus().getWhichGame() == 0) {
			for (Chess c : data.getChessTable().getTaiwanChessList()) {
				int locX = data.getLocMap().getLocationMap()[c.getChessY()][c.getChessX()].getX();
				int locY = data.getLocMap().getLocationMap()[c.getChessY()][c.getChessX()].getY();
				c.setLocation(locX, locY);
			}
		} else {
			for (Chess c : data.getChessTable().getChineseChessList()) {
				int locX = data.getLocMap().getLocationMap()[c.getChessY()][c.getChessX()].getX();
				int locY = data.getLocMap().getLocationMap()[c.getChessY()][c.getChessX()].getY();
				c.setLocation(locX, locY);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("mouseClicked : " + e.getX() + " " + e.getY());
//		rule.getChessRule().taiwanChessOrder(((ChessView)e.getSource()), this);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("mouseExited");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mousePressed start" + e.getX() + " " + e.getY());
		if (data.getGameStatus().getChessStatus().getWhichGame() == 1) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 10; j++) {
					if (rule.getChessRule().moveToNoAction(((ChessView) e.getSource()), i, j)) {
						AcceptView cv = new AcceptView();
						cv.setLocation(data.getLocMap().getLocationMap()[j][i].getX(), data.getLocMap().getLocationMap()[j][i].getY());
						add(cv);
						getContentPane().setComponentZOrder(cv, 0);
						acceptList.add(cv);
						this.repaint();
						System.out.println(i + " : " + j);
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
		for (AcceptView cv : acceptList) {
			remove(cv);
		}
		this.repaint();

		if (!((ChessView) e.getSource()).isChessCover()) {
			LocationPoint point = rule.getChessRule().findChessInBoardLoc(e, this);
			if (point != null) {
				rule.getChessRule().moveTo(((ChessView) e.getSource()), this, point.getX(), point.getY());
				data.getGameStatus().getChessList().print();

//			if (rule.getChessRule().moveTo(((ChessView) e.getSource()), point.getX(), point.getY())) {
//				System.out.println("can move ----------");
//			} else {
//				System.out.println("can NOT move ----------");
//			}
//			if (rule.getChessRule().canEat(((ChessView) e.getSource()), point.getX(), point.getY())) {
//				System.out.println("eat ----------");
//			}else{
//				System.out.println("can't eat ----------");
//			}
			}
		}
		if (((ChessView) e.getSource()).isChessCover()) {
			rule.getChessRule().swapUserOrder(((ChessView) e.getSource()), this);
			((ChessView) e.getSource()).setChessCover(false);
			((ChessView) e.getSource()).repaint();
		}
//		int locX = e.getXOnScreen() - 3 - getLocationOnScreen().x;
//		int locY = e.getYOnScreen() - 25 - getLocationOnScreen().y;
		System.out.println("mouseReleased : ");
//		System.out.println("mouseReleased : " + (e.getXOnScreen() - getLocationOnScreen().x) + " " + (e.getYOnScreen() - getLocationOnScreen().y) + " : " + locX + " " + locY);
////		System.out.println("Max Min " + xMax + " : " + yMax);
//		if (locX > xMax || locX < xMin || locY > yMax || locY < yMin) {
//			System.out.println("超出範圍");
//			System.out.println(((ChessView) e.getSource()).getChessY() + " : " + ((ChessView) e.getSource()).getChessX());
//			((ChessView) e.getSource()).setLocation(data.getLocMap().getLocationMap()[((ChessView) e.getSource()).getChessY()][((ChessView) e.getSource()).getChessX()].getX(), data.getLocMap().getLocationMap()[((ChessView) e.getSource()).getChessY()][((ChessView) e.getSource()).getChessX()].getY());
//			return;
//		}
//		locX -= 30;
//		locY -= 30;
//		System.out.println("inLoc" + locX + " : " + locY);
//		if ((locX % 70) <= 35 && (locY % 70) <= 35) {
//			System.out.println(locX / 70 + " " + locY / 70);
////			setBtnLoc(whichGame, e, locX, y, 0, 0);
////			((BChessVis) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70][x / 70].getX(), locationMap.getTaiwaneseLocationMap()[y / 70][x / 70].getY());
////			manager.moveTo(((ButtonChess) e.getSource()), (x / 70), (y / 70), buttonArrayList, this);
//		} else if ((locX % 70) > 35 && (locY % 70) > 35) {
//			System.out.println((locX / 70 + 1) + " " + (locY / 70 + 1));
////			setBtnLoc(whichGame, e, x, y, 1, 1);
////			((BChessVis) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70 + 1][x / 70 + 1].getX(), locationMap.getTaiwaneseLocationMap()[y / 70 + 1][x / 70 + 1].getY());
////			manager.moveTo(((ButtonChess) e.getSource()), (x / 70 + 1), (y / 70 + 1), buttonArrayList, this);
//		} else if ((locX % 70) > 35 && (locY % 70) < 35) {
//			System.out.println((locX / 70 + 1) + " " + locY / 70);
////			setBtnLoc(whichGame, e, x, y, 1, 0);
////			((BChessVis) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70][x / 70 + 1].getX(), locationMap.getTaiwaneseLocationMap()[y / 70][x / 70 + 1].getY());
////			manager.moveTo(((ButtonChess) e.getSource()), (x / 70 + 1), (y / 70), buttonArrayList, this);
//		} else if ((locX % 70) < 35 && (locY % 70) > 35) {
//			System.out.println(locX / 70 + " " + (locY / 70 + 1));
////			setBtnLoc(whichGame, e, x, y, 0, 1);
////			((BChessVis) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70 + 1][x / 70].getX(), locationMap.getTaiwaneseLocationMap()[y / 70 + 1][x / 70].getY());
////			manager.moveTo(((ButtonChess) e.getSource()), (x / 70), (y / 70 + 1), buttonArrayList, this);
//		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int locX = (e.getX() + ((ChessView) e.getSource()).getLocation().x - ((ChessView) e.getSource()).getWidth() / 2);
		int locY = (e.getY() + ((ChessView) e.getSource()).getLocation().y - ((ChessView) e.getSource()).getHeight() / 2);
		int ax = e.getXOnScreen() - 3 - getLocationOnScreen().x;
		int ay = e.getYOnScreen() - 25 - getLocationOnScreen().y;
//		System.out.println(ax + " :loc: " + ay);
//		if (locX < 750 && locX > -10 && locY > -10 && locY < 660) {
		if (!((ChessView) e.getSource()).isChessCover()) {
			getContentPane().setComponentZOrder(((ChessView) e.getSource()), 0);
			((ChessView) e.getSource()).setLocation(locX, locY);
		}
//		else {
//			rule.getChessRule().swapUserOrder(((ChessView) e.getSource()));
//			((ChessView) e.getSource()).setChessCover(false);
//			((ChessView) e.getSource()).repaint();
//		}
//		}
		System.out.println("mouseDragged");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("mouseMoved");
	}

}
