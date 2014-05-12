package view;

import javaViews.JavaViewsFactory;
import model.Game;
import viewFactory.Frame;
import viewFactory.Menu;
import viewFactory.MenuBar;
import viewFactory.MenuItem;
import viewFactory.ViewsFactory;

import commands.CommandExit;
import commands.CommandNewGame;
import commands.CommandSaveGame;
import commands.CommandUndoGame;

import controller.MenuController;
import controller.NumbersController;
import controller.SudokuPanelController;

public class Sudoku {

	private Frame frame;

	private Game game;
	private SudokuPanel sudokuPanel;
	private SudokuPanelController sudokuPanelController;
	private MenuController menuController;
	private NumbersController numbersController;
	// Here you can choose concrete implementation (Android or Java)
	private static ViewsFactory viewsFactory = JavaViewsFactory.getInstance();

	private Sudoku() {
		// Create and set up the window.
		frame = viewsFactory.createFrame();

		game = new Game();
		sudokuPanel = new SudokuPanel();
		sudokuPanelController = new SudokuPanelController(sudokuPanel, game);
		menuController = new MenuController(game);
		numbersController = new NumbersController(game);

		sudokuPanel.initializeWithGame(game);
		sudokuPanel.setController(sudokuPanelController);
		frame.add(sudokuPanel.getPanel());

		frame.addToLayeredPane(Numbers.getInstance().getPanel());
		Numbers.getInstance().getPanel().setVisible(false);
		Numbers.getInstance().getPanel().addMouseListener(numbersController);

		/*
		 * Create and set up the menu
		 */
		MenuBar menuBar = Sudoku.getViewsFactory().createMenuBar();
		// Build the first menu.
		Menu menu = Sudoku.getViewsFactory().createMenu();
		menu.setText("Options");
		menuBar.addMenu(menu);
		// New Game
		MenuItem newGameMenuItem = Sudoku.getViewsFactory().createMenuItem();
		newGameMenuItem.addActionListener(menuController);
		newGameMenuItem.setCommand(new CommandNewGame(game));
		menu.addMenuItem(newGameMenuItem);
		// Save Game
		MenuItem saveGameMenuItem = Sudoku.getViewsFactory().createMenuItem();
		saveGameMenuItem.addActionListener(menuController);
		saveGameMenuItem.setCommand(new CommandSaveGame(game));
		menu.addMenuItem(saveGameMenuItem);
		// Undo Game
		MenuItem undoGamemenuItem = Sudoku.getViewsFactory().createMenuItem();
		undoGamemenuItem.addActionListener(menuController);
		undoGamemenuItem.setCommand(new CommandUndoGame(game));
		menu.addMenuItem(undoGamemenuItem);
		// Exit
		MenuItem exitItem = Sudoku.getViewsFactory().createMenuItem();
		exitItem.addActionListener(menuController);
		exitItem.setCommand(new CommandExit());
		menuBar.addMenuItem(exitItem);
		
		frame.setMenuBar(menuBar);

		game.addObserver(sudokuPanelController);

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
