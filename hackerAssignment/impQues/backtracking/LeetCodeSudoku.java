public class LeetCodeSudoku{
    public static void main(String[] args) {
        char[][] board={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(printSudoku(board, 1));
    }

    public static boolean printSudoku(char [][] board, int pos) {
        if (pos == 81) {    
        return true;
        }

        int row = pos / 9;
        int col = pos % 9;

        if (board[row][col] != '.') {
            return printSudoku(board, pos + 1);
            
        }
        for (int i = 1; i <= 9; i++) {
            if (isValidSudoku(board, row, col, i)) {
                board[row][col] = (char)(i+48);
                boolean recAns=printSudoku(board, pos + 1);
                if(recAns)return true;
                board[row][col] = '.';
            }
        }

        return false;

    }

    public static boolean isValidSudoku(char [][] board, int row, int col, int num) {
        // col
        int i = 0;
        while (i < board.length) {
            if (board[i][col] == (char)(num+48))
                return false;
            i++;
        }

        // row
        int j = 0;
        while (j < board[0].length) {
            if (board[row][j] == (char)(num+48))
                return false;
            j++;
        }

        // matrix
        int vrow = (row / 3) * 3;
        int vcol = (col / 3) * 3;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (board[vrow + i][vcol + j] == (char)(num+48))
                    return false;

            }
        }

        return true;

    }
}