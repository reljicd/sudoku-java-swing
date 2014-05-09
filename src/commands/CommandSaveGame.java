/**
 * 
 */
package commands;

import model.Game;

/**
 * @author Dusan
 *
 */
public class CommandSaveGame extends Command {
	
	private final String commandString = "Save Game";

	public CommandSaveGame (Game game){
		super.setGame(game);
	}

	/* (non-Javadoc)
	 * @see commands.Command#execute()
	 */
	@Override
	public void execute() {
		super.getGame().saveGame();
	}

	/* (non-Javadoc)
	 * @see commands.Command#getCommandString()
	 */
	@Override
	public String getCommandString() {
		return commandString;
	}

}
