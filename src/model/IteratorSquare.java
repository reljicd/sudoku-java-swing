/**
 * 
 */
package model;

/**
 * @author reljicd
 *
 */
public class IteratorSquare implements Iterator {
	
	private int row;
	private int column;
	private int currentItem;
	private boolean isDone;
	
	public IteratorSquare(int row, int column){
		this.row = row;
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
		int squareFirstRow = (row/3)*3;
		int squareFirstColumn = (column/3)*3;
		boolean solved = true;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++)
			if (game[squareFirstRow + y][squareFirstColumn + x] == 0 || game[squareFirstRow + y][squareFirstColumn + x] != solution[squareFirstRow + y][squareFirstColumn + x]) solved = false;
		}
		return solved;
	}

}
