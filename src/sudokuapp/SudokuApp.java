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
        // Crear una instancia del juego
        SudokuGame game = new SudokuGame();
        
        // Inicializar el tablero del juego
        game.initializeGrid();
        
        // Crear e iniciar la interfaz gráfica
        SudokuGUI gui = new SudokuGUI(game);
    }
    
}
