import java.util.Arrays;
public class PallindromePartition {


    public static void main(String[] args) {
        String str = "aabc";
        boolean [] [] isP = isPallindrome(str);
        System.out.println( minCut(str,isP) );
        System.out.println(minCutPallindromePartitionDP(str, isP));
    }

       

    public static  int minCut(String s,boolean[][] isP) {
        
       
        for (int i = 0; i < isP.length; i++) {
            System.out.println(Arrays.toString(isP[i]));
        }
        int [] dp = new int [s.length()];
        Arrays.fill(dp,Integer.MAX_VALUE);
        return minCutPallindromePartition(s,0,isP,dp);  
       
   }
   

    
   public static  boolean [][] isPallindrome(String str){
   boolean [][] dp = new boolean [str.length()] [str.length()];
   int ans =-1;
   for(int gap=0;gap<str.length();gap++){
       int i =0;
       int j =gap;
       while(j<dp.length){
           if(gap==0) dp[i][j]=true;
           else {
              if(str.charAt(i)==str.charAt(j)){
                  if(gap==1) dp[i][j]=true;
                  else if(dp[i+1][j-1]==true) dp [i][j]=true;
                  else dp[i][j]=false;
              }
              else{
                  dp[i][j]=false;
              }
           }
           i++;
           j++;
       }
   }
   return dp;
}
   
public static int minCutPallindromePartitionDP(String str,boolean [][]isPallin){
    int [] dp = new int [str.length()+1];

    for(int idx=dp.length-1;idx>=0;idx--){
        if(idx==str.length()) {
            dp[idx]=-1;
            continue;
        }
        int ans =Integer.MAX_VALUE;
        for(int end =idx;end<str.length();end++){ 
            if( isPallin[idx][end]==true){
            ans=Math.min(ans,dp[end+1]);
            }
        }
        dp[idx]=ans+1;
    }

    return dp [0];
}
   
 public static  int minCutPallindromePartition(String str ,int idx,boolean [][] isPallin ,int []dp){
   if(idx>=str.length()) return -1;
       
   if(dp[idx]!=Integer.MAX_VALUE) return dp[idx];

   int ans =Integer.MAX_VALUE;
   for(int end =idx;end<str.length();end++){
       
       if( isPallin[idx][end]==true){
       ans=Math.min(ans,minCutPallindromePartition(str,end+1,isPallin,dp));
       }
   }
   dp[idx]=ans+1;
   return ans+1;
}



}