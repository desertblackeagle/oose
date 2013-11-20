package taiwanGameFrameElement;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
/* @author Red Rose
 * Function:a panel to display taiwan chess board
 * Last Update:2013/11/14
 */
public class TaiwanChessBoardPanel extends JPanel {

	public TaiwanChessBoardPanel() {
		// TODO Auto-generated constructor stub
		this.setLayout(null);

		WhiteChessBoard whiteChessBoard = new WhiteChessBoard();
		whiteChessBoard.setBounds(0, 0, 630, 350);
		whiteChessBoard.setBackground(Color.white);
		this.add(whiteChessBoard);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaiwanChessBoardPanel cp = new TaiwanChessBoardPanel();
		cp.setBounds(0, 0, 800, 800);
		JFrame frame = new JFrame();
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(800, 800);
		frame.add(cp);
	}

}