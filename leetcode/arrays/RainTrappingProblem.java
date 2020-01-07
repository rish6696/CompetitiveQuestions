public class RainTrappingProblem{
    public static void main(String[] args) {
        // the brute force solution to this probelm is to calculate
       // the maximum value from 0 to i(A) and max from i(B) to end and calculate the 
       // sol= min(A,B)-arr[i];

       int [] arr={0,1,0,2,1,0,1,3,2,1,2,1};
       System.out.println(DpApproah(arr));
    }


    public static int DpApproah(int[]arr){
        int[] left=new int [arr.length];
        left[0]=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            left[i+1]=Math.max(left[i], arr[i]);
        }
        int j=arr.length-1;
        int memoMax=Integer.MIN_VALUE;
        int ans =0;
        while(j>=1){
            int rightMax=Math.max(memoMax, arr[j]);
            memoMax=rightMax;
            int leftMax=left[j];
            int tempAns=Math.min(rightMax, leftMax)-arr[j];
            ans +=  tempAns > 0 ?tempAns : 0 ;
            j--;
        }
        return ans;
    }
}



