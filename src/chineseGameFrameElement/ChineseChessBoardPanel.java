package chineseGameFrameElement;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChineseChessBoardPanel extends JPanel {

	public ChineseChessBoardPanel() {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		LeftAngle leftAngle;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				leftAngle = new LeftAngle();
				leftAngle.setBounds(155 + j * 140, 225 + i * 210, 17, 30);
				leftAngle.setBackground(Color.white);
				this.add(leftAngle);
			}
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				leftAngle = new LeftAngle();
				leftAngle.setBounds(85 + j * 420, 155 + i * 350, 17, 30);
				leftAngle.setBackground(Color.white);
				this.add(leftAngle);
			}
		}

		RightAngle rightAngle;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				rightAngle = new RightAngle();
				rightAngle.setBounds(30 + j * 140, 225 + i * 210, 17, 30);
				rightAngle.setBackground(Color.white);
				this.add(rightAngle);
			}
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				rightAngle = new RightAngle();
				rightAngle.setBounds(100 + j * 420, 155 + i * 350, 17, 30);
				rightAngle.setBackground(Color.white);
				this.add(rightAngle);
			}
		}

		WhiteChessBoard whiteChessBoard = new WhiteChessBoard();
		whiteChessBoard.setBounds(0, 0, 630, 700);
		whiteChessBoard.setBackground(Color.white);
		this.add(whiteChessBoard);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChineseChessBoardPanel cp = new ChineseChessBoardPanel();
		cp.setBounds(0, 0, 800, 800);
		JFrame frame = new JFrame();
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(800, 800);
		frame.add(cp);
	}

}
