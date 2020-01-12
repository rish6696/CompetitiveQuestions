public class MinimumSizeSubArray {

    public static void main(String[] args) {
        int []arr={2,3,1,2,4,3};
        System.out.println(minimMumSizeSubArray(arr, 7));
    }

    public static int minimMumSizeSubArray(int []arr,int k ){
        int ans=arr.length+1;
        int start=0;
        int end =0 ;
        int cuurSum =0;
        while(end<arr.length){
            while(cuurSum<k&&end<arr.length){
                cuurSum+=arr[end];
                end++;
            }

            while(cuurSum>=k&&start<arr.length){
                ans=Math.min(ans, end-start);
                cuurSum-=arr[start];
                start++;
            }
        }

        return ans;


    }
}