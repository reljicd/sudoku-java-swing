/**
 * 
 */
package viewFactory;

import commands.Command;

import controller.MenuController;

/**
 * @author reljicd
 *
 */
public interface MenuItem {
	
	public void addActionListener(MenuController menuController);
	
	public void setCommand(Command command);
	
	public void execute();

}
