public class SubArraySum{
    public static void main(String[] args) {

        int arr[] = {-1,-1,1};  
        int sum = 0; 
        System.out.println(noOfSubArray(arr, sum));
        // int []ans=sumArraySum(arr, sum);
        // for (int i = 0; i < ans.length; i++) {
        //     System.out.print(arr[i]+" ");
        // }
       
    }

    public static int[] sumArraySum(int []arr,int k){
        int start=0;
        int currSum=arr[0];
        int[]ans=new int [2];
        for (int i = 1; i <= arr.length; i++) {
            while(currSum > k && start < i-1){
                currSum-=arr[start];
                start++;
            }
            if(currSum==k){
                arr[0]=start;
                arr[1]=i-1;
            }
            if(i<arr.length) currSum+=arr[i];
        }
        return ans;
    }


    public static int noOfSubArray(int[]arr,int k){
        int start=0;
        int sum =arr[0];
        int ans =0;
        for (int i = 1; i <= arr.length; i++) {
            while(sum>k&& start<i-1){
                sum-=arr[start];
                start++;
            }
            if(sum ==k){
                ans++;
                start++;
                if(start<arr.length)sum =arr[start];
                i=start+1;
            }
            if(i<arr.length) sum+=arr[i];
        }

        return ans ;
    }

  
}