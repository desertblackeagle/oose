package abstractGame.chessGame;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import chessGame.data.ChessGameData;
import chessGame.frame.dialog.FrameCheckDialog;

public abstract class AbstractFrameModel extends JFrame implements ActionListener{

	boolean visable = true;
	public ChessGameData data;

//	public FrameModel(boolean visable) {
//		this.visable = visable;
//		initFrame();
//		initFrameEventListeners();
//	}

	public AbstractFrameModel(boolean visable, ChessGameData data) {
		this.visable = visable;
		initFrame();
		initFrameEventListeners();
		this.data = data;
	}

	public void initFrame() {
		setSize(1000, 739);
		setVisible(visable);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
	}

	public void initFrameEventListeners() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new FrameCheckDialog();
			}
		});
	}

	public abstract JButton makeButton(String text);

	public static void main(String[] args) {
//		FrameModel frame = new FrameModel(true);
	}
}
