package view;

import viewFactory.Panel;
import model.Game;
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
	}

	public void setNumber(Game game) {
		fields[game.getSelectedRow()][game.getSelectedColumn()].setNumber(
				game.getSelectedNumber());
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

	public Panel getPanel() {
		return panel;
	}

	public void solvedRow(int row) {
		for (int x = 0; x < 9; x++) {
			fields[row][x].setSolved();
		}
	}

	public void solvedColumn(int column) {
		for (int y = 0; y < 9; y++) {
			fields[y][column].setSolved();
		}
	}

	public void solvedSquare(int row, int column) {
		int squareFirstRow = (row/3)*3;
		int squareFirstColumn = (column/3)*3;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++)
				fields[squareFirstRow + y][squareFirstColumn + x].setSolved();
		}
	}
}
