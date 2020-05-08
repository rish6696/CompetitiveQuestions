import java.util.Arrays;
import java.util.Comparator;

public class BoxStacking  {


  
  
   public static void main(String[] args) {
       int [][] arr ={ {4, 6, 7}, {1, 2, 3}, {4, 5, 6}, {10, 12, 32} }; 

       int [][] newarr = new int [arr.length*3][3];

       int idx =0;
       for (int i = 0; i < arr.length;i++) {
           int[] a = arr[i];

           newarr[idx][0]=a[0];
           newarr[idx][1]=Math.min(a[1], a[2]);
           newarr[idx][2]=Math.max(a[1], a[2]);
           idx++;


           newarr[idx][0]=a[1];
           newarr[idx][1]=Math.min(a[0], a[2]);
           newarr[idx][2]=Math.max(a[0], a[2]);
           idx++;


           newarr[idx][0]=a[2];
           newarr[idx][1]=Math.min(a[0], a[1]);
           newarr[idx][2]=Math.max(a[0], a[1]);
           idx++;
       }

       Arrays.sort(newarr, new Comparator<int[]>(){   
        public int compare(int []x,int[]y){
            return y[1]*y[2] - x[1]*x[2];
        }
       });

       System.out.println(LIS(newarr));
   }

   public static int LIS(int [][]arr){
    int [] dp = new int [arr.length];
    dp[0] = arr[0][0];
    int ans =Integer.MIN_VALUE;
    for(int i=1;i<arr.length;i++){
        dp[i]=arr[i][0];
        for(int j =i-1;j>=0;j--){
            if(arr[i][1] < arr[j][1] &&  arr[i][2]<arr[j][2] ){
                dp[i]=Math.max(dp[i], arr[i][0]+dp[j]);
            }
        }
        ans=Math.max(ans, dp[i]);
    }
    return ans;
}

}