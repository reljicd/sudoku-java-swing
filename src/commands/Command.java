/**
 * 
 */
package commands;

import model.Game;

/**
 * @author Dusan
 *
 */
public abstract class Command {
	
	private Game game;
	
	protected void setGame(Game game){
		this.game = game;
	}
	
	protected Game getGame(){
		return game;
	}
	
	public abstract void execute();
	public abstract String getCommandString();

}
