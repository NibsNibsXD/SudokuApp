/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sudokuapp;

/**
 *
 * @author Jorge Aguirre
 */
public class SudokuApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SudokuGame game = new SudokuGame();
        game.initializeGrid();
        SudokuGUI gui = new SudokuGUI(game);
    }
    
}
