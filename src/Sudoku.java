import java.io.FileNotFoundException;

public class Sudoku {

    public static void main(String[] args) throws FileNotFoundException {
        SudokuBoard sb = new SudokuBoard();
        String filename = "SudokuLab/SudokuNYT.txt";
        sb.loadPuzzle(filename);
        sb.solvePuzzle();
        sb.drawPuzzle();

    }
}
