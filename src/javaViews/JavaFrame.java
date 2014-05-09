/**
 * 
 */
package javaViews;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;

import view.Frame;
import view.MenuBar;
import view.Panel;

/**
 * @author reljicd
 *
 */
public class JavaFrame extends JFrame implements Frame {
	
	private static final int dimensionX = 450;
	private static final int dimensionY = 470;
	
	/**
	 * 
	 */
	public JavaFrame() {
		super("Sudoku");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		setSize(dimensionX, dimensionY);
	}

	@Override
	public void setMenuBar(MenuBar menuBar) {
		super.setJMenuBar((JMenuBar)menuBar);
	}

	@Override
	public void add(Panel panel) {
		super.add((JavaPanel)panel , BorderLayout.CENTER);
	}

	@Override
	public void addToLayeredPane(Panel panel) {
		super.getLayeredPane().add((JavaPanel)panel,
				JLayeredPane.DEFAULT_LAYER);		
	}

	@Override
	public void setResizable(Boolean aFlag) {
		super.setResizable(aFlag);
	}

	@Override
	public void setVisible(Boolean aFlag) {
		super.setVisible(aFlag);
	}
	
	

}
