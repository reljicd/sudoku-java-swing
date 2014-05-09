/**
 * 
 */
package view;

import controller.MenuController;

/**
 * @author reljicd
 *
 */
public interface MenuItem {
	
	public void setText(String text);

	public void addActionListener(MenuController menuController);

}
