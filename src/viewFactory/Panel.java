package viewFactory;

import java.awt.Component;
import java.awt.Point;

import controller.NumbersController;
import controller.SudokuPanelController;

public interface Panel {

	public void add(Label label);

	public void add(Panel panel);

	public void setSize(int x, int y);

	public void setLocation(int x, int y);

	public void setVisible(Boolean aFlag);

	public void addMouseListener(SudokuPanelController sudokuController);

	public Component getComponentAt(Point point);

	public void addMouseListener(NumbersController numbersController);

}
