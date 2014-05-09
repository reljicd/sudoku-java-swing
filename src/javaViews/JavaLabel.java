/**
 * 
 */
package javaViews;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import view.Colors;
import viewFactory.Label;

/**
 * @author reljicd
 * 
 */
public class JavaLabel extends JLabel implements Label {

	private Object sudokuParentContainer = null;

	/**
	 * 
	 */
	public JavaLabel() {
		super("", CENTER);

		setPreferredSize(new Dimension(40, 40));
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
		setOpaque(true);
	}

	public void setText(String text) {
		super.setText(text);
	}

	public String getText() {
		return super.getText();
	}

	public void setForeground(Colors color) {
		switch (color) {
		case BLUE:
			super.setForeground(Color.BLUE);
			break;
		case BLACK:
			super.setForeground(Color.BLACK);
			break;
		case WHITE:
		}
	}

	public void setBackground(Colors color) {
		switch (color) {
		case WHITE:
			super.setBackground(Color.WHITE);
			break;
		case BLUE:
		case BLACK:
		}
	}

	@Override
	public void setSudokuParentContainer(Object container) {
		sudokuParentContainer = container;
	}

	@Override
	public Object getSudokuParentContainer() {
		return sudokuParentContainer;
	}

}
