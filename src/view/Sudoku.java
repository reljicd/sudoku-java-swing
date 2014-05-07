package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Game;
import controller.SudokuController;

public class Sudoku {
	
    private static Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
        
        Game game = new Game();
        
        SudokuPanel sudokuPanel = new SudokuPanel();
        SudokuController sudokuController = new SudokuController(sudokuPanel, game);
        sudokuPanel.setGame(game);
        sudokuPanel.setController(sudokuController);
        contentPane.add(sudokuPanel, BorderLayout.CENTER);
 
        return contentPane;
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Sudoku");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        Menu demo = new Menu();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(createContentPane());
 
        //Display the window.
        frame.setSize(450, 450);
        frame.setVisible(true);
    }
    
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
