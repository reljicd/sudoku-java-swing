package controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Game;
import view.Numbers;
import viewFactory.Label;

public class NumbersController implements MouseListener {

	private Game game;

	public NumbersController(Game game) {
		this.game = game;
	}

	/**
	 * Recovers if user clicked field in game. If so it sets the selected number
	 * at clicked position in game and updates clicked field. If user clicked a
	 * field and used left mouse button, number at clicked position will be
	 * cleared in game and clicked field will be updated.
	 * 
	 * @param e
	 *            MouseEvent.
	 */
	public void mousePressed(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		Component component = Numbers.getInstance().getPanel().getComponentAt(e.getPoint());

		if (component instanceof Label) {
			game.setNumber(Integer.parseInt(((Label) component).getText()));
		}

		Numbers.getInstance().setVisible(false);
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}
}
