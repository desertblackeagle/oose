package frame;

import java.awt.Color;

import javax.swing.JFrame;


public class WinFrame {
	public WinFrame() {
		// TODO Auto-generated constructor stub
		JFrame winFrame = new JFrame();
		winFrame.setUndecorated(true);
		winFrame.setVisible(true);
		winFrame.setSize(300, 300);
		winFrame.setLocation(100, 100);
		winFrame.setBackground(Color.black);
//		try {
//			winFrame.wait(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		winFrame.dispose();
//		winFrame.setUndecorated(false);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WinFrame test = new WinFrame();
	}

}
