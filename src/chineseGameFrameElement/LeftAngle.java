package chineseGameFrameElement;


import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
/* @author Red Rose
 * Function:a element of chinese chess board
 * Last Update:2013/11/14
 */
public class LeftAngle extends Component {

	public void paint(Graphics g) {

		float lineWidth = 3.25f;
		((Graphics2D) g).setStroke(new BasicStroke(lineWidth));

		((Graphics2D) g).drawLine(10, 0, 10, 10);
		((Graphics2D) g).drawLine(0, 10, 10, 10);
		((Graphics2D) g).drawLine(15, 0, 15, 30);
		((Graphics2D) g).drawLine(0, 15, 15, 15);
		((Graphics2D) g).drawLine(0, 20, 10, 20);
		((Graphics2D) g).drawLine(10, 30, 10, 20);
	}

}