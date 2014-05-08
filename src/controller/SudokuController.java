package controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Game;
import model.UpdateAction;
import view.Field;
import view.Numbers;
import view.SudokuPanel;

/**
 * This class controls all user actions from SudokuPanel.
 * 
 * @author Eric Beijer
 */
public class SudokuController implements MouseListener, Observer {
	private Game game; // Current Sudoku game.
	private SudokuPanel sudokuPanel;

	/**
	 * Constructor, sets game.
	 * 
	 * @param game
	 *            Game to be set.
	 */
	public SudokuController(SudokuPanel sudokuPanel, Game game) {

		this.sudokuPanel = sudokuPanel;
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
		JPanel panel = (JPanel) e.getSource();
		Component component = panel.getComponentAt(e.getPoint());
		Numbers.getInstance().setVisible(true);
		Numbers.getInstance().setLocation(
				component.getParent().getX() + e.getX() - 100,
				component.getParent().getY() + e.getY() - 100);
		if (component instanceof Field) {
			Field field = (Field) component;
			int x = field.getFieldX();
			int y = field.getFieldY();

			game.setSelectedFieldX(x);
			game.setSelectedFieldY(y);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	/**
	 * Method called when model sends update notification.
	 * 
	 * @param o
	 *            The model.
	 * @param arg
	 *            The UpdateAction.
	 */
	public void update(Observable o, Object arg) {
		switch ((UpdateAction) arg) {
		case NEW_GAME:
			sudokuPanel.setGame((Game) o);
			break;
		case CHECK:
			break;
		case SELECTED_NUMBER:
			sudokuPanel.setNumber((Game) o);
			break;
		case CANDIDATES:
		case HELP:
			break;
		}
	}
}
