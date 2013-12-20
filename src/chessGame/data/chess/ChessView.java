package chessGame.data.chess;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import chessGame.data.ChessGameData;
import chessGame.data.LocationPoint;
import chessGame.data.status.GameStatus;

public class ChessView extends Chess {
	private String path = "";
	private ImageIcon icon;
	private Image img;

	private int color = 0; // red = 0 black = 1
	private boolean cover = false;

	public ChessView(String path, int color, boolean cover, int chessX, int chessY, ChessGameData data) {
		// TODO Auto-generated constructor stub
		super(color, cover, chessX, chessY, data);
		this.path = path;
		this.color = color;
		this.cover = cover;
		System.out.println("isstraight :" + data.getConfigData().isBoardStraight());
		data.getGameStatus().getChessList().getChessList()[chessY][chessX] = this;
//		System.out.println(getName() + " : " + chessX + " " + chessY);
		int x, y;

		if (data.getConfigData().isBoardStraight()) {
//			System.out.println("Str");
			x = getLocationMap().getChineseLocationMap()[chessY][chessX].getX();
			y = getLocationMap().getChineseLocationMap()[chessY][chessX].getY();
		} else {
//			System.out.println("Cro");
			x = getLocationMap().getChineseLocationPointCross()[chessY][chessX].getX();
			y = getLocationMap().getChineseLocationPointCross()[chessY][chessX].getY();
		}

		setBounds(x, y, 52, 52);
	}

	public ChessView(String path, int color, boolean cover, LocationPoint point, ChessGameData data) {
		// TODO Auto-generated constructor stub
		super(color, cover, point, data);
		this.path = path;
		this.color = color;
		this.cover = cover;

		int x, y;
//		System.out.println("1234" + data.getConfigData().isBoardStraight());
		data.getGameStatus().getChessList().getChessList()[point.getY()][point.getX()] = this;
		if (data.getConfigData().isBoardStraight()) {
//			System.out.println("Str");
			x = getLocationMap().getTaiwanLocationMap()[point.getY()][point.getX()].getX();
			y = getLocationMap().getTaiwanLocationMap()[point.getY()][point.getX()].getY();
//			System.out.println(x + " : " + y);
		} else {
//			System.out.println("Cro");
//			System.out.println("XXXXXXXX : " + point.getY() + " : " + point.getX());
//			System.out.println(getLocationMap().getTaiwanLocationPointCross()[1][0]);
			x = getLocationMap().getTaiwanLocationPointCross()[point.getY()][point.getX()].getX();
			y = getLocationMap().getTaiwanLocationPointCross()[point.getY()][point.getX()].getY();
		}
//		System.out.println("set");
		setBounds(x, y, 52, 52);
	}

//	public void reLocation() {
//		int x, y;
//		if (getData().getGameStatus().getChessStatus().getWhichGame() == 0) {
//			if (getData().getConfigData().isBoardStraight()) {
//				System.out.println("Str " + getName());
//				System.out.println(getChessY() + " : " + getChessX());
//				x = getLocationMap().getTaiwanLocationMap()[getChessY()][getChessX()].getX();
//				y = getLocationMap().getTaiwanLocationMap()[getChessY()][getChessX()].getY();
//				System.out.println(x + " : " + y);
//			} else {
//				System.out.println("Cro " + getName());
//				System.out.println(getChessY() + " : " + getChessX());
//				x = getLocationMap().getTaiwanLocationPointCross()[getChessY()][getChessX()].getX();
//				y = getLocationMap().getTaiwanLocationPointCross()[getChessY()][getChessX()].getY();
//				System.out.println(x + " : " + y);
//			}
//		} else {
//			if (getData().getConfigData().isBoardStraight()) {
//				System.out.println("Str " + getName());
//				System.out.println(getChessY() + " : " + getChessX());
//				x = getLocationMap().getChineseLocationMap()[getChessY()][getChessX()].getX();
//				y = getLocationMap().getChineseLocationMap()[getChessY()][getChessX()].getY();
//				System.out.println(x + " : " + y);
//			} else {
//				System.out.println("Cro " + getName());
//				System.out.println(getChessY() + " : " + getChessX());
//				x = getLocationMap().getChineseLocationPointCross()[getChessY()][getChessX()].getX();
//				y = getLocationMap().getChineseLocationPointCross()[getChessY()][getChessX()].getY();
//				System.out.println(x + " : " + y);
//			}
//		}
//		setBounds(x, y, 52, 52);
//	}

	public void paintComponent(Graphics g) {

		if (getColor() == 0) {
			g.setColor(new Color(227, 33, 34));
		} else {
			g.setColor(new Color(0, 2, 11));
		}
//		System.out.println(isChessCover());
//		if(isChessCover()){
//			System.out.println("1");
//		}else{
//			System.out.println("2");
//		}
		if (!isChessCover()) {
//			System.out.println("paint");
			icon = new ImageIcon(path);
			img = icon.getImage();
			g.drawImage(img, -2, -2, 55, 55, this);

			float lineWidth = 4f;
			((Graphics2D) g).setStroke(new BasicStroke(lineWidth));
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.drawOval(2, 2, 46, 46);
		} else {
//			System.out.println("paint");
			icon = new ImageIcon(path);
			img = icon.getImage();
			g.drawImage(img, -2, -2, 55, 55, this);

			icon = new ImageIcon("c:\\dark\\cover.png");
			img = icon.getImage();
			g.drawImage(img, -7, -5, 64, 64, this);

			g.setColor(Color.black);

			float lineWidth = 4f;
			((Graphics2D) g).setStroke(new BasicStroke(lineWidth));
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.drawOval(2, 2, 46, 46);
		}

	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		JFrame f = new JFrame();
////		f.setSize(800, 600);
////		f.setLayout(null);
////		Cannon bB = new Cannon("c:\\dark\\blackKing.png", 0, false, 0, 5);
//////		Cannon bC = new Cannon("c:\\dark\\blackKing.png", 0, true, 0, 5);
////		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		bB.addMouseMotionListener(new MouseMotionListener() {
////
////			@Override
////			public void mouseMoved(MouseEvent e) {
////				// TODO Auto-generated method stub
////
////			}
////
////			@Override
////			public void mouseDragged(MouseEvent e) {
////				// TODO Auto-generated method stub
////				int x = e.getX();
////				int y = e.getY();
////				((ChessView) e.getSource()).setLocation(((ChessView) e.getSource()).getLocation().x + x - (((ChessView) e.getSource()).getWidth() / 2), ((ChessView) e.getSource()).getLocation().y + y - (((ChessView) e.getSource()).getHeight() / 2));
////
////			}
////		});
//////		bC.setBounds(400, 300, 52, 52);
//////		f.add(bC);
////		f.getContentPane().add(bB);
////		f.setVisible(true);
////		System.out.println("Cover : " + bB.isChessCover());
////		bB.setChessCover(true);
////		System.out.println("Cover : " + bB.isChessCover());
//////		bB.update(bB.getGraphics());
//////		bB.repaint();
//////		bB.paint(bB.getGraphics());
//	}
}
