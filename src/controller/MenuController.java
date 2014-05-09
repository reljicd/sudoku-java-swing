package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Game;
import viewFactory.MenuItem;

public class MenuController implements ActionListener {
	private Game game;

	/**
	 * Constructor, sets game.
	 * 
	 * @param game
	 *            Game to be set.
	 */
	public MenuController(Game game) {
		this.game = game;
	}

	/**
	 * Performs action after user pressed button.
	 * 
	 * @param e
	 *            ActionEvent.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof MenuItem) ((MenuItem)e.getSource()).execute();
	}
}
