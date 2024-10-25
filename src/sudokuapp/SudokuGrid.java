/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudokuapp;

/**
 *
 * @author Jorge Aguirre
 */
public abstract class SudokuGrid {
    protected int[][] grid;
    
    public abstract void initializeGrid();
    public abstract void setCell(int row, int col, int value);
    public abstract int getCell(int row, int col);
}
