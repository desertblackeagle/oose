package Chess;

/* @author Red Rose
 * Function:a manager to control board
 * @ version 1.1
 * Last Update:2013/10/18
 */

public class BoardManager {

	final static int turnRed = 1;
	final static int turnBlack = 0;

	int forWhoToChess = 1;
	int whichGame = 1; // chinese chess = 1 ; taiwanese chess = 0;

	Chess[][] chineseChessLocationList = new Chess[10][9];

	public void moveTo(Chess chess, int toX, int toY) {
		// (move chess to position)
		if (canMove(chess, toX, toY)) {
			if (haveTarget(toX, toY)) {
				eatChess(chess, toX, toY);
			} else {
				chineseChessLocationList[toX][toY] = chineseChessLocationList[chess.getX()][chess.getY()];
				chineseChessLocationList[chess.getX()][chess.getY()] = null;
			}
		} else {
			// (move back)
		}
	}

	private boolean canMove(Chess chess, int toX, int toY) {
		return chess.moveRule();
	}

	private boolean haveTarget(int toX, int toY) {
		if (chineseChessLocationList[toX][toY] == null) {
			return false;
		} else {
			return true;
		}
	}

	// only for taiwanese use
	private boolean canEat() {

		return true;
	}

	private void eatChess(Chess chess, int toX, int toY) {
		// the chess from chessLocationList1[toX][toY] been set location to out of board
		chineseChessLocationList[toX][toY] = chineseChessLocationList[chess.getX()][chess.getY()];
		chineseChessLocationList[chess.getX()][chess.getY()] = null;
	}

	public void printChess() {
		System.out.println();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (this.chineseChessLocationList[i][j] == null) {
					System.out.printf("%7s", "null");
				} else {
					System.out.printf("%7s", this.chineseChessLocationList[i][j].getName());
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println();
	}
}
