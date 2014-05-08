package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import model.Game;
import controller.MenuController;
import controller.NumbersController;
import controller.SudokuController;

public class Sudoku extends JFrame {

	private Game game;
	private SudokuPanel sudokuPanel;
	private SudokuController sudokuController;
	private MenuController menuController;
	private NumbersController numbersController;
	private Menu menu;

	public Sudoku() {
		// Create and set up the window.
		super("Sudoku");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());

		game = new Game();
		sudokuPanel = new SudokuPanel();
		sudokuController = new SudokuController(sudokuPanel, game);
		menuController = new MenuController(game);
		numbersController = new NumbersController(game);

		sudokuPanel.setGame(game);
		sudokuPanel.setController(sudokuController);
		add(sudokuPanel, BorderLayout.CENTER);

		getLayeredPane().add(Numbers.getInstance(), JLayeredPane.DEFAULT_LAYER);
		Numbers.getInstance().setVisible(false);
		Numbers.getInstance().addMouseListener(numbersController);

		menu = new Menu();
		setJMenuBar(menu);
		menu.setController(menuController);

		game.addObserver(sudokuController);

		setSize(450, 450);
		setLocationRelativeTo(null);
		setVisible(true);
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
