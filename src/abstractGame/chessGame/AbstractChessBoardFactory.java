package abstractGame.chessGame;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import interfaceGame.chessGame.InterfaceCrossChessBoardFrame;
import interfaceGame.chessGame.InterfaceStraightChessBoardFrame;
import chessGame.data.ChessGameData;
import chessGame.frame.frameOption.MainView;

public abstract class AbstractChessBoardFactory extends AbstractFrameModel {
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

	public abstract void initBoard();

	public abstract InterfaceCrossChessBoardFrame makeCrossChessBoard();

	public abstract InterfaceStraightChessBoardFrame makeStraightChessBoard();
}
