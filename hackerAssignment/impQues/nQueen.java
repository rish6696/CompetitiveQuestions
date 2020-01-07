public class nQueen{
    public static void main(String[] args) {
        System.out.println(countQueen(new boolean[4][4], 0));
        
    }

    public static int countQueen(boolean[][] board,int row){
        if(row==board.length){
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < board.length; j++) {
                    if(board[i][j]){
                        System.out.print("[ "+i+"-"+j+" ] ");
                    }
                }
              
            }
            System.out.println();
             return 1;
        }
        int count=0;
        for(int i=0;i<board.length;i++){
            if(isSafe(board, row, i)){
                board[row][i]=true;
                count+=countQueen(board, row+1);
                board[row][i]=false;
            }
        }
        return count;
       
    }


    public static boolean isSafe(boolean[][] board,int row,int col){
        //colcheck 
        	for (int i = row; i >= 0; i--) {
			if (board[i][col]) {
				return false;
			}
		}

        //left-upward diagonal
        int rowi=row;
        int coli=col;
        while(rowi>=0&&coli>=0){
             if(board[rowi][coli])return false;
             rowi--;
             coli--;
        }

        rowi=row;
        coli=col;
        //left-downward
        while(coli<board.length&&rowi>=0){
             if(board[rowi][coli])return false;
             rowi--;
             coli++;
        }
        return true;
        
    }
}