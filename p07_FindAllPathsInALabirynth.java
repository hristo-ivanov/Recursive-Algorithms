package p0_recursiveAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class p07_FindAllPathsInALabirynth {

	static ArrayList<Character> path = new ArrayList<Character>();
	static char[][] lab;
	static boolean[][] isCellVisited;
	static int roww;
	static int column;

	public static void main(String[] args) {
		readLab();
		findPath(0, 0, 'S');
	}

	private static void findPath(int row, int col, char direction) {

		if (!isInBound(row, col)) {
			return;
		}

		path.add(direction);

		if (isExit(row, col)) {
			printSolution();
		} else {
			if (!isVisited(row, col) && isFree(row, col)) {
				mark(col, row);
				findPath(row, col + 1, 'R');
				findPath(row, col - 1, 'L');
				findPath(row + 1, col, 'D');
				findPath(row - 1, col, 'U');
				unMark(col, row);
			}
		}
		path.remove(path.size() - 1);
	}

	private static boolean isInBound(int row, int col) {
		if (row >= roww || col >= column) {
			return false;
		}

		if (row < 0 || col < 0) {
			return false;
		}
		return true;
	}

	private static void unMark(int col, int row) {
		isCellVisited[row][col] = false;

	}

	private static void mark(int col, int row) {
		isCellVisited[row][col] = true;
	}

	private static boolean isFree(int row, int col) {
		if (lab[row][col] == '*') {
			return false;
		}
		return true;
	}

	private static boolean isVisited(int row, int col) {
		if (isCellVisited[row][col] == true) {
			return true;
		}
		return false;
	}

	private static boolean isExit(int row, int col) {
		if (lab[row][col] == 'e') {
			return true;
		}
		return false;
	}

	private static void printSolution() {
		for (int i = 1; i < path.size(); i++) {
			System.out.print(path.get(i));
		}
		System.out.println();
	}

	private static void readLab() {
		Scanner console = new Scanner(System.in);
		roww = Integer.parseInt(console.nextLine());
		column = Integer.parseInt(console.nextLine());
		lab = new char[roww][column];
		isCellVisited = new boolean[roww][column];

		for (int i = 0; i < roww; i++) {
			String line = console.nextLine();
			char[] symbols = line.toCharArray();
			for (int j = 0; j < line.length(); j++) {
				lab[i][j] = symbols[j];
			}
		}

		console.close();
	}

}