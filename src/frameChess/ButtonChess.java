package frameChess;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import chess.Chess;
import controlUnit.LocationMap;

public class ButtonChess extends JButton {
	private Chess chess = null;

	public ButtonChess(String btnName, Chess chess, LocationMap locationMap, int whichGame) {
		// TODO Auto-generated constructor stub
		super(btnName);
		Font f = new Font(chess.getChineseName(), Font.ROMAN_BASELINE, 15);
		this.chess = chess;
		setFont(f);
		if (chess.getColor() == 0) {
			setForeground(Color.red);
		}
		if (whichGame == 1) {
			setLocation(locationMap.getChineseLocationMap()[chess.getY()][chess.getX()].getY(), locationMap.getChineseLocationMap()[chess.getY()][chess.getX()].getX());
		} else {
			setLocation(locationMap.getTaiwaneseLocationMap()[chess.getY()][chess.getX()].getY(), locationMap.getTaiwaneseLocationMap()[chess.getY()][chess.getX()].getX());
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
