import java.util.Arrays;
import java.util.HashMap;

public class SumK{
    public static void main(String[] args) {
        int [] arr ={7,0,4,2,-7,3,5,7,0,9,3};
        int k =10;
        int[] ans = subArrayWithGivenSum(arr, k);
        if(ans!=null) System.out.println(Arrays.toString(ans));
    }

    public static int[] subArrayWithGivenSum(int []arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int [] ans = new int[2];
        map.put(0,-1);
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum+=arr[i];
            if(map.containsKey(sum-k)){
               ans[0]=map.get(sum-k)+1;
               ans[1]=i;
               return ans;
            }
            map.put(sum, i);
        }

        return null;

    }
}