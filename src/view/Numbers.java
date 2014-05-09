package view;

import viewFactory.Panel;

public class Numbers {

	private static Numbers instance = null;
	private Panel panel;

	private Field[][] fields; // Array of fields.

	private Numbers() {
		panel = Sudoku.getViewsFactory().createPanel();
		panel.setSize(150, 150);

		fields = new Field[3][3];
		int counter = 1;
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				fields[y][x] = new Field(x, y);
				fields[y][x].initialize(counter++);
				panel.add(fields[y][x].getLabel());
			}
		}
	}

	public static Numbers getInstance() {
		if (instance == null) {
			instance = new Numbers();
		}
		return instance;
	}

	public Panel getPanel() {
		return panel;
	}

	public void setVisible(Boolean aFlag) {
		panel.setVisible(aFlag);
	}

}
