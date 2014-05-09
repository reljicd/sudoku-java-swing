/**
 * 
 */
package view;

/**
 * @author reljicd
 *
 */
public class FieldStateEmpty implements FieldState {

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
		return Colors.WHITE;
	}

	/* (non-Javadoc)
	 * @see view.FieldState#getBackgroundColor()
	 */
	@Override
	public Colors getBackgroundColor() {
		return Colors.WHITE;
	}

}
