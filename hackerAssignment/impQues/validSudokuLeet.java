public class validSudokuLeet {
    public static void main(String[] args) {
        String [][] arr={
            {".",".",".",".","5",".",".","1","."},
            {".","4",".","3",".",".",".",".","."},
            {".",".",".",".",".","3",".",".","1"},
            {"8",".",".",".",".",".",".","2","."},
            {".",".","2",".","7",".",".",".","."},
            {".","1","5",".",".",".",".",".","."},
            {".",".",".",".",".","2",".",".","."},
            {".","2",".","9",".",".",".",".","."},
            {".",".","4",".",".",".",".",".","."}
        };
        System.out.println(isValidSudoku(arr));

     
    }

    public static  boolean isValidSudoku(String[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {


                String num = board[row][col];
                if (!num.equals(".")) {
                    for (int i = 0; i < board[row].length; i++) {
                        if (i!=col&&board[row][i].equals(num)) {
                            System.out.println(" row "+row+" "+col);
                            return false;
                        }
                    }
                    // col
                    for (int i = 0; i < board.length; i++) {
                        if (i!=row&&board[i][col].equals(num)) {
                             System.out.println(" col "+row+" "+col);
                            return false;
                        }
                    }
                    // matrix
                    int vr = (row / 3) * 3;
                    int vc = (col / 3) * 3;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if ((i+vr)!=row&&(j+vc)!=col&&board[vr + i][vc + j].equals(num)){
                             System.out.println(" matrix "+row+" "+col);
                                return false;
                        }
                     
                        
                     
                    }
                }
            }
        }

        

    }
    return true;
    }
}