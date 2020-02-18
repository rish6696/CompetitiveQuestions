public class _130SurroundedRegions{
    public static void main(String[] args) {
        char [][] board ={{'x','x','x','x'},{'x','0','0','x'},{'x','x','0','x'},{'x','0','x','x'}};
        boolean [] visited =new boolean [board.length*board[0].length];
        for(int j=0;j<board[0].length;j++){
            int row=0;
            int col =j;
          //  System.out.println(row+","+col);
            int idx = row*board[0].length+col; 
            if(board[row][col]=='0')dfs(board, idx, visited);
        }

        for(int j=1;j<board.length;j++){
            int row=j;
            int col =board[0].length-1;
            //System.out.println(row+","+col);
            int idx = row*board[0].length+col; 
            if(board[row][col]=='0')dfs(board, idx, visited);
        }
        for(int j=board[0].length-2;j>=0;j--){
            int row=board.length-1;
            int col =j;
            //System.out.println(row+","+col);
            int idx = row*board[0].length+col; 
            if(board[row][col]=='0')dfs(board, idx, visited);
        }

        
        for(int j=board.length-2;j>=1;j--){
            int row=j;
            int col =0;
            int idx = row*board[0].length+col;
            System.out.println(row+","+col); 
            if(board[row][col]=='0')dfs(board, idx, visited);
        }



      


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='0') board[i][j]='x';
            }
            
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='y') board[i][j]='0';
            }
            
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

        
        
    }

    public static void dfs(char[][] board,int idx,boolean [] visited ){
       visited[idx]=true;
       int row = idx / board[0].length;
       int col =idx % board[0].length;
       board[row][col]= 'y';
       int [][] niebours ={{0,1},{1,0},{-1,0},{0,-1}};
       for (int i = 0; i < niebours.length; i++) {
           int x =row+niebours[i][0];
           int y =col+ niebours[i][1];
           int tidx=x*board[0].length+y;
           if(x>=0 && x<board.length && y >=0 && y<board[0].length && !visited[tidx] && board[x][y]=='0'){
               dfs(board, tidx, visited);
           }
       }
    }
}