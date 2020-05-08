import java.util.Arrays;
public class _1235MaximumProfitinJobScheduling {
   public static void main(String[] args) {

       int [] start =  {6,15,7,11,1,3,16,2};
       int [] end ={19,18,19,16,10,8,19,8};
       int [] profit = {2,9,1,19,5,7,3,19};
       System.out.println(jobScheduling(start, end, profit));
   }
   public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
    Pair[] arr = new Pair[profit.length];
    for(int i =0;i<profit.length;i++){
        arr[i]= new Pair(startTime[i],endTime[i],profit[i]);
    }
    Arrays.sort(arr);
    
    int [] dp = new int [profit.length];
    dp[0]= arr[0].profit;
    int ans =Integer.MIN_VALUE;
    for(int i =1;i<dp.length;i++){
        dp[i]= arr[i].profit;
        for(int j =i-1;j>=0;j--){
            if(arr[i].start>=arr[j].end){
                dp[i]=Math.max(dp[i],arr[i].profit+dp[j]);
            }
        }
        ans=Math.max(ans,dp[i]);
    }
    
    return ans;
    
    
}

public static class Pair implements Comparable<Pair> {
    int start;
    int end;
    int profit;
    public Pair(int start,int end,int profit){
        this.start =start;
        this.end = end;
        this.profit =profit;
    }
    @Override
    public int compareTo(Pair o){
        if(this.start==o.start) return this.end - o.end;
        return this.start-o.start;            
    }
}
}