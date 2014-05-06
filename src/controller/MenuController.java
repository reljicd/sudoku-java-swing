package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import model.Game;

public class MenuController implements ActionListener {
    private Game game;
 
    /**
     * Constructor, sets game.
     *
     * @param game  Game to be set.
     */
    public MenuController(Game game) {
        this.game = game;
    }
 
    /**
     * Performs action after user pressed button.
     *
     * @param e ActionEvent.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New Game"))
            game.newGame();
        else if (e.getActionCommand().equals("Save Game"))
            game.checkGame();
        else if (e.getActionCommand().equals("Undo"))
            System.exit(0);
        else if (e.getActionCommand().equals("Exit"))
            game.setHelp(((JCheckBox)e.getSource()).isSelected());
        else
            game.setSelectedNumber(Integer.parseInt(e.getActionCommand()));
    }
}
