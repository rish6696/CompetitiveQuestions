public class SubArraySum{
    public static void main(String[] args) {

        int arr[] = {1,4,20,3,10,5};  
        int sum = 18; 
        int []ans=sumArraySum(arr, sum);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(arr[i]+" ");
        }
       
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

  
}