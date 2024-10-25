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

    private int[][] grid; 
    
    public SudokuGame() {
        grid = new int[9][9]; 
    }
    
    @Override
    public void initializeGrid() {
        grid[0][0] = 5; grid[0][1] = 3; grid[0][4] = 7;
        grid[1][0] = 6; grid[1][3] = 1; grid[1][4] = 9;
        grid[1][5] = 5; grid[2][1] = 9; grid[2][2] = 8;
        grid[2][7] = 6;
    }

    @Override
    public void setCell(int row, int col, int value) {
        if (row >= 0 && row < 9 && col >= 0 && col < 9 && value >= 1 && value <= 9) {
            grid[row][col] = value;
        } else {
            System.out.println("no valido");
        }
    }

    @Override
    public int getCell(int row, int col) {
        if (row >= 0 && row < 9 && col >= 0 && col < 9) {
            return grid[row][col];
        } else {
            System.out.println("no valido.");
            return -1;
        }
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
