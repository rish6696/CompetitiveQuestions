import java.util.Arrays;

public class _768MaxChunksToMakeSortedII {
    public static void main(String[] args) {
        int []arr={4,2,2,1,1};
        System.out.println(solution(arr));      
    }

    public static int solution(int []arr){
        int [] min = new int[arr.length];
        int [] max = new int [arr.length];

        max[0]=arr[0];
        for(int i =1;i<arr.length;i++){
            max[i]=Math.max(max[i-1], arr[i]);
        }

        min[min.length-1]= arr[arr.length-1];
        for(int i =arr.length-2;i>=0;i--){
            min[i]=Math.min(min[i+1], arr[i]);
        }

        System.out.println(Arrays.toString(max));
        System.out.println(Arrays.toString(min));


        int count =1;
        for(int i =0;i<arr.length-1;i++){
            if(max[i]<=min[i+1]){
              count++;
            }
        }
        return count;
    }
}