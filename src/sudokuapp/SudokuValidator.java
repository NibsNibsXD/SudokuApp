/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sudokuapp;

/**
 *
 * @author Jorge Aguirre
 */
public interface SudokuValidator {
    boolean isValidMove(int row, int col, int value);
    boolean isBoardComplete();
}
