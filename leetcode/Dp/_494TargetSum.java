import java.util.Arrays;
public class _494TargetSum {
public static void main(String[] args) {
    int S = 0;
    int [] nums ={1,2,1};
    int sum = sum(nums);
    int [][] dp = new int [(sum*2)+1][nums.length+1];
    for(int i =0;i<dp.length;i++){
        Arrays.fill(dp[i],-1);
    }
    System.out.println(solDP(nums,S,sum));

}


  
public static int sum(int []nums){
    int sum =0;
    for(int i =0;i<nums.length;i++) sum+=nums[i];
    return sum;
}

public  static int solDP(int []nums,int k,int s){
    int [][] dp = new int [nums.length+1][(s*2)+1];
    for(int idx =dp.length-1;idx>=0;idx--){
        for(int sum =dp[0].length-1;sum>=0;sum--){
            
        int negSum= sum > s ? s-sum : sum;
            
            
     if(idx==nums.length){
        if(negSum==k){
            dp[idx][sum]=1;
            continue;
        } 
        dp[idx][sum]=0;
        continue;
        
     }
            
            
    int ans =0;
    int sumIdxa = negSum + nums[idx];
    int sumIdxb = negSum - nums[idx];
    
    int sumA = sumIdxa >= 0 ? sumIdxa : Math.abs(sumIdxa)+s;
    int sumB = sumIdxb >= 0 ? sumIdxb : Math.abs(sumIdxb)+s;
            
    if(sumA<dp[0].length) ans+= dp[idx+1][sumA];
    if(sumB<dp[0].length) ans+= dp[idx+1][sumB];
    
    dp[idx][sum]=ans;                
        }
    }
    
    return dp[0][0];
}


public static int sol(int idx ,int [] nums,int sum,int k, int [][] dp,int s){
        
    int sumIdx = sum >= 0 ? sum : Math.abs(sum)+s;
    
    if(dp[sumIdx][idx]!=-1) return dp[sumIdx][idx];
    
    if(idx==nums.length){
        if(sum==k){
            dp[sumIdx][idx]=1;
            return 1;
        } 
        dp[sumIdx][idx]=0;
        return 0;
        
    }
    
    
    int ans =0;
    ans+= sol(idx+1,nums,sum+nums[idx],k,dp,s);
    ans+=sol(idx+1,nums,sum-nums[idx],k,dp,s);
    
    dp[sumIdx][idx]=ans;
    return ans;
}
}
