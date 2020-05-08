import java.util.Arrays;
public class _1048LongestStringChain {
    public static void main(String[] args) {
        String [] words ={"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        System.out.println(longestStrChain(words));
    }


    public static boolean isPre(String word1,String word2){
        if(word1.length()>=word2.length()) return false;
        int i=word1.length()-1;
        int j = word2.length()-1;
        
        boolean flag =false;
        
        while(i>=0&&j>=0){
            if(word1.charAt(i)==word2.charAt(j)){
                i--;
                j--;
            }
            else{
                if(flag) return false;
                j--;
                flag =true;
            }
        }
        
        return true;
        
    } 
    
    public static  int longestStrChain(String[] words) {
        int [] dp = new int [words.length];
        Arrays.fill(dp,1);
        int ans =1;
        for(int i=1;i<words.length;i++){
            for(int j =i-1;j>=0;j--){
                if(isPre(words[j],words[i])){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}