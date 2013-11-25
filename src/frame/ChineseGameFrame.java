package frame;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import selectFrame.FrameModel;
import chineseGameFrameElement.ChineseChessBoardPanel;
import controlUnit.BoardManager;
import controlUnit.LocationMap;
import frameChess.ButtonChess;

public class ChineseGameFrame extends FrameModel implements MouseMotionListener, MouseListener {

	private LocationMap locationMap;
	private BoardManager manager;
	private ButtonChessArrayList buttonArrayList;

	public ChineseGameFrame(BoardManager manager, ButtonChessArrayList buttonArrayList, String title, int locationX, int locationY) {
		this.manager = manager;
		locationMap = new LocationMap();
		this.buttonArrayList = buttonArrayList;
		setLocation(locationX, locationY);
		setTitle(title);
		if(img == null){
			
		}else{
			img.setImage(img.getImage().getScaledInstance(800, 150, Image.SCALE_DEFAULT));
		}
		
		
		for (int i = 0; i < buttonArrayList.getBtnArrayList().size(); i++) {
			add(buttonArrayList.getBtnArrayList().get(i));
			buttonArrayList.getBtnArrayList().get(i).addMouseListener(this);
			buttonArrayList.getBtnArrayList().get(i).addMouseMotionListener(this);
		}

		ChineseChessBoardPanel cp = new ChineseChessBoardPanel();
		cp.setBounds(0, 0, 630, 700);
		cp.setBackground(Color.BLACK);

		add(cp);

		setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (!((ButtonChess) e.getSource()).getChess().isChessDead()) {
			int x = e.getX();
			int y = e.getY();
			((JButton) e.getSource()).setLocation(((JButton) e.getSource()).getLocation().x + x - (((JButton) e.getSource()).getWidth() / 2), ((JButton) e.getSource()).getLocation().y + y - (((JButton) e.getSource()).getHeight() / 2));
			getContentPane().setComponentZOrder(((JButton) e.getSource()), 0);
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
		int x = e.getXOnScreen() - 38 - getLocationOnScreen().x;
		int y = e.getYOnScreen() - 60 - getLocationOnScreen().y;
		System.out.println(e.getX() + " , " + e.getY());
		System.out.println((e.getXOnScreen() - 38 - getLocationOnScreen().x) + " : " + (e.getYOnScreen() - 60 - getLocationOnScreen().y));
		if (x > 595 || y > 665) {
			((ButtonChess) e.getSource()).setLocation(locationMap.getChineseLocationMap()[((ButtonChess) e.getSource()).getChess().getY()][((ButtonChess) e.getSource()).getChess().getX()].getX(),
					locationMap.getChineseLocationMap()[((ButtonChess) e.getSource()).getChess().getY()][((ButtonChess) e.getSource()).getChess().getX()].getY());
			System.out.println("超出範圍");
			return;
		}

		if ((x % 70) <= 35 && (y % 70) <= 35) {
			System.out.println(x / 70 + " " + y / 70);
			((JButton) e.getSource()).setLocation(locationMap.getChineseLocationMap()[y / 70][x / 70].getX(), locationMap.getChineseLocationMap()[y / 70][x / 70].getY());
			manager.moveTo(((ButtonChess) e.getSource()), (x / 70), (y / 70), buttonArrayList, this);
		} else if ((x % 70) > 35 && (y % 70) > 35) {
			System.out.println((x / 70 + 1) + " " + (y / 70 + 1));
			((JButton) e.getSource()).setLocation(locationMap.getChineseLocationMap()[y / 70 + 1][x / 70 + 1].getX(), locationMap.getChineseLocationMap()[y / 70 + 1][x / 70 + 1].getY());
			manager.moveTo(((ButtonChess) e.getSource()), (x / 70 + 1), (y / 70 + 1), buttonArrayList, this);
		} else if ((x % 70) > 35 && (y % 70) <= 35) {
			System.out.println((x / 70 + 1) + " " + y / 70);
			((JButton) e.getSource()).setLocation(locationMap.getChineseLocationMap()[y / 70][x / 70 + 1].getX(), locationMap.getChineseLocationMap()[y / 70][x / 70 + 1].getY());
			manager.moveTo(((ButtonChess) e.getSource()), (x / 70 + 1), (y / 70), buttonArrayList, this);
		} else if ((x % 70) <= 35 && (y % 70) > 35) {
			System.out.println(x / 70 + " " + (y / 70 + 1));
			((JButton) e.getSource()).setLocation(locationMap.getChineseLocationMap()[y / 70 + 1][x / 70].getX(), locationMap.getChineseLocationMap()[y / 70 + 1][x / 70].getY());
			manager.moveTo(((ButtonChess) e.getSource()), (x / 70), (y / 70 + 1), buttonArrayList, this);
		}

	}
}
