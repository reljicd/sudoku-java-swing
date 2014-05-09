/**
 * 
 */
package javaViews;

import javax.swing.JMenuItem;

import commands.Command;

import controller.MenuController;
import viewFactory.MenuItem;

/**
 * @author reljicd
 * 
 */
public class JavaMenuItem extends JMenuItem implements MenuItem {
	
	private Command command;
	
	/**
	 * 
	 */
	public JavaMenuItem() {
		super();
	}

	@Override
	public void addActionListener(MenuController menuController) {
		super.addActionListener(menuController);
	}

	@Override
	public void setCommand(Command command) {
		this.command = command;
		super.setText(this.command.getCommandString());
	}

	@Override
	public void execute() {
		if (command != null){
			command.execute();
		}
	}

}
