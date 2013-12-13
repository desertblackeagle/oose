package chessGame.data;

import javax.swing.ImageIcon;

public class ConfigData {
	private String playerNameP1 = "Player1";
	private String playerNameP2 = "Player2";
	private ImageIcon imgP1 = new ImageIcon("C:\\Users\\rose\\Dropbox\\JavaWorspace\\OOSE1\\src\\rose.jpg");
	private ImageIcon imgP2 = new ImageIcon("C:\\Users\\rose\\Dropbox\\JavaWorspace\\OOSE1\\src\\rose.jpg");
	private boolean boardStraight = true; // true is Straight
	private boolean autoSave = true;

	public String getPlayerNameP1() {
		return playerNameP1;
	}

	public void setPlayerNameP1(String playerNameP1) {
		this.playerNameP1 = playerNameP1;
	}

	public String getPlayerNameP2() {
		return playerNameP2;
	}

	public void setPlayerNameP2(String playerNameP2) {
		this.playerNameP2 = playerNameP2;
	}

	public ImageIcon getImgP1() {
		return imgP1;
	}

	public void setImgP1(ImageIcon imgP1) {
		this.imgP1 = imgP1;
	}

	public ImageIcon getImgP2() {
		return imgP2;
	}

	public void setImgP2(ImageIcon imgP2) {
		this.imgP2 = imgP2;
	}

	public boolean isBoardStraight() {
		return boardStraight;
	}

	public void setBoardDirection(boolean boardStraight) {
		this.boardStraight = boardStraight;
	}

	public boolean isAutoSave() {
		return autoSave;
	}

	public void setAutoSave(boolean autoSave) {
		this.autoSave = autoSave;
	}

}
