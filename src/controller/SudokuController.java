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
import viewFactory.Label;

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
		Numbers.getInstance()
				.getPanel()
				.setSize(component.getParent().getWidth(),
						component.getParent().getHeight());
		Numbers.getInstance()
				.getPanel()
				.setLocation(component.getParent().getX(),
						component.getParent().getY() + 20);

		if (component instanceof Label
				&& ((Label) component).getSudokuParentContainer() instanceof Field) {
			Field field = (Field) ((Label) component)
					.getSudokuParentContainer();
			if (field != null) {
				int x = field.getFieldX();
				int y = field.getFieldY();

				game.setSelectedFieldX(x);
				game.setSelectedFieldY(y);
			}
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
