import java.util.Arrays;
import java.util.Comparator;

public class _1124LongestWellPerformingInterval{
    public static void main(String[] args) {
        int [][] presum =new int [3][3];

        Arrays.sort(presum, new Comparator<int []>() {
            @Override
            public int compare(int [] a,int []b){
                if(a[0]==b[0]) return a[1] - b[1];
                return a[0] - b[0];
            }
        } );
    }
}