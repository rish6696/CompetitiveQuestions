import java.util.Arrays;
import java.util.Comparator;

public class BuildingBridge {
    public static void main(String[] args) {

        int [][] arr ={ {6,2} ,{4,3},{2,6},{1,5}};

        Arrays.sort(arr , new Comparator<int []>(){
            @Override
            public int compare(int[]a,int []b){
                return a[1]-b[1];
            }
        } );


        System.out.println(LIS(arr));
        
    }


    public static int LIS(int [][]arr){
        int [] dp = new int [arr.length];
        Arrays.fill(dp, 1);
        int ans =1;
        for(int i=1;i<arr.length;i++){
            for(int j =i-1;j>=0;j--){
                if(arr[j][0]<=arr[i][0]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            ans=Math.max(ans, dp[i]);
        }

        return ans;
    }
}