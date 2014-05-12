/**
 * 
 */
package model;

/**
 * @author reljicd
 *
 */
public class IteratorColumn implements Iterator {
	
	private int column;
	private int currentItem;
	private boolean isDone;
	
	public IteratorColumn(int column){
		this.column = column;
	}

	/* (non-Javadoc)
	 * @see model.Iterator#first()
	 */
	@Override
	public void first() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see model.Iterator#next()
	 */
	@Override
	public void next() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see model.Iterator#isDone()
	 */
	@Override
	public boolean isDone() {
		return isDone;
	}

	/* (non-Javadoc)
	 * @see model.Iterator#currentItem()
	 */
	@Override
	public int currentItem() {
		return currentItem;
	}

	@Override
	public boolean checkSolution(int[][] game, int[][] solution) {
		boolean solved = true;
		for (int y = 0; y < 9; y++) {
			if (game[y][column] == 0 || game[y][column] != solution[y][column]) solved = false;
		}
		return solved;
	}

}
