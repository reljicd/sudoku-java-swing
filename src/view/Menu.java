package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.MenuController;

public class Menu extends JMenuBar {

	JMenu menu;
	JMenuItem newGameItem, saveGameItem, undoItem, exitItem;

	public Menu() {

		// Create the menu bar.
		super();

		// Build the first menu.
		menu = new JMenu("Options");
		add(menu);

		// a group of JMenuItems
		newGameItem = new JMenuItem("New Game");
		menu.add(newGameItem);

		saveGameItem = new JMenuItem("Save Game");
		menu.add(saveGameItem);

		undoItem = new JMenuItem("Undo");
		menu.add(undoItem);

		// a group of JMenuItems
		exitItem = new JMenuItem("Exit");
		add(exitItem);
	}

	public void setController(MenuController menuController) {
		newGameItem.addActionListener(menuController);
		saveGameItem.addActionListener(menuController);
		undoItem.addActionListener(menuController);
		exitItem.addActionListener(menuController);
	}

}
