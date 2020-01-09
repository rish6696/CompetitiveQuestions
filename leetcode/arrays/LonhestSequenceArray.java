import java.util.HashMap;
import java.util.HashSet;

public class LonhestSequenceArray{
    public static void main(String[] args) {
        int []arr={1, 9, 3, 10, 4, 20, 2};
        System.out.println(Solution(arr));
    }


    public static int Solution(int []arr){
        HashSet<Integer> map=new HashSet<>();
        int ans = 0;
        for (int i = 0; i < arr.length; i++) map.add(arr[i]);
        for (int i = 0; i < arr.length; i++) {
           int val=arr[i];
           int c=1;
           if(map.contains(val+1)){
                c++;
                int ref= val+2;
                while(map.contains(ref)){
                    c++;
                    ref++;
                }
                ans=Math.max(ans, c);
           }
        }
        return ans;
    }
}