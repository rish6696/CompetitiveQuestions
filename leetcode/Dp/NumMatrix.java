
public class NumMatrix {


    int [][] dp ;

    public NumMatrix(int[][] m) {
        if(m.length==0 || m[0].length==0) return ;
        dp = new int [m.length][m[0].length];  
        
        for(int i =0;i<dp.length;i++){
            dp[i][0]=m[i][0];
            for(int j =1;j<dp[0].length;j++){
                dp[i][j]= dp[i][j-1]+ m [i][j];
            }
        }
        
        
//         for(int i =0;i<dp.length;i++){
           
//             for(int j =0;j<dp[0].length;j++){
//                 System.out.print(dp[i][j]+" ");
//             }
//             System.out.println();
//         }
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        int d = r2-r1;
        int ans =0;
        
        for(int i=0;i<=d;i++){
            int row = r1+i;
            if(c1==0) ans+=dp[row][c2];
            else ans+= dp[row][c2]-dp[row][c1-1];       
        }
        return ans;
    }

}