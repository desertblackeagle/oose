﻿package chessGame.frame.frameOption;

import interfaceGame.FrameInterface;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import abstractGame.chessGame.AbstractFrameModel;
import chessGame.data.ChessGameData;
import chessGame.frame.dialog.FrameCheckDialog;

public class MainView extends AbstractFrameModel implements FrameInterface {

	private JButton chinaChess;
	private JButton taiwanChess;
	private JButton exit;

	public MainView(boolean visable, ChessGameData data) {
		super(visable, data);
		setTitle("主畫面");
		createButton();
	}

	public MainView(boolean visable, int locationX, int locationY, ChessGameData data) {
		super(visable, data);
		setLocation(locationX, locationY);
		setTitle("主畫面");
		createButton();
	}

	public JButton makeButton(String name) {
		return new JButton(name);
	}

	public void createButton() {
		chinaChess = makeButton("中國棋");
		taiwanChess = makeButton("暗棋");
		exit = makeButton("離開");

		chinaChess.setBounds((this.getSize().width / 2) - 125, 150, 250, 100);
		taiwanChess.setBounds((this.getSize().width / 2) - 125, 300, 250, 100);
		exit.setBounds((this.getSize().width / 2) - 125, 450, 250, 100);

		chinaChess.setFont(new Font("細明體", Font.PLAIN, 36));
		taiwanChess.setFont(new Font("細明體", Font.PLAIN, 36));
		exit.setFont(new Font("細明體", Font.PLAIN, 36));

		chinaChess.addActionListener(this);
		taiwanChess.addActionListener(this);
		exit.addActionListener(this);

		add(chinaChess);
		add(taiwanChess);
		add(exit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonName = e.getActionCommand();
		if (buttonName.equals("離開")) {
			new FrameCheckDialog(null, "請問真的要離開遊戲嗎？", null);
		} else {
			setVisible(false);
			dispose();
			new SecondView(true, data, buttonName, getLocation().x, getLocation().y);
		}
	}

//	public static void main(String[] args) {
//		new MainView(true);
//	}

}
