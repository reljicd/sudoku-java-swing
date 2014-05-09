package view;

import javaViews.JavaViewsFactory;
import model.Game;
import controller.MenuController;
import controller.NumbersController;
import controller.SudokuController;

public class Sudoku {

	private Frame frame;

	private Game game;
	private SudokuPanel sudokuPanel;
	private SudokuController sudokuController;
	private MenuController menuController;
	private NumbersController numbersController;
	private SudokuMenu sudokuMenu;
	// Here you can choose concrete implementation (Android or Java)
	private static ViewsFactory viewsFactory = JavaViewsFactory.getInstance();

	public Sudoku() {
		// Create and set up the window.
		frame = viewsFactory.createFrame();

		game = new Game();
		sudokuPanel = new SudokuPanel();
		sudokuController = new SudokuController(sudokuPanel, game);
		menuController = new MenuController(game);
		numbersController = new NumbersController(game);

		sudokuPanel.setGame(game);
		sudokuPanel.setController(sudokuController);
		frame.add(sudokuPanel.getPanel());

		frame.addToLayeredPane(Numbers.getInstance().getPanel());
		Numbers.getInstance().getPanel().setVisible(false);
		Numbers.getInstance().getPanel().addMouseListener(numbersController);

		sudokuMenu = new SudokuMenu();
		frame.setMenuBar(sudokuMenu.getMenuBar());
		sudokuMenu.setController(menuController);

		game.addObserver(sudokuController);

		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static ViewsFactory getViewsFactory() {
		return viewsFactory;
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Sudoku();
			}
		});
	}

}
