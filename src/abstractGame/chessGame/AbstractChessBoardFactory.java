package abstractGame.chessGame;

import interfaceGame.chessGame.InterfaceCrossChessBoardFrame;
import interfaceGame.chessGame.InterfaceStraightChessBoardFrame;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import chessGame.controlUnit.ChessGameRule;
import chessGame.data.ChessGameData;
import chessGame.data.LocationPoint;
import chessGame.data.chess.AcceptView;
import chessGame.data.chess.ChessView;
import chessGame.frame.frameOption.MainView;

public abstract class AbstractChessBoardFactory extends AbstractFrameModel implements MouseListener, MouseMotionListener {
	private JButton backMain;
	private JPanel infoPanel;
	private TextArea infotArea;
	private int xMax, xMin;
	private int yMax, yMin;
	private ChessGameRule rule;
	private ArrayList<AcceptView> acceptList = new ArrayList<AcceptView>();

	public AbstractChessBoardFactory(boolean visable, ChessGameData data, ChessGameRule rule, int x, int y) {
		super(visable, data, rule);
		// TODO Auto-generated constructor stub
		setLocation(x, y);
		this.rule = rule;

		infoPanel = new JPanel();
		infotArea = new TextArea();

		infotArea.setBounds(0, 590, 318, 110);

		backMain = makeButton("返回主畫面");
		backMain.addActionListener(this);
		backMain.setBounds(0, 530, 100, 50);

		infoPanel.setLayout(null);
		infoPanel.setBounds(690, 0, 310, 739);

		add(infoPanel);
		infoPanel.add(infotArea);
		infoPanel.add(backMain);
//		initBoard();
	}

	public void setInfotAreaText(String text) {
		infotArea.append(text + "\n");
//		infotArea.setText(text);
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

	public abstract void initBoard();

	public abstract InterfaceCrossChessBoardFrame makeCrossChessBoard();

	public abstract InterfaceStraightChessBoardFrame makeStraightChessBoard();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String buttonName = e.getActionCommand();

		if (buttonName.equals("返回主畫面")) {
			setVisible(false);
//			data.getChessTable().clearTable();
			dispose();
			data.getGameStatus().getChessList().clearList();
			new MainView(true, data, rule, this.getLocation().x, this.getLocation().y);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("mouseClicked : " + e.getX() + " " + e.getY());
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
						getContentPane().setComponentZOrder(cv, 1);
						acceptList.add(cv);
						this.repaint();
						System.out.println(i + " : " + j);
					}
				}
			}
		}
		System.out.println("mousePressed end" + e.getX() + " " + e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

		for (AcceptView cv : acceptList) {
			remove(cv);
		}
		this.repaint();
		if (((ChessView) e.getSource()).isChessCover()) {
			rule.getChessRule().swapUserOrder(((ChessView) e.getSource()));
			((ChessView) e.getSource()).setChessCover(false);
			((ChessView) e.getSource()).repaint();
		}
		LocationPoint point = rule.getChessRule().findChessInBoardLoc(e, this);
		if (point != null) {
			rule.getChessRule().moveTo(((ChessView) e.getSource()), this, point.getX(), point.getY());
			data.getGameStatus().getChessList().print(1);
			
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

//		int locX = e.getXOnScreen() - 3 - getLocationOnScreen().x;
//		int locY = e.getYOnScreen() - 25 - getLocationOnScreen().y;
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
//		System.out.println("mouseDragged");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("mouseMoved");
	}

}
