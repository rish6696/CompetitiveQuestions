import java.util.Arrays;

public class MaximumSumNonAdjacentElements {
    public static void main(String[] args) {
        int []arr ={5,10,10,100,5,6};
        int [] dp = new int [arr.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        System.out.println(maximumSumRecursive(0, arr));
        System.out.println(maximumSumMEMO(0, arr,dp));
        System.out.println(dp(arr));
    }

    public static int maximumSumRecursive(int idx,int[]arr){
        if(idx>=arr.length)return 0;
        int ans = Integer.MIN_VALUE;

        //select
        ans=Math.max(ans,arr[idx]+maximumSumRecursive(idx+2, arr));

        //not select 
        ans =Math.max(ans, maximumSumRecursive(idx+1, arr));
        return ans;
    }

    public static int maximumSumMEMO(int idx,int[]arr,int []dp){
        if(idx>=arr.length)return 0;

        if(dp[idx]!=Integer.MIN_VALUE)return dp[idx];
        int ans = Integer.MIN_VALUE;

        //select
        ans=Math.max(ans,arr[idx]+maximumSumMEMO(idx+2, arr,dp));

        //not select 
        ans =Math.max(ans, maximumSumMEMO(idx+1, arr,dp));
        dp[idx]=ans;
        return ans;
    }


    public static int dp(int []arr){
        int [] dp = new int[arr.length];
        for(int i =dp.length-1;i>=0;i--){
           int select =0;
           int notselect =0;

           int ans =Integer.MIN_VALUE;
           if(i+2<dp.length){
              select =dp[i+2];
           }
           ans=Math.max(ans, arr[i]+select);

           if(i+1<dp.length){
               notselect=dp[i+1];
           }
           ans=Math.max(ans, notselect);
           dp[i]=ans;
        }
        return dp[0];
    }
}