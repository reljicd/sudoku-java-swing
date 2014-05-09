package javaViews;

import view.Frame;
import view.Label;
import view.MenuBar;
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
	public Label createLabel() {
		return new JavaLabel();
	}

}
