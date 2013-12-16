package abstractGame.chessGame;

import interfaceGame.chessGame.InterfaceCrossChessBoardFrame;
import interfaceGame.chessGame.InterfaceStraightChessBoardFrame;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import chessGame.data.ChessGameData;
import chessGame.data.chess.ChessView;
import chessGame.frame.frameOption.MainView;

public abstract class AbstractChessBoardFactory extends AbstractFrameModel implements MouseListener, MouseMotionListener {
	private JButton backMain;
	private JPanel panel;

	public AbstractChessBoardFactory(boolean visable, ChessGameData data, int x, int y) {
		super(visable, data);
		// TODO Auto-generated constructor stub
		setLocation(x, y);

		panel = new JPanel();

		backMain = makeButton("返回主畫面");
		backMain.addActionListener(this);
		backMain.setBounds(50, 500, 100, 50);

		panel.setLayout(null);
		panel.setBounds(700, 0, 300, 739);
		add(panel);
		panel.add(backMain);
		initBoard();
	}

	public abstract void initBoard();

	public abstract InterfaceCrossChessBoardFrame makeCrossChessBoard();

	public abstract InterfaceStraightChessBoardFrame makeStraightChessBoard();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String buttonName = e.getActionCommand();

		if (buttonName.equals("返回主畫面")) {
			setVisible(false);
			dispose();
			new MainView(true, this.getLocation().x, this.getLocation().y, data);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (((ChessView) e.getSource()).isChessCover()) {
			((ChessView) e.getSource()).setChessCover(false);
			((ChessView) e.getSource()).repaint();
		}
		System.out.println("mouseClicked : " + e.getX() + " " + e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseExited");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mousePressed" + e.getX() + " " + e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseReleased");
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (!((ChessView) e.getSource()).isChessCover()) {
			((ChessView) e.getSource()).setLocation((e.getX() + ((ChessView) e.getSource()).getLocation().x - ((ChessView) e.getSource()).getWidth() / 2), (e.getY() + ((ChessView) e.getSource()).getLocation().y - ((ChessView) e.getSource()).getHeight() / 2));
		} else {
			((ChessView) e.getSource()).setChessCover(false);
			((ChessView) e.getSource()).repaint();
		}
		System.out.println("mouseDragged");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseMoved");
	}
}
