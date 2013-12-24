package chessGame.frame.chess;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import chessGame.data.ChessGameData;
import chessGame.data.LocationPoint;
import chessGame.frame.Chess;

public class ChessView extends Chess {
	private String path = "";
	private ImageIcon icon;
	private Image img;

//	private int color = 0; // red = 0 black = 1
//	private boolean cover = false;

	public ChessView(String path, int color, boolean cover, int chessX, int chessY, ChessGameData data) {
		// TODO Auto-generated constructor stub
		super(color, cover, chessX, chessY, data);
		this.path = path;
//		this.color = color;
//		this.cover = cover;
		System.out.println("isstraight :" + data.getConfigData().isBoardStraight());
		data.getGameStatus().getChessList().getChessList()[chessY][chessX] = this;
		int x, y;

		if (data.getConfigData().isBoardStraight()) {
			x = getLocationMap().getChineseLocationMap()[chessY][chessX].getX();
			y = getLocationMap().getChineseLocationMap()[chessY][chessX].getY();
		} else {
			x = getLocationMap().getChineseLocationPointCross()[chessY][chessX].getX();
			y = getLocationMap().getChineseLocationPointCross()[chessY][chessX].getY();
		}

		setBounds(x, y, 52, 52);
	}

	public ChessView(String path, int color, boolean cover, LocationPoint point, ChessGameData data) {
		// TODO Auto-generated constructor stub
		super(color, cover, point, data);
		this.path = path;
//		this.color = color;
//		this.cover = cover;

		int x, y;
		data.getGameStatus().getChessList().getChessList()[point.getY()][point.getX()] = this;
		if (data.getConfigData().isBoardStraight()) {
			x = getLocationMap().getTaiwanLocationMap()[point.getY()][point.getX()].getX();
			y = getLocationMap().getTaiwanLocationMap()[point.getY()][point.getX()].getY();
		} else {
			x = getLocationMap().getTaiwanLocationPointCross()[point.getY()][point.getX()].getX();
			y = getLocationMap().getTaiwanLocationPointCross()[point.getY()][point.getX()].getY();
		}
		setBounds(x, y, 52, 52);
	}

	public void paintComponent(Graphics g) {

		if (getColor() == 0) {
			g.setColor(new Color(227, 33, 34));
		} else {
			g.setColor(new Color(0, 2, 11));
		}
		if (!isChessCover()) {
			icon = new ImageIcon(path);
			img = icon.getImage();
			g.drawImage(img, -2, -2, 55, 55, this);

			float lineWidth = 4f;
			((Graphics2D) g).setStroke(new BasicStroke(lineWidth));
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.drawOval(2, 2, 46, 46);
		} else {
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
}
