/**
 * 
 */
package view;

/**
 * @author Dusan
 *
 */
public class FieldStateSolved implements FieldState {

	/* (non-Javadoc)
	 * @see view.FieldState#isModificable()
	 */
	@Override
	public Boolean isModifiable() {
		return false;
	}

	/* (non-Javadoc)
	 * @see view.FieldState#getTextColor()
	 */
	@Override
	public Colors getTextColor() {
		return Colors.BLACK;
	}

	/* (non-Javadoc)
	 * @see view.FieldState#getBackgroundColor()
	 */
	@Override
	public Colors getBackgroundColor() {
		return Colors.WHITE;
	}

}
