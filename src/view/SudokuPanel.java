package view;

import model.Game;
import viewFactory.Panel;
import controller.SudokuPanelController;

/**
 * This class draws the sudoku panel and reacts to updates from the model.
 * 
 * @author Dusan Reljic
 */
public class SudokuPanel {
	private Panel panel;
	private Field[][] fields; // Array of fields.
	private Panel[][] panels; // Panels holding the fields.
	private SudokuPanelHistory history = new SudokuPanelHistory();

	/**
	 * Constructs the panel, adds sub panels and adds fields to these sub
	 * panels.
	 */
	public SudokuPanel() {
		panel = Sudoku.getViewsFactory().createPanel();

		panels = new Panel[3][3];
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				panels[y][x] = Sudoku.getViewsFactory().createPanel();
				panel.add(panels[y][x]);
			}
		}

		fields = new Field[9][9];
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				fields[y][x] = new Field(x, y);
				panels[y / 3][x / 3].add(fields[y][x].getLabel());
			}
		}
	}

	public Panel getPanel() {
		return panel;
	}

	/**
	 * Sets the fields corresponding to given game.
	 * 
	 * @param game
	 *            Game to be set.
	 */
	public void initializeWithGame(Game game) {
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				fields[y][x].initialize(game.getNumber(x, y));
			}
		}
		addStateToHistory();
	}

	public void setCandidateNumber(Game game) {
		fields[game.getSelectedRow()][game.getSelectedColumn()].setNumber(game
				.getSelectedNumber());
		addStateToHistory();
	}

	public void solvedRow(Game game) {
		// First update the last field label with the last number
		fields[game.getSelectedRow()][game.getSelectedColumn()].setNumber(game
				.getSelectedNumber());
		// then update field states
		int row = game.getSelectedRow();
		for (int x = 0; x < 9; x++) {
			fields[row][x].setState(FieldStates.SOLVED);
		}
		addStateToHistory();
	}

	public void solvedColumn(Game game) {
		// First update the last field label with the last number
		fields[game.getSelectedRow()][game.getSelectedColumn()].setNumber(game
				.getSelectedNumber());
		// then update field states
		int column = game.getSelectedColumn();
		for (int y = 0; y < 9; y++) {
			fields[y][column].setState(FieldStates.SOLVED);
		}
		addStateToHistory();
	}

	public void solvedSquare(Game game) {
		// First update the last field label with the last number
		fields[game.getSelectedRow()][game.getSelectedColumn()].setNumber(game
				.getSelectedNumber());
		// then update field states
		int squareFirstRow = (game.getSelectedRow() / 3) * 3;
		int squareFirstColumn = (game.getSelectedColumn() / 3) * 3;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++)
				fields[squareFirstRow + y][squareFirstColumn + x]
						.setState(FieldStates.SOLVED);
		}
		addStateToHistory();
	}

	public void addStateToHistory() {
		FieldStates[][] state = new FieldStates[9][9];
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++)
				state[y][x] = fields[y][x].getState();
		}
		history.addState(state);
	}

	public void undoState() {
		/*
		 *  Go back in history 2 times
		 *  	1st time to pop the last state
		 *  	2nd time to pop the first history state
		 *  Then after the game is reverted, save it as a last state
		 */
		FieldStates[][] previousStates = history.getLastState();
		previousStates = history.getLastState();
		if (previousStates != null) {
			for (int x = 0; x < 9; x++) {
				for (int y = 0; y < 9; y++)
					fields[y][x].setState(previousStates[y][x]);
			}
		}
		addStateToHistory();
	}

	/**
	 * Adds controller to all sub panels.
	 * 
	 * @param sudokuController
	 *            Controller which controls all user actions.
	 */

	public void setController(SudokuPanelController sudokuController) {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++)
				panels[y][x].addMouseListener(sudokuController);
		}
	}
}
