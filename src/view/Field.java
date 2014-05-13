package view;

import viewFactory.Label;

/**
 * This class represents a field on the SudokuPanel.
 * 
 * @author Dusan Reljic
 */
public class Field {
	private int x; // X position in game.
	private int y; // Y position in game.
	private Label label;

	/*
	 * Possible states of the Field
	 */
	private FieldState state;
	private FieldStateEmpty emptyState = new FieldStateEmpty();
	private FieldStateComputerGenerated computerGeneratedState = new FieldStateComputerGenerated();
	private FieldStateCandidate candidateState = new FieldStateCandidate();
	private FieldStateSolved solvedState = new FieldStateSolved();

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

		setState(emptyState);

		this.x = x;
		this.y = y;
	}

	private void setState(FieldState state) {
		this.state = state;
	}

	public void initialize(int number) {
		setState(number > 0 ? computerGeneratedState : emptyState);
		label.setText(number > 0 ? number + "" : "");
		updateLabel();
	}

	/**
	 * Sets number and foreground color according to userInput.
	 * 
	 * @param number
	 *            Number to be set.
	 */
	public void setNumber(int number) {
		if (state.isModifiable()) {
			setState(number > 0 ? candidateState : emptyState);
			label.setText(number > 0 ? number + "" : "");
			updateLabel();
		}
	}

	public FieldStates getState() {
		if (state == emptyState)
			return FieldStates.EMPTY;
		else if (state == computerGeneratedState)
			return FieldStates.COMPUTER_GENERATED;
		else if (state == candidateState)
			return FieldStates.CANDIDATE;
		else if (state == solvedState)
			return FieldStates.SOLVED;
		else
			return FieldStates.EMPTY;
	}

	public void setState(FieldStates state) {
		switch (state) {
		case EMPTY:
			setState(emptyState);
			updateLabel();
			break;
		case COMPUTER_GENERATED:
			setState(computerGeneratedState);
			updateLabel();
			break;
		case CANDIDATE:
			setState(candidateState);
			updateLabel();
			break;
		case SOLVED:
			setState(solvedState);
			updateLabel();
			break;
		}

	}

	public boolean isModifiable() {
		return state.isModifiable();
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

	public Label getLabel() {
		return label;
	}

	private void updateLabel() {
		label.setForeground(state.getTextColor());
		label.setBackground(state.getBackgroundColor());
	}
}
