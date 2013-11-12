package frame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class firstpage extends javax.swing.JFrame {
	static firstpage app = new firstpage();
	private JFrame mainFrame;

	// 建構函式
	public firstpage() {
		mainFrame = new JFrame("第一頁");
		JPanel jpanel1 = new JPanel();
		jpanel1.setPreferredSize(new Dimension(550, 400));

		JButton btn1 = new JButton("開啟第二頁");
		btn1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				link();
			}
		});
		JScrollPane jscrollpane1 = new JScrollPane(btn1);
		jpanel1.add(jscrollpane1, BorderLayout.CENTER);
		// Add
		mainFrame.setLocationRelativeTo(null);
		// END
		mainFrame.add(jpanel1, BorderLayout.CENTER);
		mainFrame.setSize(250, 120);
		mainFrame.setVisible(true);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private void link() {
		// 做連接到下一頁動作
		mainFrame.setVisible(false);// 不顯示第一頁
		mainFrame.dispose();
		secondpage secondframe = new secondpage();// 產生第二頁的object
		secondframe.setLocationRelativeTo(null);// 把視窗至中
	}

	public static void main(String[] args) {
	}
}