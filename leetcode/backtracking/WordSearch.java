import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        // char[][] board ={{'a','b'}};
        String[] words = { "oath","pea","eat","rain" };
        List<String> ans = new ArrayList<>();
        for (String string : words) {
            if(exist(board, string)){
                ans.add(string);
            }
            
        }
        System.out.println(ans);
      
    }

    public static  boolean exist(char[][] board, String word) {
        
        boolean[][] isDone=new boolean[board.length][board[0].length]; 
        int idx=0;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                 if(word.charAt(idx)==board[i][j]){
                     boolean recAns=wordSearch(board, isDone, word, 1, i, j);
                     if(recAns){
                         return recAns;
                     }
                 }
            }
           
        }
        return false;
        
    }

    public static boolean canMoveAhead(boolean[][] isDone,char[][]board, int row, int col,String str,int in) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && !isDone[row][col]&&board[row][col]==str.charAt(in)) {
            return true;
        }
        return false;
    }

    public static boolean wordSearch(char[][] board, boolean[][] isDone, String str, int sidx, int row, int col) {
        // if(sidx==str.length()-1&&str.charAt(sidx)==board[row][col]){
        //     return true;
        // }
        if (sidx == str.length()) {
            return true;
        }
        isDone[row][col]=true;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        for (int i = 0; i < dir.length; i++) {
            int x = row + dir[i][0];
            int y = col + dir[i][1];
    
            if (canMoveAhead(isDone, board, x, y, str, sidx)) {
                 boolean recAns=wordSearch(board,isDone, str,sidx+1 , x, y);
                 if(recAns)return true;
            }
        }

        isDone[row][col]=false;
        return false;

    }
}