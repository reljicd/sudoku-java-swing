package view;

import java.awt.BorderLayout;

import javaViews.JavaViewsFactory;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import model.Game;
import controller.MenuController;
import controller.NumbersController;
import controller.SudokuController;

public class Sudoku extends JFrame {
	
	private static final int dimensionX = 450;
	private static final int dimensionY = 470;

	private Game game;
	private SudokuPanel sudokuPanel;
	private SudokuController sudokuController;
	private MenuController menuController;
	private NumbersController numbersController;
	private Menu menu;
	// Here you can choose concrete implementation (Android or Java)
	private static ViewsFactory viewsFactory = JavaViewsFactory.getInstance();

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

		setSize(dimensionX, dimensionY);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static ViewsFactory getViewsFactory(){
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
