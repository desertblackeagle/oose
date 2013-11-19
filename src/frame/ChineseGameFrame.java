package frame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import chess.ChessTable;
import chineseGameFrameElement.ChineseChessBoardPanel;
import controlUnit.BoardManager;
import controlUnit.LocationMap;
import frameChess.ButtonChess;

public class ChineseGameFrame implements MouseMotionListener, MouseListener {
//	ChessTable chessTable;
	LocationMap locationMap;
	JFrame frame;
	BoardManager manager;
	ButtonChessArrayList buttonArrayList;

	ChineseGameFrame(BoardManager manager, ButtonChessArrayList buttonArrayList) {
		this.manager = manager;
		locationMap = new LocationMap();
		this.buttonArrayList = buttonArrayList;
//		this.chessTable = chesstable;
		frame = new JFrame();
		frame.setSize(900, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		for (int i = 0; i < buttonArrayList.btnArrayList.size(); i++) {
			frame.add(buttonArrayList.btnArrayList.get(i));
			buttonArrayList.btnArrayList.get(i).addMouseListener(this);
			buttonArrayList.btnArrayList.get(i).addMouseMotionListener(this);
		}

		ChineseChessBoardPanel cp = new ChineseChessBoardPanel();
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
		int x = e.getXOnScreen() - 38;
		int y = e.getYOnScreen() - 60;
		System.out.println((e.getXOnScreen() - 38) + " " + (e.getYOnScreen() - 60));
		if (x > 595 || y > 665) {
			((ButtonChess) e.getSource()).setLocation(locationMap.getChineseLocationMap()[((ButtonChess) e.getSource()).getChess().getY()][((ButtonChess) e.getSource()).getChess().getX()].getY(), locationMap.getChineseLocationMap()[((ButtonChess) e.getSource()).getChess().getY()][((ButtonChess) e.getSource())
					.getChess().getX()].getX());
			return;
		}

		if ((x % 70) < 35 && (y % 70) < 35) {
			System.out.println(x / 70 + " " + y / 70);

			((JButton) e.getSource()).setLocation(locationMap.getChineseLocationMap()[y / 70][x / 70].getY(), locationMap.getChineseLocationMap()[y / 70][x / 70].getX());
			manager.moveTo(((ButtonChess) e.getSource()), (x / 70), (y / 70), locationMap, buttonArrayList);

		} else if ((x % 70) > 35 && (y % 70) > 35) {
			System.out.println((x / 70 + 1) + " " + (y / 70 + 1));
			((JButton) e.getSource()).setLocation(locationMap.getChineseLocationMap()[y / 70 + 1][x / 70 + 1].getY(), locationMap.getChineseLocationMap()[y / 70 + 1][x / 70 + 1].getX());
			manager.moveTo(((ButtonChess) e.getSource()), (x / 70 + 1), (y / 70 + 1), locationMap, buttonArrayList);
		} else if ((x % 70) > 35 && (y % 70) < 35) {
			System.out.println((x / 70 + 1) + " " + y / 70);
			((JButton) e.getSource()).setLocation(locationMap.getChineseLocationMap()[y / 70][x / 70 + 1].getY(), locationMap.getChineseLocationMap()[y / 70][x / 70 + 1].getX());
			manager.moveTo(((ButtonChess) e.getSource()), (x / 70 + 1), (y / 70), locationMap, buttonArrayList);
		} else if ((x % 70) < 35 && (y % 70) > 35) {
			System.out.println(x / 70 + " " + (y / 70 + 1));
			((JButton) e.getSource()).setLocation(locationMap.getChineseLocationMap()[y / 70 + 1][x / 70].getY(), locationMap.getChineseLocationMap()[y / 70 + 1][x / 70].getX());
			manager.moveTo(((ButtonChess) e.getSource()), (x / 70), (y / 70 + 1), locationMap, buttonArrayList);
		} else if ((x % 70) == 35 && (y % 70) == 35) {
			System.out.println(x / 70 + " " + y / 70);
			((JButton) e.getSource()).setLocation(locationMap.getChineseLocationMap()[y / 70][x / 70].getY(), locationMap.getChineseLocationMap()[y / 70][x / 70].getX());
			manager.moveTo(((ButtonChess) e.getSource()), (x / 70), (y / 70), locationMap, buttonArrayList);
		}

	}
}
