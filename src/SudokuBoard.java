import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import gameBoards.SudokuGUI;

public class SudokuBoard {
    private final SudokuGUI gui;
    private final int[][] board;

    SudokuBoard () {
        this.gui = new SudokuGUI();
        this.board = new int[9][9];
    }


        public void loadPuzzle(String fileName) throws FileNotFoundException {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
    
            int row = 0;
            while (scan.hasNextLine() && row < 9) {
                String line = scan.nextLine().replaceAll("\\s+", "");
                if (line.length() != 9) {
                    throw new IllegalArgumentException("ERROR: " + line);
                }
                for (int col = 0; col < 9; col++) {
                    char c = line.charAt(col);
                    if (c == '.') {
                        board[row][col] = 0;
                    } else if (c >= '1' && c <= '9') {
                        int n = Character.getNumericValue(c);
                        board[row][col] = n;
                        gui.draw(board);
                    } else {
                        throw new IllegalArgumentException("ERROR: " + line);
                    }
                }
                row++;
                if (row % 3 == 0 && scan.hasNextLine()) {
                    scan.nextLine();
                }
            }
            if (row != 9) {
                throw new IllegalArgumentException("ERROR");
            }
            gui.draw(board, new Color(232, 232, 232));
        }
    
    public boolean solvePuzzle() {
        return solveCell(0, 0);
    }
    
    public boolean solveCell(int row, int col) {
        if (row == 9) {
            return true;
        }

        int nextRow, nextCol;
        if (col == 8) {
            nextRow = row + 1;
            nextCol = 0;
        } else {
            nextRow = row;
            nextCol = col + 1;
        }

        if (board[row][col] != 0) {
            return solveCell(nextRow, nextCol);
        }
        
        for (int i = 1; i <= 9; i++) {
            if (isValidMove(row, col, i)) {
                board[row][col] = i;
                if (solveCell(nextRow, nextCol)) {
                    return true; // Puzzle is solved
                }
                board[row][col] = 0; // backtrack
            }
        }
        
        return false; // No valid moves
    }
    
    public boolean isValidMove(int row, int col, int num) {
        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
        
        // Check 3x3 square
        int squareRow = (row / 3) * 3;
        int squareCol = (col / 3) * 3;
        for (int i = squareRow; i < squareRow + 3; i++) {
            for (int j = squareCol; j < squareCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public void drawPuzzle() {
        gui.draw(board);
    }
}
