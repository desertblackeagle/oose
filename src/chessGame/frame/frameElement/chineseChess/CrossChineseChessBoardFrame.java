package chessGame.frame.frameElement.chineseChess;

import interfaceGame.chessGame.InterfaceCrossChessBoardFrame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CrossChineseChessBoardFrame extends JPanel implements InterfaceCrossChessBoardFrame{
	int width = 0, hight = 0;
	String imgpath = "";
	private static Font monoFont = new Font("Monospaced", Font.BOLD | Font.ITALIC, 35);

	public CrossChineseChessBoardFrame(int width, int hight, String file) {
		this.width = width;
		this.hight = hight;
		imgpath = file;
	}

	protected void paintComponent(Graphics g) {
//		setBackground(Color.black);

		ImageIcon icon = new ImageIcon(imgpath);
//		System.out.println(WhiteChessBoard.class.getResource("/").toString());
//		java.net.URL imgURL = CrossChineseChessBoardFrame.class.getResource("aa.jpg");
//		ImageIcon icon = new ImageIcon(imgURL);
		Image img = icon.getImage();
		g.drawImage(img, 0, 0, width, hight, this);
		g.setColor(Color.black);
		g.setFont(monoFont);
		FontMetrics fm = g.getFontMetrics();

		int w = fm.stringWidth("楚");
		int h = fm.getAscent();
		g.drawString("楚 ", 345 - (w / 2), 165 + (h / 4));

//		w = fm.stringWidth("河");
//		h = fm.getAscent();
		g.drawString("河 ", 345 - (w / 2), 265 + (h / 4));

//		w = fm.stringWidth("漢");
//		h = fm.getAscent();
		g.drawString("漢 ", 345 - (w / 2), 365 + (h / 4));

//		w = fm.stringWidth("界");
//		h = fm.getAscent();
		g.drawString("界", 345 - (w / 2), 465 + (h / 4));

		float lineWidth = 3.25f;
		((Graphics2D) g).setStroke(new BasicStroke(lineWidth));

		for (int i = 0; i < 10; i++) {// 直線
			((Graphics2D) g).drawLine(30 + i * 70, 30, 30 + i * 70, 590);
		}

		for (int i = 0; i < 9; i++) {// 橫線

			if (i == 0 || i == 9) {
				((Graphics2D) g).drawLine(30, 30, 660, 30);
				((Graphics2D) g).drawLine(30, 590, 660, 590);
			} else {
				((Graphics2D) g).drawLine(30, 30 + i * 70, 310, 30 + i * 70);
				((Graphics2D) g).drawLine(380, 30 + i * 70, 660, 30 + i * 70);
			}
		}
		// 交叉
		((Graphics2D) g).drawLine(31, 241, 170, 380);
		((Graphics2D) g).drawLine(31, 379, 170, 240);
		((Graphics2D) g).drawLine(520, 240, 660, 380);
		((Graphics2D) g).drawLine(520, 380, 660, 240);

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				if (j != 0) {
					((Graphics2D) g).drawLine(225 + (210 * i), 25 + 140 * j, 235 + (210 * i), 25 + 140 * j);
					((Graphics2D) g).drawLine(245 + (210 * i), 25 + 140 * j, 255 + (210 * i), 25 + 140 * j);
					((Graphics2D) g).drawLine(235 + (210 * i), 15 + 140 * j, 235 + (210 * i), 25 + 140 * j);
					((Graphics2D) g).drawLine(245 + (210 * i), 15 + 140 * j, 245 + (210 * i), 25 + 140 * j);
				}
				if (j != 4) {
					((Graphics2D) g).drawLine(225 + (210 * i), 35 + 140 * j, 235 + (210 * i), 35 + 140 * j);
					((Graphics2D) g).drawLine(245 + (210 * i), 35 + 140 * j, 255 + (210 * i), 35 + 140 * j);
					((Graphics2D) g).drawLine(235 + (210 * i), 35 + 140 * j, 235 + (210 * i), 45 + 140 * j);
					((Graphics2D) g).drawLine(245 + (210 * i), 35 + 140 * j, 245 + (210 * i), 45 + 140 * j);
				}
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				((Graphics2D) g).drawLine(155 + (350 * i), 95 + (420 * j), 165 + (350 * i), 95 + (420 * j));
				((Graphics2D) g).drawLine(175 + (350 * i), 95 + (420 * j), 185 + (350 * i), 95 + (420 * j));
				((Graphics2D) g).drawLine(175 + (350 * i), 105 + (420 * j), 185 + (350 * i), 105 + (420 * j));
				((Graphics2D) g).drawLine(155 + (350 * i), 105 + (420 * j), 165 + (350 * i), 105 + (420 * j));

				((Graphics2D) g).drawLine(165 + (350 * i), 85 + (420 * j), 165 + (350 * i), 95 + (420 * j));
				((Graphics2D) g).drawLine(165 + (350 * i), 105 + (420 * j), 165 + (350 * i), 115 + (420 * j));
				((Graphics2D) g).drawLine(175 + (350 * i), 85 + (420 * j), 175 + (350 * i), 95 + (420 * j));
				((Graphics2D) g).drawLine(175 + (350 * i), 105 + (420 * j), 175 + (350 * i), 115 + (420 * j));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CrossChineseChessBoardFrame cp = new CrossChineseChessBoardFrame(700, 630, "c:/aa.jpg");
		cp.setBounds(0, 0, 1000, 1000);
		JFrame frame = new JFrame();

		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(800, 800);
		frame.add(cp);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}