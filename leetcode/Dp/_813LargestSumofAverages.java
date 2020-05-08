import java.util.Arrays;

public class _813LargestSumofAverages {
    public static void main(String[] args) {
       int []A= {4663,3020,7789,1627,9668,1356,4207,1133,8765,4649,205,6455,8864,3554,3916,5925,3995,4540,3487,5444,8259,8802,6777,7306,989,4958,2921,8155,4922,2469,6923,776,9777,1796,708,786,3158,7369,8715,2136,2510,3739,6411,7996,6211,8282,4805,236,1489,7698};
        int K= 27;
        // int []A={9,1,2,3,9};
        // int K =3;
        System.out.println(largestSumOfAverages(A, K));
    }
    public static  double largestSumOfAverages(int[] A, int K) {
        int [] prefix = new int [A.length];
        
        prefix[0]= A[0];
        for(int i =1;i<prefix.length;i++){
            prefix[i] = prefix[i-1]+A[i];
        }
        return solDP(K, prefix);

        // double [][] dp= new double[prefix.length][K+1];
        // for(double []a:dp) Arrays.fill(a, Double.NEGATIVE_INFINITY);
        
        
        
        // double ans =sol(0,K,prefix,dp);
        // for(double []b:dp)  System.out.println(Arrays.toString(b));
        // return ans;
    }
    
    
    public static  double getSum(int []prefix,int start,int end){
        if(start==0)  return prefix[end];
        return prefix[end]-prefix[start-1];
    }


    public static double solDP(int K,int[] prefix){


        double [][] dp = new double[prefix.length][K];

        for(int idx = dp.length-1;idx>=0;idx--){
            for(int k=dp[0].length-1;k>=0;k--){
                if(k==0){
                    double c = prefix.length-idx;
                    double s= getSum(prefix,idx,prefix.length-1);
                    double a = s/c;
                    dp[idx][k]=a;
                    continue;
                }

                if(idx==prefix.length-1){
                    dp[idx][k]=Double.NEGATIVE_INFINITY;
                    continue;
                }
                double ans = Double.NEGATIVE_INFINITY;
                for(int cut = idx ;cut<=prefix.length-2;cut++){
                    double recAns = dp[cut+1][k-1];
                    if(recAns!=Double.NEGATIVE_INFINITY){
                        double s = getSum(prefix,idx,cut);
                        double c = cut-idx+1;
                        double mySum = s/c;
                        ans=Math.max(ans,mySum+recAns);
                    }
                }
                dp[idx][k]=ans;
            }
        }
        return dp[0][K-1];
    }
    
    public static double sol(int idx, int k,int[] prefix,double [][] dp){

        if(dp[idx][k]!=Double.NEGATIVE_INFINITY){
            System.out.println("returned from dp");
            return dp[idx][k];
        }

        if(k==1){
            double c = prefix.length-idx;
            double s= getSum(prefix,idx,prefix.length-1);
            double a = s/c;
            dp[idx][k]=a;
            return a;
        }
        
        if(idx==prefix.length-1){
            return Double.NEGATIVE_INFINITY;
        }
        
        double ans = Double.NEGATIVE_INFINITY;
        for(int cut = idx ;cut<=prefix.length-2;cut++){
            double recAns = sol(cut+1,k-1,prefix,dp);
            if(recAns!=Double.NEGATIVE_INFINITY){
                double s = getSum(prefix,idx,cut);
                double c = cut-idx+1;
                double mySum = s/c;
                ans=Math.max(ans,mySum+recAns);
            }
        }
        dp[idx][k]=ans;
        return ans;
    }
}