package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu {
 
    public JMenuBar createMenuBar() {
    	
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
 
        //Create the menu bar.
        menuBar = new JMenuBar();
 
        //Build the first menu.
        menu = new JMenu("Options");
        menuBar.add(menu);
 
        //a group of JMenuItems
        menuItem = new JMenuItem("New Game");
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Save Game");
        menu.add(menuItem);

        menuItem = new JMenuItem("Undo");
        menu.add(menuItem);
        
        //a group of JMenuItems
        menuItem = new JMenuItem("Exit");
        menuBar.add(menuItem);
 
        return menuBar;
    }

}
