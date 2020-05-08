import java.util.*;
public class Main {
    public static void main (String args[]) {
        Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int [] arr = new int [n];
        int[][] dp = new int [n+1][3];
        for(int i =0;i<n;i++){
			arr[i]=s.nextInt();
		}
		for(int []a:dp) Arrays.fill(a, -1);
        System.out.println(maxProfitMemoization(arr, 0, 0, dp));
        System.out.println(dpSol(arr));
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


      public static int dpSol(int []arr){
        
        int[][]dp = new int [arr.length+1][3];

        for(int i=dp.length-1;i>=0;i--){
            for(int consecDays=dp[0].length-1;consecDays>=0;consecDays--){
                if(i==arr.length){
                    dp[i][consecDays]=0;
                    continue;
                }
                int ans = Integer.MIN_VALUE;

                if(consecDays<2){
                    ans=Math.max(ans,arr[i]+dp[i+1][consecDays+1]);
                }
                //not play today
                ans=Math.max(ans, dp[i+1][0]);
                dp[i][consecDays]=ans;
            }
        }

        return dp[0][0];
    }
}