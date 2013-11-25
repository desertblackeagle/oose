package frame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

import selectFrame.FrameModel;
import taiwanGameFrameElement.TaiwanChessBoardPanel;
import controlUnit.BoardManager;
import controlUnit.LocationMap;
import frameChess.ButtonChess;

public class TaiwanGameFrame extends FrameModel implements MouseMotionListener, MouseListener {

	private LocationMap locationMap = new LocationMap();
	private BoardManager manager;
	private ButtonChessArrayList buttonArrayList;

	public TaiwanGameFrame(BoardManager manager, ButtonChessArrayList buttonArrayList, String title, int locationX, int locationY) {
		this.manager = manager;
		this.buttonArrayList = buttonArrayList;

		setLocation(locationX, locationY);
		setTitle(title);

		for (int i = 0; i < buttonArrayList.getBtnArrayList().size(); i++) {
			add(buttonArrayList.getBtnArrayList().get(i));
			buttonArrayList.getBtnArrayList().get(i).addMouseListener(this);
			buttonArrayList.getBtnArrayList().get(i).addMouseMotionListener(this);
		}

		TaiwanChessBoardPanel cp = new TaiwanChessBoardPanel();
		cp.setBounds(0, 0, 630, 700);
		cp.setBackground(Color.BLACK);
		add(cp);
		setVisible(true);
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
		if (!((ButtonChess) e.getSource()).getChess().isChessDead()) {
			int x = e.getXOnScreen() - 73 - getLocationOnScreen().x;
			int y = e.getYOnScreen() - 95 - getLocationOnScreen().y;
			System.out.println((e.getXOnScreen() - 73) + " " + (e.getYOnScreen() - 95));
			System.out.println(x + " " + y);
			if (x > 525 || y > 245 || x < -35 || y < -35) {
				System.out.println("超出範圍");
				((ButtonChess) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[((ButtonChess) e.getSource()).getChess().getY()][((ButtonChess) e.getSource()).getChess().getX()].getX(),
						locationMap.getTaiwaneseLocationMap()[((ButtonChess) e.getSource()).getChess().getY()][((ButtonChess) e.getSource()).getChess().getX()].getY());
				return;
			}
//		System.out.println(((ButtonChess) e.getSource()).setl);
			if ((x % 70) <= 35 && (y % 70) <= 35) {
				System.out.println(x / 70 + " " + y / 70);
				((JButton) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70][x / 70].getX(), locationMap.getTaiwaneseLocationMap()[y / 70][x / 70].getY());
				manager.moveTo(((ButtonChess) e.getSource()), (x / 70), (y / 70), buttonArrayList, this);
			} else if ((x % 70) > 35 && (y % 70) > 35) {
				System.out.println((x / 70 + 1) + " " + (y / 70 + 1));
				((JButton) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70 + 1][x / 70 + 1].getX(), locationMap.getTaiwaneseLocationMap()[y / 70 + 1][x / 70 + 1].getY());
				manager.moveTo(((ButtonChess) e.getSource()), (x / 70 + 1), (y / 70 + 1), buttonArrayList, this);
			} else if ((x % 70) > 35 && (y % 70) < 35) {
				System.out.println((x / 70 + 1) + " " + y / 70);
				((JButton) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70][x / 70 + 1].getX(), locationMap.getTaiwaneseLocationMap()[y / 70][x / 70 + 1].getY());
				manager.moveTo(((ButtonChess) e.getSource()), (x / 70 + 1), (y / 70), buttonArrayList, this);
			} else if ((x % 70) < 35 && (y % 70) > 35) {
				System.out.println(x / 70 + " " + (y / 70 + 1));
				((JButton) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70 + 1][x / 70].getX(), locationMap.getTaiwaneseLocationMap()[y / 70 + 1][x / 70].getY());
				manager.moveTo(((ButtonChess) e.getSource()), (x / 70), (y / 70 + 1), buttonArrayList, this);
			}
		}
	}
}
