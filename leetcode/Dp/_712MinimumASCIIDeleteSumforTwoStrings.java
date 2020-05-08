
public class _712MinimumASCIIDeleteSumforTwoStrings {
public static void main(String[] args) {
    System.out.println(minimumDeleteSum("sea", "eat"));
}

public static  int minimumDeleteSum(String s1, String s2) {
        
    int [][] dp = new int [s1.length()+1][s2.length()+1];
    
    int count =0;
    
    for(int i=s2.length()-1;i>=0;i--){
        count+= s2.charAt(i);
        dp[s1.length()][i]=count;
    }
    
    count =0;
    for(int i=s1.length()-1;i>=0;i--){
        count+= s1.charAt(i);
        dp[i][s2.length()]=count;
    }
    
    for(int i=s1.length()-1;i>=0;i--){
        for(int j=s2.length()-1;j>=0;j--){
            
            if(s1.charAt(i)==s2.charAt(j)){
                dp[i][j]= dp[i+1][j+1];
            }else{
                 dp[i][j]= Math.min(s1.charAt(i)+dp[i+1][j],  s2.charAt(j)+dp[i][j+1]);
            }
            
        }
    }
    
    return dp[0][0];
}

}