package frame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import chess.ChessTable;
import taiwaneseGameFrameElement.TaiwaneseChessBoardPanel;
import controlUnit.BoardManager;
import controlUnit.LocationMap;
import frameChess.ButtonChess;

public class TaiwaneseGameFrame implements MouseMotionListener, MouseListener {
	ChessTable chessTable;
	LocationMap locationMap;
	JFrame frame;
	BoardManager manager;
	ButtonChessArrayList buttonArrayList;

	TaiwaneseGameFrame(BoardManager manager, ButtonChessArrayList buttonArrayList) {
		this.manager = manager;
		locationMap = new LocationMap();
//		chessTable = new ChessTable(manager);
		this.buttonArrayList = buttonArrayList;
//		Font f = new Font("車", Font.ROMAN_BASELINE, 15);

//		PawnChess redPc1 = new PawnChess(nt.getRedPawn1().getChineseName(),nt.getRedPawn1(),locationMap);
//		redPc1.getBtn().setSize(50, 50);
//		redPc1.getBtn().addMouseMotionListener(this);
//		redPc1.getBtn().addMouseListener(this);

//		ButtonChess bc = new ButtonChess(chessTable.getRedPawn1().getChineseName(),chessTable.getRedPawn1(),locationMap);
//		bc.getBtn().addMouseMotionListener(this);
//		bc.getBtn().addMouseListener(this);

//		System.out.println(buttonArrayList.btnArrayList.get(0));

//		PawnChess blackPc1 = new PawnChess(nt.getBlackPawn1(),locationMap);
//		blackPc1.setSize(50, 50);
//		blackPc1.addMouseMotionListener(this);
//		
//		JButton btn = new JButton("車");
//		btn.setSize(50, 50);
//		btn.setFont(f);
//		btn.setLocation(565, 5);
//		btn.addMouseMotionListener(this);
//		
//		JButton btn1 = new JButton("車");
//		btn1.setSize(50, 50);
//		btn1.setFont(f);
//		btn1.setLocation(5, 5);
//		btn1.addMouseMotionListener(this);
//		ChessPanel cpp = new ChessPanel(manager, locationMap);

		frame = new JFrame();
		frame.setSize(900, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
//		frame.add(blackPc1);
//		frame.add(bc);
//		frame.add(btn);
//		frame.add(btn1);
//		frame.add(buttonArrayList.get());

		for (int i = 0; i < buttonArrayList.btnArrayList.size(); i++) {
			frame.add(buttonArrayList.btnArrayList.get(i));
			buttonArrayList.btnArrayList.get(i).addMouseListener(this);
			buttonArrayList.btnArrayList.get(i).addMouseMotionListener(this);
		}

//		frame.add(cpp.redPawn1.btn);
//		cpp.redPawn1.btn.addMouseMotionListener(this);
//		cpp.redPawn1.btn.addMouseListener(this);

		TaiwaneseChessBoardPanel cp = new TaiwaneseChessBoardPanel();
		cp.setBounds(0, 0, 630, 700);
		cp.setBackground(Color.BLACK);
//		frame.addMouseListener(this);
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
		System.out.println((e.getXOnScreen() - 73) + " " + (e.getYOnScreen() - 95));
		System.out.println(x+" "+y);
		if (x > 595 || y > 280) {
			System.out.println("超出範圍");
			((ButtonChess) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[((ButtonChess) e.getSource()).getChess().getY()][((ButtonChess) e.getSource()).getChess().getX()].getY(),
					locationMap.getTaiwaneseLocationMap()[((ButtonChess) e.getSource()).getChess().getY()][((ButtonChess) e.getSource()).getChess().getX()].getX());
			return;
		}
//		System.out.println(((ButtonChess) e.getSource()).setl);
		if ((x % 70) < 35 && (y % 70) < 35) {
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
		} else if ((x % 70) == 35 && (y % 70) == 35) {
			System.out.println(x / 70 + " " + y / 70);
			((JButton) e.getSource()).setLocation(locationMap.getTaiwaneseLocationMap()[y / 70][x / 70].getY(), locationMap.getTaiwaneseLocationMap()[y / 70][x / 70].getX());
			manager.moveTo(((ButtonChess) e.getSource()), (x / 70), (y / 70), locationMap, buttonArrayList);
		}

//		System.out.println(x / 70 + " " + y / 70);
	}
}
