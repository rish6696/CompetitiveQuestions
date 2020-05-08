import java.util.Arrays;

public class iplQues{
    public static void main(String[] args) {
        int []arr = {3,2,3,2,3,5,1,3};
       // System.out.println(maxProfitRecursive(arr,0, 0));
        int [][] dp = new int [arr.length+1][3];
        for(int []a:dp) Arrays.fill(a, -1);
        System.out.println(maxProfitMemoization(arr, 0, 0, dp));
    }

    public static int maxProfitMemoization(int []arr,int consecDays,int i,int[][]dp){
        if(i==arr.length){
            dp[i][consecDays]=0;
            return 0;
        }
        if(dp[i][consecDays]!=-1) return dp[i][consecDays];
        int ans = Integer.MIN_VALUE;
        // select it 
        if(consecDays<2){
            ans=Math.max(ans,arr[i]+maxProfitMemoization(arr, consecDays+1,i+1,dp));
        }
        //not play today
        ans=Math.max(ans, maxProfitMemoization(arr,0,i+1,dp));
        dp[i][consecDays]=ans;
        return ans ;
    }


    public static int maxProfitRecursive(int []arr,int consecDays,int i){
        if(i==arr.length) return 0;
        int ans = Integer.MIN_VALUE;
        // select it 
        if(consecDays<2){
            ans=Math.max(ans,arr[i]+maxProfitRecursive(arr, consecDays+1,i+1));
        }
        //not play today
        ans=Math.max(ans, maxProfitRecursive(arr,0,i+1));
        return ans ;
    }
}