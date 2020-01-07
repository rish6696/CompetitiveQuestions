public class SodukuDiksha{
    public static void main(String[] args) {
       
            char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}};

            solveSudoku(board);
           
        
    }
    public static void printBoard(char[][]board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void solveSudoku(char[][] board) {
        sudoku(board,0);
    }
    public static boolean isValidSudoku(char[][] board, int i, int j, int num) {

        // col
        for (int idx = 0; idx < board.length; idx++) {
            if (board[idx][j] == (char)(48+num)) {
                return false;
            }
        }

        // row
        for (int idx = 0; idx < board.length; idx++) {
            if (board[i][idx] == (char)(48+num)) {
                return false;
            }
        }

        // mat
        int r = (i / 3) * 3;
        int c = (j / 3) * 3;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[r + row][c + col] == (char)(48+num))
                    return false;
            }
        }

        return true;
    }

    public static boolean sudoku(char[][] board, int vidx) {
        if (vidx == 81) {
            printBoard(board);
            
            return true;
        }

        int r = vidx / 9;
        int c = vidx % 9;
        boolean res = false;

        if (board[r][c] != '.') {
            res = res || sudoku(board, vidx + 1);
        } else {
            for (int num = 1; num <= 9; num++) {
                if (isValidSudoku(board, r, c, num)) {
                    board[r][c] = (char)(48+num);
                    res = res || sudoku(board, vidx + 1);
                    board[r][c] = '.';
                }
            }
        }

        return res;
    }
}