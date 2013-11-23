package frameChess;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import chess.Chess;
import controlUnit.LocationMap;

public class ButtonChess extends JButton {
	static final int chinessChess = 1;
	static final int taiwanChess = 0;
	static final int red = 0;
	static final int black = 1;
	
	private Chess chess = null;
	
	public ButtonChess(Chess chess, LocationMap locationMap, int whichGame) {
		// TODO Auto-generated constructor stub
		super(chess.getChineseName());
		Font f = new Font(chess.getChineseName(), Font.ROMAN_BASELINE, 15);
		this.chess = chess;
		setFont(f);
		if (chess.getColor() == red) {
			setForeground(Color.red);
		}
		if (whichGame == chinessChess) {
			setLocation(locationMap.getChineseLocationMap()[chess.getY()][chess.getX()].getX(), locationMap.getChineseLocationMap()[chess.getY()][chess.getX()].getY());
		} else {
			setLocation(locationMap.getTaiwaneseLocationMap()[chess.getY()][chess.getX()].getX(), locationMap.getTaiwaneseLocationMap()[chess.getY()][chess.getX()].getY());
		}

		setSize(50, 50);
	}

	public JButton getBtn() {
		return this;
	}

	public Chess getChess() {
		return chess;
	}
}
