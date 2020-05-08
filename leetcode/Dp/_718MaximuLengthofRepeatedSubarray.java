
public class _718MaximuLengthofRepeatedSubarray {

    public static void main(String[] args) {
        int [] a= {1,2,3,2,1};
        int [] b={3,2,1,4,7};

        System.out.println(findLength(a, b));
    }


    public static int findLength(int[] A, int[] B) {
        int [][] dp = new int [A.length+1][B.length+1];
        int ans = Integer.MIN_VALUE;
        
        for(int i=dp.length-1;i>=0;i--){
            
            for(int j=dp[0].length-1;j>=0;j--){
                
                if(i==A.length||j==B.length){
                    dp[i][j]=0;
                }
                
                else if(A[i]==B[j]){
                    dp[i][j]= 1+dp[i+1][j+1];
                }
                else dp[i][j]=0;
                ans=Math.max(ans,dp[i][j]);
            }     
        }
        
        return ans;   
    }

}