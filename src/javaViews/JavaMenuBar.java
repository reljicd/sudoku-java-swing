/**
 * 
 */
package javaViews;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import viewFactory.Menu;
import viewFactory.MenuBar;
import viewFactory.MenuItem;

/**
 * @author reljicd
 * 
 */
public class JavaMenuBar extends JMenuBar implements MenuBar {

	/**
	 * 
	 */
	public JavaMenuBar() {
		// Create the menu bar.
		super();
	}

	@Override
	public void addMenu(Menu menu) {
		super.add((JMenu) menu);
	}

	@Override
	public void addMenuItem(MenuItem menuItem) {
		super.add((JavaMenuItem) menuItem);
	}
	
}
