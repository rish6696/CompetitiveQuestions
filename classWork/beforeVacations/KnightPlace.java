import java.util.LinkedList;

public class KnightPlace{
    public static void main(String[] args) {

        int n =2;
        boolean [][] board =new boolean [n][n];
        System.out.println(solveKnight(0, board, 1, 2));
    }




    public static  boolean isValidIndex(int r ,int c ,boolean[][]board){
        if( r < 0 || r >= board.length || c<0 || c >=board[0].length ) return false;
        return true;
    }

    public static boolean canPlace(boolean [][]board ,int r,int c){
        if(board[r][c]) return false;
        int[][] dir ={{1,2},{2,1},{-1,2},{1,-2},{-2,1},{2,-1},{-2,-1},{-1,-2}};
        for (int i = 0; i < dir.length; i++) {
            int x = r+dir[i][0];
            int y =c+dir[i][1];
            if(isValidIndex(x, y, board) &&  board[x][y] ) return false;
        }
        return true;
    }


    public static void print(boolean [][] board ){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]) System.out.print("{"+i+"-"+j+"}" );
            }
        }

        System.out.print(" ");
    }

    
    public static int solveKnight(int idx ,boolean [][] board,int qtp,int k ){

       int row = idx/board[0].length;
       int col =idx % board[0].length;
       if(qtp ==k+1) {
           print(board);
           return 1;
       }
       if(!isValidIndex(row, col, board)) return 0;

       int ans =0;

       if(canPlace(board, row, col)){
           board[row][col]=true;
           ans += solveKnight(idx+1, board, qtp+1, k);
           board[row][col]=false;
       }
       ans+= solveKnight(idx+1, board, qtp, k);

       return ans ;

    }


}