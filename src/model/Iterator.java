/**
 * 
 */
package model;

/**
 * @author reljicd
 * 
 */
public interface Iterator {

	public void first();

	public void next();

	public boolean isDone();

	public int currentItem();
	
	public boolean checkSolution(int[][] game, int[][] solution);

}
