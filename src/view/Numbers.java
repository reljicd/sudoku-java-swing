package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Numbers extends JPanel {

	private static Numbers instance = null;

	private Field[][] fields; // Array of fields.

	private Numbers() {
		super(new GridLayout(3, 3));
		setSize(200, 200);
		setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        fields = new Field[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                fields[y][x] = new Field(x, y);
                fields[y][x].setText(String.valueOf((x+1)*(y+1)));
                add(fields[y][x]);
            }
        }
	}

	public static Numbers getInstance() {
		if (instance == null) {
			instance = new Numbers();
		}
		return instance;
	}

}
