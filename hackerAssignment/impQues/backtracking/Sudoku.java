public class Sudoku {
    public static void main(String[] args) {

        int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        System.out.println(printSudoku(board, 0));

    

    }

    public static boolean printSudoku(int[][] board, int pos) {
        if (pos == 81) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("*******************************************************");

            return true;
        }

        int row = pos / 9;
        int col = pos % 9;

        if (board[row][col] != 0) {
            return printSudoku(board, pos + 1);
            
        }
        for (int i = 1; i <= 9; i++) {
            if (isValidSudoku(board, row, col, i)) {
                board[row][col] = i;
                boolean recAns=printSudoku(board, pos + 1);
                if(recAns)return true;
                board[row][col] = 0;
            }
        }

        return false;

    }

    public static boolean isValidSudoku(int[][] board, int row, int col, int num) {
        // col
        int i = 0;
        while (i < board.length) {
            if (board[i][col] == num)
                return false;
            i++;
        }

        // row
        int j = 0;
        while (j < board[0].length) {
            if (board[row][j] == num)
                return false;
            j++;
        }

        // matrix
        int vrow = (row / 3) * 3;
        int vcol = (col / 3) * 3;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (board[vrow + i][vcol + j] == num)
                    return false;

            }
        }

        return true;

    }
}