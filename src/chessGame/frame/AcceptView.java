package chessGame.frame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class AcceptView extends JComponent {

	public AcceptView() {
		// TODO Auto-generated constructor stub
		setBounds(0, 0, 52, 52);
	}

	public void paintComponent(Graphics g) {

		g.setColor(Color.green);

		float lineWidth = 4f;
		((Graphics2D) g).setStroke(new BasicStroke(lineWidth));
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawOval(2, 2, 46, 46);

	}
}
