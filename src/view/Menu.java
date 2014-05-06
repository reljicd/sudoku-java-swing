package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.MenuController;
import model.UpdateAction;

public class Menu implements Observer{
	
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem newGameItem, saveGameItem, undoItem, exitItem;
 
    public JMenuBar createMenuBar() {
 
        //Create the menu bar.
        menuBar = new JMenuBar();
 
        //Build the first menu.
        menu = new JMenu("Options");
        menuBar.add(menu);
 
        //a group of JMenuItems
        newGameItem = new JMenuItem("New Game");
        menu.add(newGameItem);
        
        saveGameItem = new JMenuItem("Save Game");
        menu.add(saveGameItem);

        undoItem = new JMenuItem("Undo");
        menu.add(undoItem);
        
        //a group of JMenuItems
        exitItem = new JMenuItem("Exit");
        menuBar.add(exitItem);
 
        return menuBar;
    }

	@Override
	public void update(Observable o, Object arg) {
        switch ((UpdateAction)arg) {
            case NEW_GAME:
        }		
	}
	
	public void setController(MenuController menuController){
		newGameItem.addActionListener(menuController);
		saveGameItem.addActionListener(menuController);
		undoItem.addActionListener(menuController);
		exitItem.addActionListener(menuController);
	}

}
