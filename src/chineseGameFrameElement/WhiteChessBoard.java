package chineseGameFrameElement;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/* @author Red Rose
 * Function:a element of chinese chess board
 * Last Update:2013/11/14
 */
public class WhiteChessBoard extends JPanel {
	int width = 0, hight = 0;
	String imgpath = "";

	public WhiteChessBoard(int width, int hight, String file) {
		this.width = width;
		this.hight = hight;
		imgpath = file;
	}

	protected void paintComponent(Graphics g) {
//		setBackground(Color.black);
		ImageIcon icon = new ImageIcon(imgpath);
		Image img = icon.getImage();
		g.drawImage(img, 0, 0, width, hight, this);

		float lineWidth = 3.25f;
		((Graphics2D) g).setStroke(new BasicStroke(lineWidth));

		for (int i = 0; i < 10; i++) {
			((Graphics2D) g).drawLine(30, 30 + i * 70, 590, 30 + i * 70);
		}

		for (int i = 0; i < 9; i++) {
			((Graphics2D) g).drawLine(30 + i * 70, 30, 30 + i * 70, 310);
		}

		for (int i = 0; i < 9; i++) {
			((Graphics2D) g).drawLine(30 + i * 70, 380, 30 + i * 70, 660);
		}

		for (int i = 0; i < 2; i++) {
			((Graphics2D) g).drawLine(30 + i * 560, 310, 30 + i * 560, 380);
		}

		for (int i = 0; i < 2; i++) {
			((Graphics2D) g).drawLine(241, 31 + i * 490, 379, 169 + i * 490);
		}

		for (int i = 0; i < 2; i++) {
			((Graphics2D) g).drawLine(379, 31 + i * 490, 241, 169 + i * 490);
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				((Graphics2D) g).drawLine(140 * j + 165, 225, 140 * j + 165, 235);
				((Graphics2D) g).drawLine(140 * j + 155, 235, 140 * j + 165, 235);
				((Graphics2D) g).drawLine(140 * j + 170, 225, 140 * j + 170, 260);
				((Graphics2D) g).drawLine(140 * j + 155, 240, 140 * j + 170, 240);
				((Graphics2D) g).drawLine(140 * j + 155, 245, 140 * j + 165, 245);
				((Graphics2D) g).drawLine(140 * j + 165, 255, 140 * j + 165, 245);
				((Graphics2D) g).drawLine(140 * j + 165, 225 + 210, 140 * j + 165, 235 + 210);
				((Graphics2D) g).drawLine(140 * j + 155, 235 + 210, 140 * j + 165, 235 + 210);
				((Graphics2D) g).drawLine(140 * j + 170, 225 + 210, 140 * j + 170, 260 + 210);
				((Graphics2D) g).drawLine(140 * j + 155, 240 + 210, 140 * j + 170, 240 + 210);
				((Graphics2D) g).drawLine(140 * j + 155, 245 + 210, 140 * j + 165, 245 + 210);
				((Graphics2D) g).drawLine(140 * j + 165, 255 + 210, 140 * j + 165, 245 + 210);
			}
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				((Graphics2D) g).drawLine(140 * j + 35, 225, 140 * j + 35, 235);
				((Graphics2D) g).drawLine(140 * j + 35, 235, 140 * j + 45, 235);
				((Graphics2D) g).drawLine(140 * j + 30, 225, 140 * j + 30, 255);
				((Graphics2D) g).drawLine(140 * j + 30, 240, 140 * j + 45, 240);
				((Graphics2D) g).drawLine(140 * j + 35, 245, 140 * j + 45, 245);
				((Graphics2D) g).drawLine(140 * j + 35, 255, 140 * j + 35, 245);
				((Graphics2D) g).drawLine(140 * j + 35, 225 + 210, 140 * j + 35, 235 + 210);
				((Graphics2D) g).drawLine(140 * j + 35, 235 + 210, 140 * j + 45, 235 + 210);
				((Graphics2D) g).drawLine(140 * j + 30, 225 + 210, 140 * j + 30, 255 + 210);
				((Graphics2D) g).drawLine(140 * j + 30, 240 + 210, 140 * j + 45, 240 + 210);
				((Graphics2D) g).drawLine(140 * j + 35, 245 + 210, 140 * j + 45, 245 + 210);
				((Graphics2D) g).drawLine(140 * j + 35, 255 + 210, 140 * j + 35, 245 + 210);
			}
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				((Graphics2D) g).drawLine(420 * j + 95, 350 * i + 155, 420 * j + 95, 350 * i + 165);
				((Graphics2D) g).drawLine(420 * j + 85, 350 * i + 165, 420 * j + 95, 350 * i + 165);
				((Graphics2D) g).drawLine(420 * j + 100, 350 * i + 155, 420 * j + 100, 350 * i + 185);
				((Graphics2D) g).drawLine(420 * j + 85, 350 * i + 170, 420 * j + 100, 350 * i + 170);
				((Graphics2D) g).drawLine(420 * j + 85, 350 * i + 175, 420 * j + 95, 350 * i + 175);
				((Graphics2D) g).drawLine(420 * j + 95, 350 * i + 185, 420 * j + 95, 350 * i + 175);
				((Graphics2D) g).drawLine(420 * j + 105, 350 * i + 155, 420 * j + 105, 350 * i + 165);
				((Graphics2D) g).drawLine(420 * j + 105, 350 * i + 165, 420 * j + 115, 350 * i + 165);
				((Graphics2D) g).drawLine(420 * j + 100, 350 * i + 155, 420 * j + 100, 350 * i + 185);
				((Graphics2D) g).drawLine(420 * j + 100, 350 * i + 170, 420 * j + 115, 350 * i + 170);
				((Graphics2D) g).drawLine(420 * j + 105, 350 * i + 175, 420 * j + 115, 350 * i + 175);
				((Graphics2D) g).drawLine(420 * j + 105, 350 * i + 185, 420 * j + 105, 350 * i + 175);
			}
		}

	}

//	public WhiteChessBoard() {
//		// TODO Auto-generated constructor stub
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WhiteChessBoard cp = new WhiteChessBoard(560, 630, "c://a.jpg");
		cp.setBounds(0, 0, 800, 800);
		JFrame frame = new JFrame();

		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(800, 800);
		frame.add(cp);
	}

}