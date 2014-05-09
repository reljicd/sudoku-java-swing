/**
 * 
 */
package view;

/**
 * @author Dusan
 *
 */
public class FieldStateCandidate implements FieldState {

	/* (non-Javadoc)
	 * @see view.FieldState#isModificable()
	 */
	@Override
	public Boolean isModifiable() {
		return true;
	}

	/* (non-Javadoc)
	 * @see view.FieldState#getTextColor()
	 */
	@Override
	public Colors getTextColor() {
		return Colors.GRAY;
	}

	/* (non-Javadoc)
	 * @see view.FieldState#getBackgroundColor()
	 */
	@Override
	public Colors getBackgroundColor() {
		return Colors.WHITE;
	}

}
