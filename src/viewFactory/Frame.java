package viewFactory;


public interface Frame {

	public void setMenuBar(MenuBar menuBar);

	public void add(Panel panel);

	public void addToLayeredPane(Panel panel);

	public void setSize(int x, int y);

	public void setResizable(Boolean aFlag);

	public void setVisible(Boolean aFlag);

}
