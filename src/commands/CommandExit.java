/**
 * 
 */
package commands;

/**
 * @author Dusan
 *
 */
public class CommandExit extends Command {
	
	private final String commandString = "Exit";

	/* (non-Javadoc)
	 * @see commands.Command#execute()
	 */
	@Override
	public void execute() {
		System.exit(0);
	}
	
	@Override
	public String getCommandString(){
		return commandString;
	}

}
