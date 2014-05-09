/**
 * 
 */
package javaViews;

import javax.swing.JMenu;

import viewFactory.Menu;
import viewFactory.MenuItem;

/**
 * @author reljicd
 *
 */
public class JavaMenu extends JMenu implements Menu {
	
	/**
	 * 
	 */
	public JavaMenu() {
		super();
	}
	
	@Override
	public void setText(String text){
		super.setText(text);
	}
	
	@Override
	public void addMenuItem(MenuItem menuItem) {
		super.add((JavaMenuItem) menuItem);
	}

}
