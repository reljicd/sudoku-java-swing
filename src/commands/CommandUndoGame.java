/**
 * 
 */
package commands;

import model.Game;

/**
 * @author Dusan
 *
 */
public class CommandUndoGame extends Command {
	
	private final String commandString = "Undo Game";
	
	public CommandUndoGame (Game game){
		super.setGame(game);
	}

	/* (non-Javadoc)
	 * @see commands.Command#execute()
	 */
	@Override
	public void execute() {
		super.getGame().undoGame();
	}

	@Override
	public String getCommandString() {
		return commandString;
	}

}
