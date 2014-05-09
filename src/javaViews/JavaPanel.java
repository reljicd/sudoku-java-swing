/**
 * 
 */
package javaViews;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controller.NumbersController;
import controller.SudokuPanelController;
import viewFactory.Label;
import viewFactory.Panel;

/**
 * @author reljicd
 *
 */
public class JavaPanel extends JPanel implements Panel {

	/**
	 * 
	 */
	public JavaPanel() {
		super(new GridLayout(3,3));
		setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
	}
	
	@Override
	public void add (Label label){
		if(label instanceof JavaLabel) super.add((JavaLabel)label);
	}
	
	@Override
	public void add(Panel panel) {
		if(panel instanceof JavaPanel) super.add((JavaPanel)panel);
	}
	
	@Override
	public void setSize(int x, int y){
		super.setSize(x, y);
	}
	
	@Override
	public void setLocation(int x, int y){
		super.setLocation(x, y);
	}

	@Override
	public void setVisible(Boolean aFlag) {
		super.setVisible(aFlag);
	}

	@Override
	public void addMouseListener(SudokuPanelController sudokuController) {
		super.addMouseListener(sudokuController);		
	}

	@Override
	public Component getComponentAt(Point point){
		return super.getComponentAt(point);
	}

	@Override
	public void addMouseListener(NumbersController numbersController) {
		// TODO Auto-generated method stub
		super.addMouseListener(numbersController);
	}
	
}
