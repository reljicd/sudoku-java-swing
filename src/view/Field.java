package view;

import viewFactory.Label;

/**
 * This class represents a field on the SudokuPanel.
 * 
 * @author Dusan Reljic
 */
public class Field{
	private int x; // X position in game.
	private int y; // Y position in game.
	private Label label;

	/**
	 * Constructs the label and sets x and y positions in game.
	 * 
	 * @param x
	 *            X position in game.
	 * @param y
	 *            Y position in game.
	 */
	public Field(int x, int y) {
		
		label = Sudoku.getViewsFactory().createLabel();
		label.setSudokuParentContainer(this);
		
		this.x = x;
		this.y = y;
	}

	/**
	 * Sets number and foreground color according to userInput.
	 * 
	 * @param number
	 *            Number to be set.
	 * @param userInput
	 *            Boolean indicating number is user input or not.
	 */
	public void setNumber(int number, boolean userInput) {
		label.setForeground(userInput ? Colors.BLUE : Colors.BLACK);
		label.setText(number > 0 ? number + "" : "");
	}
	
	public void setBackground (Colors color){
		label.setBackground(color);
	}

	/**
	 * Returns x position in game.
	 * 
	 * @return X position in game.
	 */
	public int getFieldX() {
		return x;
	}

	/**
	 * Return y position in game.
	 * 
	 * @return Y position in game.
	 */
	public int getFieldY() {
		return y;
	}
	
	public Label getLabel(){
		return label;
	}
}
