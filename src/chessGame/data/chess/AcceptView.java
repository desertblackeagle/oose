package chessGame.data.chess;

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
		setBounds(0,0, 52, 52);
	}
	
	public void paintComponent(Graphics g) {

		g.setColor(Color.green);

		float lineWidth = 4f;
		((Graphics2D) g).setStroke(new BasicStroke(lineWidth));
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawOval(2, 2, 46, 46);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.setSize(800, 600);
		f.setLayout(null);
		
		AcceptView bB = new AcceptView();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bB.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.getX();
				int y = e.getY();
				((ChessView) e.getSource()).setLocation(((ChessView) e.getSource()).getLocation().x + x - (((ChessView) e.getSource()).getWidth() / 2), ((ChessView) e.getSource()).getLocation().y + y - (((ChessView) e.getSource()).getHeight() / 2));

			}
		});
		f.getContentPane().add(bB);
		f.setVisible(true);
	}
}
