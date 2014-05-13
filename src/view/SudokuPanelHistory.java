/**
 * 
 */
package view;

import java.util.Stack;

/**
 * @author Dusan
 *
 */
public class SudokuPanelHistory {
	
	private Stack<FieldStates[][]> history;
	
	public SudokuPanelHistory(){
		history = new Stack<FieldStates[][]>();
	}
	
	public void addState(FieldStates[][] sudokuPanel){
		history.push(sudokuPanel);
	}
	
	public FieldStates[][] getLastState(){
		if (!history.isEmpty()) return history.pop();
		else return null;
	}

}
