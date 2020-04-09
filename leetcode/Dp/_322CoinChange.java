import java.util.Arrays;
import java.util.HashMap;

public class _322CoinChange {

    public static void main(String[] args) {

        int [] nums =  {1,2,5};
        int k =11;

       
        // int [] dp =new int [k+1];
        // Arrays.fill(dp, -1);
        int ans =coinChangeTabulation(k,nums);
        ans = ans==Integer.MAX_VALUE?-1: ans ;
        System.out.println(ans);

        // display(dp);
        
    }

    public static  int coinChange(int sum,int []nums,int k){

        if(sum==k) return 0;
        int ans =Integer.MAX_VALUE;

        for(int i =0;i<nums.length;i++){
            if(nums[i]!=0&&sum+nums[i]<=k){
                ans=Math.min(ans, coinChange(sum+nums[i], nums, k));
            }
        }

        return ans == Integer.MAX_VALUE ? ans :ans +1;
    }

    public static void display(int[]dp){
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]+" ");
        }
        System.out.println();
    }



    public static  int coinChangeMemo(int sum,int []nums,int k,int[]dp){

        // if(dp.containsKey(sum)) return dp.get(sum);

        if(dp[sum]!=-1) return dp[sum];

        if(sum==k) {
            dp[sum]=0;
            return 0;
        }
        int ans =Integer.MAX_VALUE;

        for(int i =0;i<nums.length;i++){
            if(nums[i]!=0 && nums[i]!=Integer.MAX_VALUE&&nums[i]+sum<=k){
                ans=Math.min(ans, coinChangeMemo(sum+nums[i], nums, k,dp));
            }
        }
        if(ans==Integer.MAX_VALUE){
            dp[sum]=ans;
            return ans;
        }else{
           dp[sum]=ans+1;
           return ans+1;
        }
    }


    public static  int coinChangeTabulation(int k,int [] nums){

        int [] dp = new int [k+1];
        dp[k]=0;
        for(int i =k-1;i>=0;i--){

            int ans =Integer.MAX_VALUE;

            for(int j =0;j<nums.length;j++){
                if(nums[j]!=0 && nums[j]!=Integer.MAX_VALUE && nums[j]+i<=k){
                    ans=Math.min(ans, dp[ i+nums[j]]  );
                }
            }
            if(ans==Integer.MAX_VALUE){
                dp[i]=ans;
            }else{
               dp[i]=ans+1;
            }  
        }
        return dp[0];
    }
}