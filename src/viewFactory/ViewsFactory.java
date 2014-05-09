package viewFactory;


public interface ViewsFactory {

	public Frame createFrame();

	public Panel createPanel();

	public MenuBar createMenuBar();
	
	public Menu createMenu();

	public MenuItem createMenuItem();

	public Label createLabel();

}
