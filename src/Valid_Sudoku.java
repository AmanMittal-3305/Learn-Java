import java.util.*;

public class Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> row = new HashSet<>();
        Set<Character> col = new HashSet<>();
        Set<Character> box = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            row = new HashSet<>();
            col = new HashSet<>();
            box = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                // --- Row check ---
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) {
                        return false;
                    }
                    row.add(board[i][j]);
                }

                // --- Column check ---
                if (board[j][i] != '.') {
                    if (col.contains(board[j][i])) {
                        return false;
                    }
                    col.add(board[j][i]);
                }

                // --- Box check ---
                int rowIndex = 3 * (i / 3);  // starting row of the box
                int colIndex = 3 * (i % 3);  // starting col of the box

                int r = rowIndex + j / 3;
                int c = colIndex + j % 3;

                if (board[r][c] != '.') {
                    if (box.contains(board[r][c])) {
                        return false;
                    }
                    box.add(board[r][c]);
                }
            }
        }

        return true;
    }
}
