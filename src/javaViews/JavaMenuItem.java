/**
 * 
 */
package javaViews;

import javax.swing.JMenuItem;

import controller.MenuController;
import viewFactory.MenuItem;

/**
 * @author reljicd
 * 
 */
public class JavaMenuItem extends JMenuItem implements MenuItem {
	
	/**
	 * 
	 */
	public JavaMenuItem() {
		super();
	}
	
	@Override
	public void setText(String text){
		super.setText(text);
	}

	@Override
	public void addActionListener(MenuController menuController) {
		super.addActionListener(menuController);
	}

}
