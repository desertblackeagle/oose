package chessGame.frame.frameElement;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/* @author Red Rose
 * Function:a element of taiwan chess board
 * Last Update:2013/11/14
 */
public class TaiwanChessBoardFrame extends JPanel {

	int width = 0, hight = 0;
	String imgpath = "";

	public TaiwanChessBoardFrame(int width, int hight, String file) {
		this.width = width;
		this.hight = hight;
		imgpath = file;
	}

	protected void paintComponent(Graphics g) {
		ImageIcon icon = new ImageIcon(imgpath);
		Image img = icon.getImage();
		g.drawImage(img, 0, 0, width, hight, this);

		float lineWidth = 3.25f;
		((Graphics2D) g).setStroke(new BasicStroke(lineWidth));

		for (int i = 0; i < 5; i++) {
			((Graphics2D) g).drawLine(30, 30 + i * 70, 590, 30 + i * 70);
		}

		for (int i = 0; i < 9; i++) {
			((Graphics2D) g).drawLine(30 + i * 70, 30, 30 + i * 70, 310);
		}

		for (int i = 0; i < 2; i++) {
			((Graphics2D) g).drawLine(30 + i * 560, 380, 30 + i * 560, 660);
		}

		for (int i = 0; i < 2; i++) {
			((Graphics2D) g).drawLine(30, 380 + i * 280, 590, 380 + i * 280);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaiwanChessBoardFrame cp = new TaiwanChessBoardFrame(630, 700, "c:/aa.jpg");
		cp.setBounds(0, 0, 800, 800);
		JFrame frame = new JFrame();
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(800, 800);
		frame.add(cp);
	}
}