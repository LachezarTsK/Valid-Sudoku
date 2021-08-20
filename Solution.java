public class Solution {

    public boolean isValidSudoku(char[][] board) {
        return _9x9_(board) && _3x3_(board);
    }

    public boolean _9x9_(char[][] board) {

        for (int r = 0; r < 9; r++) {
            int[] checkRows = new int[9];
            int[] checkColumns = new int[9];

            for (int c = 0; c < 9; c++) {
                if (moreThanOneOccurence(r, c, board, checkRows)) {
                    return false;
                }
                if (moreThanOneOccurence(c, r, board, checkColumns)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean _3x3_(char[][] board) {

        for (int row = 0; row < 9; row += 3) {
            for (int column = 0; column < 9; column += 3) {

                int[] checkSquare = new int[9];
                for (int r = row; r < row + 3; r++) {
                    for (int c = column; c < column + 3; c++) {
                        if (moreThanOneOccurence(r, c, board, checkSquare)) {
                            return false;
                        }
                    }
                }

            }
        }
        return true;
    }

    public boolean moreThanOneOccurence(int r, int c, char[][] board, int[] check) {
        if (board[r][c] != '.') {
            check[board[r][c] - '1']++;
            if (check[board[r][c] - '1'] > 1) {
                return true;
            }
        }
        return false;
    }
}
