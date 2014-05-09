/**
 * 
 */
package commands;

import model.Game;

/**
 * @author Dusan
 *
 */
public class CommandNewGame extends Command {
	
	private final String commandString = "New Game";
	
	public CommandNewGame (Game game){
		super.setGame(game);
	}

	/* (non-Javadoc)
	 * @see commands.Command#execute()
	 */
	@Override
	public void execute() {
		super.getGame().newGame();
	}

	@Override
	public String getCommandString(){
		return commandString;
	}
	
}
