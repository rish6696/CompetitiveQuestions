public class editDistance{
    public static void main(String[] args) {

        String m ="sundaybjgjdbgjkdbjdkkdsfsnskgneknkdngkngkdngkdngdkngkdngkdbsmgsjbjbnzknkbkdbnkddkbneirkln";
        String n ="saturdaygndgndgnekgnekngkdnvirengeiongbkndnskjvsjsvvsnsinvksnvskneknldnbnnekigedknkdfnkdngkdngieiknkignbdkndibndbdnkn";

        System.out.println(editDistanceMin(m.length()-1, n.length()-1, m, n));
       // System.out.println(editDistanceMinDp(m, n));


    }



    public static int editDistanceMinDp(String ms,String ns){

        int [][] dp = new int [ms.length()+1][ns.length()+1];

        for(int m=0;m<dp.length;m++){

            for(int n=0;n<dp[0].length;n++){

                if(n==0&&m==0){
                    dp[m][n]=0;
                    continue;
                }
                if(n==0){
                    dp[m][n]=m;
                    continue;
                }
                if(m==0){
                    dp[m][n]=n;
                    continue;
                }
        
                if(ms.charAt(m-1)==ns.charAt(n-1)){
                    dp[m][n]= dp[m-1][n-1];
                    continue;
                } 
        
                int ans = Integer.MAX_VALUE;
        
                //insert 
                ans=Math.min(ans, dp[m] [n-1]);
                //remove 
                ans=Math.min(ans, dp[m-1][n]);
                //replace 
                ans =Math.min(ans, dp[m-1][n-1]);

                dp[m][n]=ans+1; 
            }

        }

        return dp[ms.length()][ns.length()];
    }


    public static int editDistanceMin(int m,int n,String ms,String ns){

        if(n==-1&&m==-1) return 0;
        if(n==-1&&m>=0) return m+1;
        
        if(m==-1&&n>=0) return n+1;

        if(ms.charAt(m)==ns.charAt(n)) return editDistanceMin(m-1, n-1, ms, ns);

        int ans = Integer.MAX_VALUE;

        //insert 
        ans=Math.min(ans, editDistanceMin(m, n-1, ms, ns));
        //remove 
        ans=Math.min(ans, editDistanceMin(m-1, n, ms, ns));
        //replace 
        ans =Math.min(ans, editDistanceMin(m-1, n-1, ms, ns));

        return ans+1;
    }
}