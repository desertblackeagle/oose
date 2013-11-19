package taiwanGameFrameElement;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
/* @author Red Rose
 * Function:a element of taiwan chess board
 * Last Update:2013/11/14
 */
public class WhiteChessBoard extends Canvas {

	public void paint(Graphics g) {

		float lineWidth = 3.25f;
		((Graphics2D) g).setStroke(new BasicStroke(lineWidth));

		for (int i = 0; i < 5; i++) {
			((Graphics2D) g).drawLine(30, 30 + i * 70, 590, 30 + i * 70);
		}

		for (int i = 0; i < 9; i++) {
			((Graphics2D) g).drawLine(30 + i * 70, 30, 30 + i * 70, 310);
		}
//
//		for (int i = 0; i < 9; i++) {
//			((Graphics2D) g).drawLine(30 + i * 70, 380, 30 + i * 70, 660);
//		}
//
//		for (int i = 0; i < 2; i++) {
//			((Graphics2D) g).drawLine(30 + i * 560, 310, 30 + i * 560, 380);
//		}
//
//		for (int i = 0; i < 2; i++) {
//			((Graphics2D) g).drawLine(241, 31 + i * 490, 379, 169 + i * 490);
//		}
//
//		for (int i = 0; i < 2; i++) {
//			((Graphics2D) g).drawLine(379, 31 + i * 490, 241, 169 + i * 490);
//		}

	}

}