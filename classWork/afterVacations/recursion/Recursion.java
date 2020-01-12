import java.util.*;

public class Recursion{
    public static void main(String[] args) {
        // int r=15;
        // int c =15;
        // boolean [] col =new boolean[c];
        // boolean []  Diagonal =new boolean [r+c-1];
        // boolean [] antiDiagonal=new boolean[r+c-1];
        // System.out.println(Nqueen(0, col, Diagonal, antiDiagonal));

        // int colB =0;
        // int diaB=0;
        // int antiB =0;
        // System.out.println(NqueenBits(0, c, colB, diaB,antiB));

        // int [][] board={{3, 0, 6, 5, 0, 8, 4, 0, 0},
        //                              {0, 0, 0, 0, 0, 0, 0, 0, 0},
        //                              {4, 8, 7, 0, 0, 0, 0, 3, 1},
        //                              {0, 0, 3, 0, 1, 0, 0, 8, 0},
        //                              {9, 0, 0, 8, 6, 3, 0, 0, 5},
        //                              {0, 5, 0, 0, 9, 0, 6, 0, 0},
        //                              {1, 3, 0, 0, 0, 0, 2, 5, 0},
        //                              {0, 0, 0, 0, 0, 0, 0, 7, 4},
        //                              {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        // int [] rowDone=new int [9];
        // int [] colDone=new int [9];
        // int [][] matrixDone=new int [3][3];
        // populate(board, rowDone, colDone, matrixDone);
        // System.out.println(sudokuSolver(board, 0, rowDone, colDone, matrixDone));


        char [][] board ={
            {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
            {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
            {'+', '-', '-', '-', '-', '-', '-', '-', '+', '+'},
            {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
            {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
            {'+', '-', '-', '-', '-', '-', '-', '+', '+', '+'},
            {'+', '-', '+', '+', '+', '-', '+', '+', '+', '+'},
            {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
            {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
            {'+', '+', '+', '+', '+', '+', '+', '+', '+', '+'}};


        String [] words={"agra", "norway", "england", "gwalior"};
        System.out.println(crossWordSolver(board, words, 0));


    }

    public static int Nqueen(int row,boolean []col,boolean []Diagonal,boolean []antiDiagonal){
        if(row==col.length) return 1;
        int ans =0;
        for(int c=0;c<col.length;c++){
            if(!col[c] && !Diagonal[row+c] && !antiDiagonal[row-c+col.length-1]){
                col[c]=true;
                Diagonal[row+c]=true;
                antiDiagonal[row-c+col.length-1]=true;
                ans+=Nqueen(row+1, col, Diagonal, antiDiagonal);
                col[c]=false;
                Diagonal[row+c]=false;
                antiDiagonal[row-c+col.length-1]=false;
            }
        }
        return ans ;
    }


    public static int NqueenBits(int row,int n,int col,int Diagonal,int antiDiagonal){
        if(row==n) return 1;
        int ans =0;

        for(int c=0;c<n;c++){
            int colMask = 1<<c;
            int diaMask = 1<<(row+c);
            int antiMask =1 <<(row-c+n-1);
            if((colMask&col)==0 && (diaMask&Diagonal)==0 && (antiMask&antiDiagonal)==0){
                col|=colMask;
                Diagonal|=diaMask;
                antiDiagonal|=antiMask;
                ans+=NqueenBits(row+1,n, col, Diagonal, antiDiagonal);
                col &= (~colMask);
                Diagonal&=(~diaMask);
                antiDiagonal&=(~antiMask);
            }
        }
        return ans ;
    }


    public static void populate(int [][]board,int []rowForSudoku,int []colForSudoku,int [][]matrixForSudoku){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!=0){
                    int val=board[i][j];
                    int mask=1<<val;
                    rowForSudoku[i]|=mask;
                    colForSudoku[j]|=mask;
                    matrixForSudoku[i/3][j/3]|=mask;
    
                }
            }
        }
    }
    public static int sudokuSolver(int [][] board,int pos,int []rowDone,int []colDone,int [][] matrixDone){
        if(pos==81){
            for(int i=0;i<9;i++){
                System.out.println(Arrays.toString(board[i]));
            }
            System.out.println("************************************");
            return 1;
        }
        int ans =0;
        int row = pos / 9;
        int col = pos % 9 ;
        if(board[row][col]!=0){
            ans+= sudokuSolver(board, pos+1, rowDone, colDone, matrixDone);
        } 
        else{
            for (int i = 1; i < 10; i++) {

                if(  ((1<<i)&rowDone[row])==0  && ((1<<i)&colDone[col])==0 && ((1<<i)&matrixDone[row/3][col/3])==0  ){
                    int mask = 1<<i;
                    rowDone[row]|=mask;
                    colDone[col]|=mask;
                    matrixDone[row/3][col/3]|=mask;
                    board[row][col]=i;
                    ans+=sudokuSolver(board, pos+1, rowDone, colDone, matrixDone);
                    board[row][col]=0;
                    rowDone[row]&=~mask;
                    colDone[col]&=~mask;
                    matrixDone[row/3][col/3]&=~mask;

                }
                
            }
        }


        return ans ;
        


    }


    public static boolean isSafeToPlaceHorizontal(char [][] board,int x,int y,String word){

        for (int i = 0; i < word.length() ; i++) {
            if(board[x][y+i]!='-' && board[x][y+i]!=word.charAt(i)){
                return false;
            }  
        }
        return true;
        
    }


    public static boolean isSafeToPlaceVertical(char [][] board,int x,int y,String word){

        for (int i = 0; i < word.length() ; i++) {
            if(board[x+i][y]!='-' && board[x+i][y]!=word.charAt(i)){
                return false;
            }  
        }
        return true;
        
    }



    public static boolean[] placeWordHorizontal(char[][] board,int x,int y,String word){
       boolean [] placdByMe=new boolean [word.length()];
       for (int i = 0; i < placdByMe.length; i++) {
           if(board[x][y+i]=='-'){
               placdByMe[i]=true;
               board[x][y+i]=word.charAt(i);
           }
       }
       return placdByMe;
    }



    public static boolean[] placeWordVertical(char[][] board,int x,int y,String word){
        boolean [] placdByMe=new boolean [word.length()];
        for (int i = 0; i < placdByMe.length; i++) {
            if(board[x+i][y]=='-'){
                placdByMe[i]=true;
                board[x+i][y]=word.charAt(i);
            }
        }
        return placdByMe;
     }


    public static void unPlaceHorizontal(char[][] board,boolean []placedByMe,int x,int y){
       for (int i = 0; i < placedByMe.length; i++) {
           if(placedByMe[i]){
               board[x][y+i]='-';
           }
       }
    }


    public static void unPlaceVertical(char[][] board,boolean []placedByMe,int x,int y){
        for (int i = 0; i < placedByMe.length; i++) {
            if(placedByMe[i]){
                board[x+i][y]='-';
            }
        }
     }


     public static int  crossWordSolver(char[][]board,String [] words,int idx) {
        if(idx==words.length){
             for (int i = 0; i < board.length; i++) {
                System.out.println(Arrays.toString(board[i]));
                 
            }
            System.out.println("*******************************");
            return 1;
        }

        int ans =0;
        String word =words[idx]; 
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {
            
                   if(isSafeToPlaceHorizontal(board, i, j, word)){
                        boolean []placedByMe=placeWordHorizontal(board, i, j, word);
                        ans+=crossWordSolver(board, words, idx+1);
                        unPlaceHorizontal(board, placedByMe, i, j);
                    }
                    if(isSafeToPlaceVertical(board, i, j, word)){
                        boolean []placedByMe=placeWordVertical(board, i, j, word);
                        ans+=crossWordSolver(board, words, idx+1);
                        unPlaceVertical(board, placedByMe, i, j);
                    }
                
            }
            
        }


        return ans ;
     }


}