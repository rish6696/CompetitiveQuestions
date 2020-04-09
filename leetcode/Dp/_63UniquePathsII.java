import java.util.Scanner;
public class _63UniquePathsII{
    public static void main(String[] args) {

       

        // int [][] grid = {
        //     {1,0}
        // };
        // int [] dp = new int [grid.length*grid[0].length];
        // System.out.println(uniquePathIIIterative(grid));
    }

    public static int uniquePathII(int cr,int cc,int er,int ec,int [][] grid,int[]dp){
        

        int idx= cr *(ec+1) + cc;
        if(dp[idx]!=0) return dp[idx];

        if(cr==er&&cc==ec) {
            if(grid[cr][cc]==1){
                dp[idx]=0;
                return 0;
            }
            else{
                dp[idx]=1;
                return 1;
            }
        }

        int [][] dir ={{0,1},{1,0}};
        int ans=0;
        for (int i = 0; i < dir.length; i++) {
            int row = cr+dir[i][0];
            int col = cc+dir[i][1];

            if(row>=0 && row<=er && col>=0 && col<=ec && grid[row][col]!=1){
                ans+=uniquePathII(row, col, er, ec, grid,dp);
            }
        }
        dp[idx]=ans;
        return ans;
    }



    public static int uniquePathIIIterative(int [][] grid) {

        if(grid==null||grid.length==0||grid[0].length==0) return 0;

        int[][] dp = new int [grid.length][grid[0].length];

        int m=grid.length;
        int n =grid[0].length;

        if(grid[m-1][n-1]==1) return 0;

        dp[m-1][n-1]=1;

        for(int row =m-1;row>=0;row--){
            for(int col =n-1;col>=0;col--){

                if(row==m-1&&col==n-1) continue;

                if(grid[row][col]==1){
                    dp[row][col]=0;
                    continue;
                }

                int [][] dir ={{0,1},{1,0}};
                int ans=0;
                for (int i = 0; i < dir.length; i++) {
                    int x = row+dir[i][0];
                    int y = col+dir[i][1];
    
                    if(x>=0 && x<=m-1 && y>=0 && y<=n-1 && grid[x][y]!=1){
                        ans+=dp[x][y];
                    }
                }
                dp[row][col]=ans;

            }
        }

        return dp[0][0];

        // int idx= cr *(ec+1) + cc;
        // if(dp[idx]!=0) return dp[idx];

        // if(cr==er&&cc==ec) {
        //     dp[idx]=1;
        //     return 1;
        // }

        // int [][] dir ={{0,1},{1,0}};
        // int ans=0;
        // for (int i = 0; i < dir.length; i++) {
        //     int row = cr+dir[i][0];
        //     int col = cc+dir[i][1];

        //     if(row>=0 && row<=er && col>=0 && col<=ec && grid[row][col]!=1){
        //         ans+=uniquePathII(row, col, er, ec, grid,dp);
        //     }
        // }
        // dp[idx]=ans;
        // return ans;
    }
}