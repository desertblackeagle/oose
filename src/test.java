import javax.swing.JFrame;

import chessGame.data.ChessGameData;
import chessGame.frame.ChineseChessBoard;
import chessGame.frame.TaiwanChessBoard;
import chessGame.frame.frameElement.chineseChess.CrossChineseChessBoardFrame;
import chessGame.frame.frameElement.chineseChess.StraightChineseChessBoardFrame;
import chessGame.frame.frameElement.taiwanChess.CrossTaiwanChessBoardFrame;
import chessGame.frame.frameElement.taiwanChess.StraightTaiwanChessBoardFrame;

public class test {
	JFrame f;

	public test() {
		// TODO Auto-generated constructor stub
		f = new JFrame();
		f.setSize(1000, 739);
		f.setVisible(true);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame get() {
		return f;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		CrossChineseChessBoardFrame cc = new CrossChineseChessBoardFrame(700, 700, "c:\\aa.jpg");
//		CrossTaiwanChessBoardFrame ct = new CrossTaiwanChessBoardFrame(700, 700, "c:\\aa.jpg");
//		StraightTaiwanChessBoardFrame st = new StraightTaiwanChessBoardFrame(700, 700, "c:\\aa.jpg");
//		StraightChineseChessBoardFrame sc = new StraightChineseChessBoardFrame(700, 700, "c:\\aa.jpg");
//		
//		cc.setBounds(0, 0, 700, 700);
//		ct.setBounds(0, 0, 700, 700);
//		st.setBounds(0, 0, 700, 700);
//		sc.setBounds(0, 0, 700, 700);
//		
//		test a = new test();
//		a.get().add(cc);
//		test b = new test();
//		b.get().add(ct);
//		test c = new test();
//		c.get().add(st);
//		test d = new test();
//		d.get().add(sc);
		ChineseChessBoard c = new ChineseChessBoard(true, ChessGameData.instance(), 0, 0);
		TaiwanChessBoard t = new TaiwanChessBoard(true, ChessGameData.instance(), 0, 0);
	}

}
