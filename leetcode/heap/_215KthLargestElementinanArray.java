public class _215KthLargestElementinanArray{
    public static void main(String[] args) {

        int f = 1;
        int s =2;
        double d = (double) (f+s)/2;
        System.out.println(d);




    //     int [] nums = {3,2,1,5,6,4};
    //     int k =5;
    //     System.out.println(findKthLargest(nums, k));
    // 
    }


    public static int findKthLargest(int[] nums, int k) {
        
        
        int aIdx = nums.length-k;
        
        int left =0;
        int right = nums.length-1;
        
        while(left <= right ){
            int p = partition(nums,left,right);
            if(p ==aIdx) return nums[p]; 
            if(p >aIdx)  right = p-1;
            else left =p+1;
        }
        
        
        return -1;
    }
    

    public static int partition(int [] arr,int si ,int ei){
        swap(arr,si,ei);
        int pivot = arr[ei];
        int pIndex =si;
        for(int i =si;i<ei;i++){
            if(arr[i] <= pivot ){
                swap(arr,i,pIndex);
                pIndex++;
            }
        }
        
        swap(arr,pIndex,ei);
        
        return pIndex;
        
    }
    
    public static void swap(int [] arr,int i ,int j){
        if(i ==j ) return ;
        arr[i]^=arr[j];
        arr[j]^=arr[i];
        arr[i]^=arr[j];
    }
}