﻿package chessGame.frame;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import chessGame.controlUnit.GameObserver;
import chessGame.controlUnit.GameObserverable;
import chessGame.frame.dialog.FrameCheckDialog;

public abstract class FrameModel extends JFrame {

	boolean visable = true;
	private GameObserverable gobs = new GameObserverable();

	public FrameModel(boolean visable) {
		this.visable = visable;
		initFrame();
		initFrameEventListeners();
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

	public void addObserver(GameObserver o) {
		gobs.addObserver(o);
	}

	public void notifyObserver(Object o) {
		gobs.notifyObserver(o);
	}

	public static void main(String[] args) {
//		FrameModel frame = new FrameModel(true);
	}
}
