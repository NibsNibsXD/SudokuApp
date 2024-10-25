/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudokuapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Jorge Aguirre
 */


public class SudokuGUI {
    private SudokuGame game;
    private JFrame frame;
    private JTextField[][] cells;

    public SudokuGUI(SudokuGame game) {
        this.game = game;
        initializeGUI();
    }

    private void initializeGUI() {
        frame = new JFrame("Sudoku Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000); 
        frame.setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(9, 9));
        
        cells = new JTextField[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col] = new JTextField();
                cells[row][col].setHorizontalAlignment(JTextField.CENTER);
                gridPanel.add(cells[row][col]);
                int value = game.getCell(row, col);
                if (value != 0) {
                    cells[row][col].setText(String.valueOf(value));
                    cells[row][col].setEditable(false); 
                }
                //cells[row][col].addActionListener(new CellActionListener(row, col));
            }
        }
        
        JButton checkButton = new JButton("Verificar Tablero");
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game.isBoardComplete()) {
                    JOptionPane.showMessageDialog(frame, "¡Felicidades! El tablero está completo y es válido.");
                } else {
                    JOptionPane.showMessageDialog(frame, "El tablero no está completo o tiene errores.");
                }
            }
        });
        
        frame.add(gridPanel, BorderLayout.CENTER);
        frame.add(checkButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
    
    private class CellActionListener implements ActionListener {
    private int row;
    private int col;

    public CellActionListener(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = cells[row][col].getText();
        try {
            int value = Integer.parseInt(text);
            // Comprueba si el valor es válido y actualiza el tablero si lo es
            if (game.isValidMove(row, col, value)) {
                game.setCell(row, col, value); // Asegura que el valor se actualice en el juego
            } else {
                JOptionPane.showMessageDialog(frame, "Movimiento inválido");
                cells[row][col].setText(""); // Limpia la entrada si es inválida
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Por favor ingresa un número entre 1 y 9");
            cells[row][col].setText("");
        }
    }
}

}//ca,bio
