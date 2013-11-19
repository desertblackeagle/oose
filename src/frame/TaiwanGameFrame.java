package frame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import chess.ChessTable;
import taiwanGameFrameElement.TaiwanChessBoardPanel;
import controlUnit.BoardManager;
import controlUnit.LocationMap;
import frameChess.ButtonChess;

public class TaiwanGameFrame implements MouseMotionListener, MouseListener {
	ChessTable chessTable;
	LocationMap locationMap;
	JFrame frame;
	BoardManager manager;
	ButtonChessArrayList buttonArrayList;

	TaiwanGameFrame(BoardManager manager, ButtonChessArrayList buttonArrayList) {
		this.manager = manager;
		locationMap = new LocationMap();
		this.buttonArrayList = buttonArrayList;

		frame = new JFrame();
		frame.setSize(900, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		for (int i = 0; i < buttonArrayList.btnArrayList.size(); i++) {
			frame.add(buttonArrayList.btnArrayList.get(i));
			buttonArrayList.btnArrayList.get(i).addMouseListener(this);
			buttonArrayList.btnArrayList.get(i).addMouseMotionListener(this);
		}

		TaiwanChessBoardPanel cp = new TaiwanChessBoardPanel();
		cp.setBounds(0, 0, 630, 700);
		cp.setBackground(Color.BLACK);
		frame.add(cp);
		frame.setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		((JButton) e.getSource()).setLocation(((JButton) e.getSource()).getLocation().x + x - (((JButton) e.getSource()).getWidth() / 2), ((JButton) e.getSource()).getLocation().y + y - (((JButton) e.getSource()).getHeight() / 2));
		frame.getContentPane().setComponentZOrder(((JButton) e.getSource()), 0);
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
		int x = e.getXOnScreen() - 73;
		int y = e.getYOnScreen() - 95;
		System.out.println((e.getXOnScreen() - 73) + " " + (e.getYOnScreen() - 95));
		System.out.println(x + " " + y);
		if (x > 525 || y > 245 || x < -35 || y < -35) {
			System.out.println("超出範圍");
			((ButtonChess) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[((ButtonChess) e.getSource()).getChess().getY()][((ButtonChess) e.getSource()).getChess().getX()].getY(),
					locationMap.getTaiwaneseLocationMap()[((ButtonChess) e.getSource()).getChess().getY()][((ButtonChess) e.getSource()).getChess().getX()].getX());
			return;
		}
//		System.out.println(((ButtonChess) e.getSource()).setl);
		if ((x % 70) <= 35 && (y % 70) <= 35) {
			System.out.println(x / 70 + " " + y / 70);

			((JButton) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70][x / 70].getY(), locationMap.getTaiwaneseLocationMap()[y / 70][x / 70].getX());
			manager.moveTo(((ButtonChess) e.getSource()), (x / 70), (y / 70), locationMap, buttonArrayList);

		} else if ((x % 70) > 35 && (y % 70) > 35) {
			System.out.println((x / 70 + 1) + " " + (y / 70 + 1));
			((JButton) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70 + 1][x / 70 + 1].getY(), locationMap.getTaiwaneseLocationMap()[y / 70 + 1][x / 70 + 1].getX());
			manager.moveTo(((ButtonChess) e.getSource()), (x / 70 + 1), (y / 70 + 1), locationMap, buttonArrayList);
		} else if ((x % 70) > 35 && (y % 70) < 35) {
			System.out.println((x / 70 + 1) + " " + y / 70);
			((JButton) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70][x / 70 + 1].getY(), locationMap.getTaiwaneseLocationMap()[y / 70][x / 70 + 1].getX());
			manager.moveTo(((ButtonChess) e.getSource()), (x / 70 + 1), (y / 70), locationMap, buttonArrayList);
		} else if ((x % 70) < 35 && (y % 70) > 35) {
			System.out.println(x / 70 + " " + (y / 70 + 1));
			((JButton) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70 + 1][x / 70].getY(), locationMap.getTaiwaneseLocationMap()[y / 70 + 1][x / 70].getX());
			manager.moveTo(((ButtonChess) e.getSource()), (x / 70), (y / 70 + 1), locationMap, buttonArrayList);
		}
//		else if ((x % 70) == 35 && (y % 70) == 35) {
//			System.out.println(x / 70 + " " + y / 70);
//			((JButton) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70][x / 70].getY(), locationMap.getTaiwaneseLocationMap()[y / 70][x / 70].getX());
//			manager.moveTo(((ButtonChess) e.getSource()), (x / 70), (y / 70), locationMap, buttonArrayList);
//		}

//		System.out.println(x / 70 + " " + y / 70);
	}
}
