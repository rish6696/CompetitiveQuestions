import java.util.Arrays;

public class ArrangeBuildings{
    public static void main(String[] args) {
        int n =6;
        int [] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(RECURSIVE_SOL_MEMO(n,dp));
        System.out.println(RECURSIVE_SOL_DP(n));
    }

    public static int RECURSIVE_SOL_MEMO(int n,int []dp){
        if(n==0){
            dp[n]=1;
            return 1;
        }
        if(n==1){
            dp[n]=2;
            return 2;
        }
        if(dp[n]!=-1) return dp[n];
        int ans =0;
        ans+=RECURSIVE_SOL_MEMO(n-2,dp);
        ans+=RECURSIVE_SOL_MEMO(n-1,dp);
        dp[n]=ans;
        return ans;
    }

    public static long RECURSIVE_SOL_DP(int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 2;
        }
        long a =1;
        long b =2;
        long ans=0;
        for(int i=2;i<=n;i++){
          ans=a+b;
          a=b;
          b=ans;
        }
        return ans;
    }

}