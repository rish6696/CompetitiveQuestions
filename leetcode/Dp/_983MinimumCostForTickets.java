import java.util.Arrays;

public class _983MinimumCostForTickets {

   static  int [] valid = {30,7,1};
    public static void main(String[] args) {
        int [] days ={1,2,3,4,5,6,7,8,9,10,30,31};
        int [] costs ={15,7,2};
    //  System.out.println(mincostTickets(days, costs));
      System.out.println(solDP(days, costs));
    }
  public static  int mincostTickets(int[] days, int[] costs) {

    int [][] dp = new int [days.length+1][365+1+30];
    for(int []a:dp) Arrays.fill(a, Integer.MAX_VALUE);
    return sol(0,-1,days,costs,dp);
  }


  public static  int solDP(int[]days,int[]costs){

    int [][] dp = new int [days.length+1][365+1+30];

    for(int idx =dp.length-1;idx>=0;idx--){
        for(int validTill=dp[0].length-1;validTill>=0;validTill--){

            if(idx==days.length){
                dp[idx][validTill]=0;
                continue;
            }

            if(validTill>=days[idx]){
                dp[idx][validTill]= dp[idx+1][validTill];
                continue;
            } 

            int ans = Integer.MAX_VALUE;
    
            for(int i =0;i<costs.length;i++){
                int recAns = dp[idx+1][days[idx]+valid[i]-1];
                ans=Math.min(ans,costs[i]+recAns);
            }
            dp[idx][validTill]=ans;
        }
    }
    return dp[0][0];
}


public static  int sol(int idx,int validTill,int[]days,int[]costs,int [][]dp){

    if(dp[idx][validTill+1]!=Integer.MAX_VALUE) return dp[idx][validTill+1];
    
    if(idx==days.length){
        dp[idx][validTill+1]=0;
        return 0;
    }
    
    if(validTill>=days[idx]){
       dp[idx][validTill+1]= sol(idx+1,validTill,days,costs,dp);
       return dp[idx][validTill+1];
    }  
    
    int ans = Integer.MAX_VALUE;
    
    for(int i =0;i<costs.length;i++){
        int recAns = sol(idx+1,days[idx]+valid[i]-1,days,costs,dp);
        ans=Math.min(ans,costs[i]+recAns);
    }
    dp[idx][validTill+1]=ans;
    return ans;
}

}
