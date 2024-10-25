/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudokuapp;

import java.util.Random;

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
        Random random = new Random();
        int attempts = 0;

        while (attempts < 20) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            int value = random.nextInt(9) + 1;

            if (grid[row][col] == 0 && isValidMove(row, col, value)) {
                grid[row][col] = value;
                attempts++;
            }
        }
    }
    
    
    @Override
    public void setCell(int row, int col, int value) {
    
        if (row >= 0 && row < 9 && col >= 0 && col < 9 && value >= 1 && value <= 9) {
            grid[row][col] = value;
        } else {
            System.out.println("no valido");
        }
    }
    
    
    public int getCell(int row, int col) {
        if (row >= 0 && row < 9 && col >= 0 && col < 9) {
            return grid[row][col];
        } else {
            System.out.println("no valido.");
            return -1;
        }
    }
    
    public boolean isValidMove(int row, int col, int value) {
        if (row < 0 || row >= 9 || col < 0 || col >= 9 || value < 1 || value > 9) {
            System.out.println("Posición o valor inválido.");
            return false;
        }

        // misma fila
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == value) {
                return false;
            }
        }

        // misma columna
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == value) {
                return false;
            }
        }

        //mismo 3x3
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[startRow + i][startCol + j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
    
    public boolean isBoardComplete() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int value = grid[row][col];
                if (value == 0) {
                    return false;
                }
                
                grid[row][col] = 0;
                
                if (!isValidMove(row, col, value)) {
                    
                    grid[row][col] = value;
                    return false;
                }
                
                grid[row][col] = value;
            }
        }
        // Si pasa todo es true
        return true;
    }
    
    public void clearBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                grid[row][col] = 0;
            }
        }
    }

}