package chineseGameFrameElement;


import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
/* @author Red Rose
 * Function:a element of chinese chess board
 * Last Update:2013/11/14
 */
public class RightAngle extends Component {

	public void paint(Graphics g) {

		float lineWidth = 3.25f;
		((Graphics2D) g).setStroke(new BasicStroke(lineWidth));

		((Graphics2D) g).drawLine(5, 0, 5, 10);
		((Graphics2D) g).drawLine(5, 10, 15, 10);
		((Graphics2D) g).drawLine(0, 0, 0, 30);
		((Graphics2D) g).drawLine(0, 15, 15, 15);
		((Graphics2D) g).drawLine(5, 20, 15, 20);
		((Graphics2D) g).drawLine(5, 30, 5, 20);
	}

}