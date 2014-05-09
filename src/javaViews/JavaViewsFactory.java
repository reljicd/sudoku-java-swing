package javaViews;

import view.Frame;
import view.Label;
import view.Menu;
import view.MenuBar;
import view.MenuItem;
import view.Panel;
import view.ViewsFactory;

public class JavaViewsFactory implements ViewsFactory{

	private static ViewsFactory instance = null;
	
	public static ViewsFactory getInstance() {
		if (instance == null) {
			instance = new JavaViewsFactory();
		}
		return instance;
	}
	
	@Override
	public Frame createFrame() {
		return new JavaFrame();
	}

	@Override
	public Panel createPanel() {
		return new JavaPanel();
	}

	@Override
	public MenuBar createMenuBar() {
		return new JavaMenuBar();
	}
	
	@Override
	public Menu createMenu() {
		// TODO Auto-generated method stub
		return new JavaMenu();
	}
	
	@Override
	public MenuItem createMenuItem() {
		// TODO Auto-generated method stub
		return new JavaMenuItem();
	}

	@Override
	public Label createLabel() {
		return new JavaLabel();
	}





}
