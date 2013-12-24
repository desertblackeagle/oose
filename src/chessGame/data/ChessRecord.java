package chessGame.data;

import java.io.Serializable;
import java.util.Stack;

import chessGame.data.te.RecordInterface;
import chessGame.frame.Chess;

public class ChessRecord implements RecordInterface, Serializable {
	private Stack<String> recordStack;
	private Stack<Chess[][]> listRecord;

	public ChessRecord() {
		// TODO Auto-generated constructor stub
		recordStack = new Stack<String>();
		listRecord = new Stack<Chess[][]>();
	}

	public Stack<String> getRecordStack() {
		return recordStack;
	}

	public Chess[][] takeOneChess() {
		if (listRecord.size() <= 2) {
			return null;
		} else {
			return listRecord.pop();
		}
	}

	public void clear() {
		recordStack.clear();
		listRecord.clear();
	}

	public void printRecord() {
		for (String s : recordStack) {
			System.out.println(s);
		}
	}

	public void printListRecord(int w) {
		for (int i = 0; i < listRecord.size(); i++) {
			System.out.println(i);
			if (w == 1) {
				for (int z = 0; z < 10; z++) {
					for (int j = 0; j < 9; j++) {
						if (listRecord.get(i)[z][j] != null) {
							System.out.printf("%8s", listRecord.get(i)[z][j].getName());
						} else {
							System.out.printf("%8s", "null");
						}
					}
					System.out.println();
				}
			} else {
				for (int z = 0; z < 4; z++) {
					for (int j = 0; j < 8; j++) {
						if (listRecord.get(i)[z][j] != null) {
							System.out.printf("%8s", listRecord.get(i)[z][j].getName());
						} else {
							System.out.printf("%8s", "null");
						}

					}
					System.out.println();
				}
			}
		}
	}

	public void recordList(Chess[][] recordList, int w) {
		listRecord.add(recordList);
		System.out.print("588888888 start\n");
		printListRecord(w);
		System.out.print("588888888 end\n");
	}

	public void record(String record) {
		recordStack.add(record);
	}

	public Stack<Chess[][]> getListRecord() {
		return listRecord;
	}

	public String recordToString() {
		String ss = "";
		for (String s : recordStack) {
			if (ss.equals("")) {
				ss = s;
			} else {
				ss = ss + "\n" + s;
			}
		}
		return ss;
	}

	public void setRecordStack(Stack<String> recordStack) {
		this.recordStack = recordStack;
	}
}
