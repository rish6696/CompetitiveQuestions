import java.util.Scanner;
public class KnightTour{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        printKnightTour(0, 0, n-1, n-1, 1, new int[n][n], new boolean[n][n]);
       //System.out.println(printOneKnightTour(0, 0, n-1, n-1, 1, new int[n][n], new boolean[n][n]));
       //System.out.println(countKnightTour(0, 0, n-1, n-1, 1, new int[n][n], new boolean[n][n]));
        
    }


    public static int  countKnightTour(int cr,int cc,int er,int ec,int counter,int[][]board,boolean[][]isVisited){

        if(counter==(er+1)*(ec+1)){
           return 1;
        }
        isVisited[cr][cc]=true;
        int count=0;
        int[][] directions={{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
        for(int i=0;i<directions.length;i++){
             int row=cr+directions[i][0];
             int col=cc+directions[i][1];
             if(isVAlid(row, col, isVisited)){
                   board[cr][cc]=counter;
                   count+=countKnightTour(row, col, er, ec, counter+1, board, isVisited);
                   //board[cr][cc]=0;
             }
        }
        
        isVisited[cr][cc]=false;
        return count;

    }
   


    public static boolean  printOneKnightTour(int cr,int cc,int er,int ec,int counter,int[][]board,boolean[][]isVisited){

        if(counter==(er+1)*(ec+1)){
            board[cr][cc]=counter;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j]+"  ");
                }
                System.out.println();
            }

            System.out.println("***************************************");
            return true;
        }
        isVisited[cr][cc]=true;
        int[][] directions={{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
        for(int i=0;i<directions.length;i++){
             int row=cr+directions[i][0];
             int col=cc+directions[i][1];
             if(isVAlid(row, col, isVisited)){
                   board[cr][cc]=counter;
                   boolean recAns=printOneKnightTour(row, col, er, ec, counter+1, board, isVisited);
                   if(recAns)return true;
                   //board[cr][cc]=0;
             }
        }

        isVisited[cr][cc]=false;
        return false;

    }

    public static boolean isVAlid(int row,int col,boolean[][]isVisited){
        if(row>=0&&row<isVisited.length&&col>=0&&col<isVisited[0].length && !isVisited[row][col] ){
            return true;
        }
        return false;
    }


    public static void printKnightTour(int cr,int cc,int er,int ec,int counter,int[][]board,boolean[][]isVisited){

        if(counter==(er+1)*(ec+1)){
            board[cr][cc]=counter;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j]+"  ");
                }
                System.out.println();
            }

            System.out.println("***************************************");
            return;
        }
        isVisited[cr][cc]=true;
        int[][] directions={{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
        for(int i=0;i<directions.length;i++){
             int row=cr+directions[i][0];
             int col=cc+directions[i][1];
             if(isVAlid(row, col, isVisited)){
                   board[cr][cc]=counter;
                   printKnightTour(row, col, er, ec, counter+1, board, isVisited);
                   //board[cr][cc]=0;
             }
        }

        isVisited[cr][cc]=false;

    }
}