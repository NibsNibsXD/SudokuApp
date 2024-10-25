/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudokuapp;

/**
 *
 * @author Jorge Aguirre
 */
public class SudokuGame extends SudokuGrid implements SudokuValidator {
    private int[][] grid; 
    
    public SudokuGame() {
        grid = new int[9][9]; 
    }
    
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
            // Si la celda está vacía, el tablero no está completo
            if (value == 0) {
                return false;
            }
            // Temporalmente vacía la celda para comprobar la validez del valor
            grid[row][col] = 0;
            // Comprueba si el valor es válido en su posición actual
            if (!isValidMove(row, col, value)) {
                // Restaura el valor original si no es válido
                grid[row][col] = value;
                return false;
            }
            // Restaura el valor original si es válido
            grid[row][col] = value;
        }
    }
    // Si todas las celdas están llenas y válidas, el tablero está completo y correcto
    return true;
}

}