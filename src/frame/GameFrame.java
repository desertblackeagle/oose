package frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import selectFrame.FrameModel;
import controlUnit.BoardManager;
import controlUnit.LocationMap;
import frameChess.ButtonChess;

public class GameFrame extends FrameModel implements MouseMotionListener, MouseListener {
	static final int chinessChess = 1;
	static final int taiwanChess = 0;

	JButton backMainView;
	int taiwanOrderCnt = 0;
	int whichGame = chinessChess;
	LocationMap locationMap = new LocationMap();
	BoardManager manager;
	ButtonChessArrayList buttonArrayList;
	JLabel picLocationP1;
	JLabel picLocationP2;
	JLabel userOrder;
	JLabel nameP1;
	JLabel nameP2;

	public void setBtnLoc(int whichGame, MouseEvent e, int x, int y, int xInc, int yInc) {
		if (whichGame == chinessChess) {
			((JButton) e.getSource()).setLocation(locationMap.getChineseLocationMap()[y / 70 + yInc][x / 70 + xInc].getX(), locationMap.getChineseLocationMap()[y / 70 + yInc][x / 70 + xInc].getY());
		} else {
			((JButton) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70 + yInc][x / 70 + xInc].getX(), locationMap.getTaiwaneseLocationMap()[y / 70 + yInc][x / 70 + xInc].getY());
		}
	}

	public JLabel getUserOrder() {
		return userOrder;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (!((ButtonChess) e.getSource()).getChess().isChessDead()) {
			if (!((ButtonChess) e.getSource()).getChess().isChessCover()) {
				int x = e.getX();
				int y = e.getY();
				((JButton) e.getSource()).setLocation(((JButton) e.getSource()).getLocation().x + x - (((JButton) e.getSource()).getWidth() / 2), ((JButton) e.getSource()).getLocation().y + y - (((JButton) e.getSource()).getHeight() / 2));
				getContentPane().setComponentZOrder(((JButton) e.getSource()), 0);
			} else {
//			((ButtonChess) e.getSource()).getChess().setChessCover(false);
//			((ButtonChess) e.getSource()).setText(((ButtonChess) e.getSource()).getChess().getChineseName());
			}
		} else {
			((JButton) e.getSource()).removeMouseListener(this);
			((JButton) e.getSource()).removeMouseMotionListener(this);
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		manager.taiwanChessOrder(((ButtonChess) e.getSource()), this);
		((ButtonChess) e.getSource()).getChess().setChessCover(false);
		((ButtonChess) e.getSource()).setText(((ButtonChess) e.getSource()).getChess().getChineseName());
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

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(whichGame);
		int x;
		int y;
		if (whichGame == chinessChess) {
			x = e.getXOnScreen() - 38 - getLocationOnScreen().x;
			y = e.getYOnScreen() - 60 - getLocationOnScreen().y;
			System.out.println(e.getX() + " , " + e.getY());
			System.out.println((e.getXOnScreen() - 38 - getLocationOnScreen().x) + " : " + (e.getYOnScreen() - 60 - getLocationOnScreen().y));
			if (x > 595 || y > 665 || x < -35 || y < -35) {
				System.out.println("超出範圍");
				((ButtonChess) e.getSource()).setLocation(locationMap.getChineseLocationMap()[((ButtonChess) e.getSource()).getChess().getY()][((ButtonChess) e.getSource()).getChess().getX()].getX(),
						locationMap.getChineseLocationMap()[((ButtonChess) e.getSource()).getChess().getY()][((ButtonChess) e.getSource()).getChess().getX()].getY());
				return;
			}
		} else {
			x = e.getXOnScreen() - 73 - getLocationOnScreen().x;
			y = e.getYOnScreen() - 95 - getLocationOnScreen().y;
			System.out.println((e.getXOnScreen() - 73) + " " + (e.getYOnScreen() - 95));
			System.out.println(x + " " + y);

			if (x > 525 || y > 245 || x < -35 || y < -35) {
				System.out.println("dark超出範圍");
				((ButtonChess) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[((ButtonChess) e.getSource()).getChess().getY()][((ButtonChess) e.getSource()).getChess().getX()].getX(),
						locationMap.getTaiwaneseLocationMap()[((ButtonChess) e.getSource()).getChess().getY()][((ButtonChess) e.getSource()).getChess().getX()].getY());
				return;
			}
		}

		if ((x % 70) <= 35 && (y % 70) <= 35) {
			System.out.println(x / 70 + " " + y / 70);
			setBtnLoc(whichGame, e, x, y, 0, 0);
//			((JButton) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70][x / 70].getX(), locationMap.getTaiwaneseLocationMap()[y / 70][x / 70].getY());
			manager.moveTo(((ButtonChess) e.getSource()), (x / 70), (y / 70), buttonArrayList, this);
		} else if ((x % 70) > 35 && (y % 70) > 35) {
			System.out.println((x / 70 + 1) + " " + (y / 70 + 1));
			setBtnLoc(whichGame, e, x, y, 1, 1);
//			((JButton) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70 + 1][x / 70 + 1].getX(), locationMap.getTaiwaneseLocationMap()[y / 70 + 1][x / 70 + 1].getY());
			manager.moveTo(((ButtonChess) e.getSource()), (x / 70 + 1), (y / 70 + 1), buttonArrayList, this);
		} else if ((x % 70) > 35 && (y % 70) < 35) {
			System.out.println((x / 70 + 1) + " " + y / 70);
			setBtnLoc(whichGame, e, x, y, 1, 0);
//			((JButton) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70][x / 70 + 1].getX(), locationMap.getTaiwaneseLocationMap()[y / 70][x / 70 + 1].getY());
			manager.moveTo(((ButtonChess) e.getSource()), (x / 70 + 1), (y / 70), buttonArrayList, this);
		} else if ((x % 70) < 35 && (y % 70) > 35) {
			System.out.println(x / 70 + " " + (y / 70 + 1));
			setBtnLoc(whichGame, e, x, y, 0, 1);
//			((JButton) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70 + 1][x / 70].getX(), locationMap.getTaiwaneseLocationMap()[y / 70 + 1][x / 70].getY());
			manager.moveTo(((ButtonChess) e.getSource()), (x / 70), (y / 70 + 1), buttonArrayList, this);
		}
	}
}
