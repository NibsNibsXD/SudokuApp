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
    private boolean[][] isEditable;

    public SudokuGUI(SudokuGame game) {
        this.game = game;
        initializeGUI();
    }

    private void initializeGUI() {
        frame = new JFrame("Sudoku Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 550);
        frame.setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(9, 9));
        cells = new JTextField[9][9];
        isEditable = new boolean[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col] = new JTextField();
                cells[row][col].setHorizontalAlignment(JTextField.CENTER);
                gridPanel.add(cells[row][col]);

                int value = game.getCell(row, col);
                if (value != 0) {
                    cells[row][col].setText(String.valueOf(value));
                    cells[row][col].setEditable(false);
                    isEditable[row][col] = false;
                } else {
                    isEditable[row][col] = true;
                }

                cells[row][col].addActionListener(new CellActionListener(row, col));
            }
        }

        JButton checkButton = new JButton("Verificar Tablero");
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game.isBoardComplete()) {
                    JOptionPane.showMessageDialog(frame, "¡Felicidades!");
                } else {
                    JOptionPane.showMessageDialog(frame, "El tablero no está completo o tiene errores.");
                }
            }
        });

        JButton clearButton = new JButton("Borrar Tablero");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearUserInputs();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(checkButton);
        buttonPanel.add(clearButton);

        frame.add(gridPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void clearUserInputs() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (isEditable[row][col]) {
                    cells[row][col].setText("");
                    game.setCell(row, col, 0);
                }
            }
        }
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
                if (isEditable[row][col] && game.isValidMove(row, col, value)) {
                    game.setCell(row, col, value);
                } else {
                    JOptionPane.showMessageDialog(frame, "no valido");
                    cells[row][col].setText("");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "no valido");
                cells[row][col].setText("");
            }
        }
    }
}