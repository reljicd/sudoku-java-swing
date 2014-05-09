package view;

import viewFactory.Menu;
import viewFactory.MenuBar;
import viewFactory.MenuItem;
import controller.MenuController;

public class SudokuMenu {

	private MenuBar menuBar;
	private Menu menu;
	private MenuItem newGameItem, saveGameItem, undoItem, exitItem;

	public SudokuMenu() {
		
		menuBar = Sudoku.getViewsFactory().createMenuBar();
		
		// Build the first menu.
		menu = Sudoku.getViewsFactory().createMenu();
		menu.setText("Options");
		menuBar.addMenu(menu);

		// a group of JMenuItems
		newGameItem = Sudoku.getViewsFactory().createMenuItem();
		newGameItem.setText("New Game");
		menu.addMenuItem(newGameItem);

		saveGameItem = Sudoku.getViewsFactory().createMenuItem();
		saveGameItem.setText("Save Game");
		menu.addMenuItem(saveGameItem);

		undoItem = Sudoku.getViewsFactory().createMenuItem();
		undoItem.setText("Undo");
		menu.addMenuItem(undoItem);

		// a group of JMenuItems
		exitItem = Sudoku.getViewsFactory().createMenuItem();
		exitItem.setText("Exit");
		menuBar.addMenuItem(exitItem);
	}
	
	public MenuBar getMenuBar(){
		return menuBar;
	}

	public void setController(MenuController menuController) {
		newGameItem.addActionListener(menuController);
		saveGameItem.addActionListener(menuController);
		undoItem.addActionListener(menuController);
		exitItem.addActionListener(menuController);
	}

}
