package p0_recursiveAlgorithms;

import java.util.HashSet;

public class p06_8QueensPuzzle {
	final static int size = 8;
	static boolean[][] chessboard = new boolean[size][size];
	static HashSet<Integer> attackedCol = new HashSet<Integer>();
	static HashSet<Integer> attackedRow = new HashSet<Integer>();
	static HashSet<Integer> attackedLeftDiagonal = new HashSet<Integer>();
	static HashSet<Integer> attackedRightDiagonal = new HashSet<Integer>();

	public static void main(String[] args) {
		putQueens(0);
	}

	private static void putQueens(int row) {
		if (row == size) {
			print(chessboard);
		} else {
			for (int col = 0; col < size; col++) {
				if (canPlaceQueen(row, col)) {
					markAllAttackedPositions(col, row);
					putQueens(row + 1);
					unmarkAllAttackedPositions(col, row);
				}
			}
		}
	}

	static boolean canPlaceQueen(int row, int col) {
		if (attackedCol.contains(col) || attackedRow.contains(row) || attackedLeftDiagonal.contains(col - row)
				|| attackedRightDiagonal.contains(col + row)) {
			return false;
		}
		return true;
	}

	private static void print(boolean[][] arr) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (arr[i][j] == true) {
					System.out.print("*" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void markAllAttackedPositions(int col, int row) {
		attackedCol.add(col);
		attackedRow.add(row);
		attackedLeftDiagonal.add(col - row);
		attackedRightDiagonal.add(col + row);
		chessboard[row][col] = true;
	}

	private static void unmarkAllAttackedPositions(int col, int row) {
		attackedCol.remove(col);
		attackedRow.remove(row);
		attackedLeftDiagonal.remove(col - row);
		attackedRightDiagonal.remove(col + row);
		chessboard[row][col] = false;
	}

}