import java.util.Arrays;

public class LCS3String {

    public static void main(String[] args) {
        String  a ="abcd1e2";
        String b ="bc12ea";
        String c ="bd1ea";


        System.out.println(sol(a, b, c));


        
    }



    public static int sol(String a,String b ,String c){
        int [][][] dp = new int [a.length()+1][b.length()+1][c.length()+1];
        for(int i =dp.length-1;i>=0;i--){
            for(int j =dp[0].length-1;j>=0;j--){
                for (int k = dp[0][0].length-1; k >= 0; k--) {
                    if(i==a.length()||j==b.length()||k==c.length()){
                        dp[i][j][k]=0;
                        continue;
                    }
                    if(a.charAt(i)==b.charAt(j)&&b.charAt(j)==c.charAt(k)){
                        dp[i][j][k]= 1+dp[i+1][j+1][k+1];
                    }else{
                        dp[i][j][k]= Math.max(dp[i+1][j][k], Math.max(dp[i][j+1][k], dp[i+1][j][k+1]));
                    }

                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(Arrays.toString(dp[i][j])+" ");
            }
            System.out.println();
        }


        return dp[0][0][0];
    }

}