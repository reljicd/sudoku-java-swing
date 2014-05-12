/**
 * 
 */
package model;

/**
 * @author reljicd
 *
 */
public class IteratorRow implements Iterator {
	
	private int row;
	private int currentItem;
	private boolean isDone;
	
	public IteratorRow(int row){
		this.row = row;
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
		for (int x = 0; x < 9; x++) {
			if (game[row][x] == 0 || game[row][x] != solution[row][x]) solved = false;
		}
		return solved;
	}

}
