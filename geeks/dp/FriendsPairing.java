
public class FriendsPairing {

    // https://www.geeksforgeeks.org/friends-pairing-problem/
    public static void main(String[] args) {
        int n =5;
        System.out.println(friendsPairing(n));
    }


    public static int friendsPairing(int n){
        if(n==0) return 1;
        if(n==1) return 1;
        int[] dp = new int [n+1];
        dp[0]= 1;
        dp[1]=1;
        for(int i =2;i<dp.length;i++){
            dp[i]= dp[i-1]+ (i-1)*dp[i-2]; 
        } 

        return dp[n];
    }
}