/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuApp;

import SudokuApp.SudokuValidator;
import SudokuApp.SudokuValidator;

/**
 *
 * @author Jorge Aguirre
 */
public class SudokuGame extends SudokuGrid implements SudokuValidator {
    @Override
    public void initializeGrid() {
        // Inicialización del tablero
    }

    @Override
    public void setCell(int row, int col, int value) {
        // Lógica para colocar un valor
    }

    @Override
    public int getCell(int row, int col) {
        // Obtener el valor de una celda
        return 0; //0 temporal
    }

    @Override
    public boolean isValidMove(int row, int col, int value) {
        // Validar un movimiento
        //validar numero dentro de 1 y 9 y no sea letra
        //try catch
        //si el numero es correcto poner verde la casilla
        //si esta mala rojo
        return false; //false temporal

    }

    @Override
    public boolean isBoardComplete() {
        // Validar si el tablero está completo
        return false; //false temporal
    }
}
