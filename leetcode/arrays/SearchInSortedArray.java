public class SearchInSortedArray{
    public static void main(String[] args) {
        int [] arr={96,94,};
        System.out.println(searchSorted(arr, 3));
        
    }

    public static int searchSorted(int []arr,int target){
        int low=0;
        int high=arr.length-1;
        while(low <= high){
           int mid=(low+high)/2;
           if(arr[mid]==target)return mid;
           else if(arr[mid]>=arr[low]){
                if(target>=arr[low]&&target<arr[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
           }else {
            if(target>arr[mid]&&target<=arr[high]){
                low=mid+1;
            }else{
                high=mid-1;
            }
           }
        }
        return -1;
    }
}