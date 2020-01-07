import java.util.ArrayList;
import java.util.*;

public class Combinations {
    public static void main(String[] args) {
        boolean[][]board=new boolean[4][4];
        List<List<String>>bigAns=new ArrayList<>();
        System.out.println(queenCombinations(board, 0, 1, 4,bigAns));
        System.out.println(bigAns);
    
    }

    public static boolean canPlaceQueen(boolean[][] board, int x, int y) {
        int[][] dir = { { -1, 0 }, { 0, -1 }, { -1, 1 }, { -1, -1 } };
        for (int i = 0; i < dir.length; i++) {
            for (int rad = 1; rad <= board.length; rad++) {
                int cx = x + dir[i][0] * rad;
                int cy = y + dir[i][1] * rad;
                if (cx >= 0 && cx < board.length && cy >= 0 && cy < board[0].length && board[cx][cy]) {
                    return false;
                }
            }
        }
        return true;

    }

    public static int queenCombinations(boolean[][] board, int idx, int queen, int tq,List<List<String>>bigAns) {
        if (queen == tq + 1) {
          //  System.out.println(ans);
           List<String> list=new ArrayList<>();
           for(int i=0;i<board.length;i++){
               String str=""; 
               for(int j=0;j<board[0].length;j++){
                   if(board[i][j]){
                       str+="Q";
                   }else{
                       str+=".";
                   }
               }
               list.add(str);
           }
           bigAns.add(list);
            return 1;
        }
        int count = 0;
        for (int i = idx; i < board.length*board.length; i++) {
             int row=i/board.length;
             int col=i%board.length;
             if(canPlaceQueen(board, row, col)){
                 board[row][col]=true;
                 count += queenCombinations(board, i + 1, queen + 1, tq, bigAns);
                 board[row][col]=false;
             }
        }
        return count;
    }

    public static int queenPermutations(boolean[] isDone, int queen, int tq, String ans) {
        if (queen == tq + 1) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < isDone.length; i++) {
            if (!isDone[i]) {
                isDone[i] = true;
                count += queenPermutations(isDone, queen + 1, tq, ans + "b[" + i + "]q=" + queen + " ");
                isDone[i] = false;
            }
        }
        return count;
    }
}
