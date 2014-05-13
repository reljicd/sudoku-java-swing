package model;

import java.util.Stack;

public class GameHistory {

	private Stack<int[][]> history;

	public GameHistory() {
		history = new Stack<int[][]>();
	}

	public void addState(int[][] game) {
		history.push(game);
	}

	public int[][] getLastState() {
		if (!history.isEmpty())
			return history.pop();
		else
			return null;
	}

}
