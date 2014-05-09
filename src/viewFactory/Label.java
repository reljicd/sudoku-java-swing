package viewFactory;

import view.Colors;

public interface Label {
	
	public void setText(String text);
	public String getText();
	public void setForeground(Colors color);
	public void setBackground(Colors color);
	public void setSudokuParentContainer(Object container);
	public Object getSudokuParentContainer();

}
