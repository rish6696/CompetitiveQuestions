public class PeakElement{

    public static void main(String[] args) {
        int []arr={-2147483648,-2147483647};
        System.out.println(peak(arr));
    }

    public static int  peak(int []arr) {
        int low =0;
        int high =arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            int leftVal = mid==0?Integer.MIN_VALUE :arr[mid-1];
            int righVal= mid==arr.length-1 ?Integer.MIN_VALUE : arr[mid+1];
            if(arr[mid]>=leftVal &&arr[mid]>=righVal) return mid;
            else if(leftVal >=arr[mid] && arr[mid]!=Integer.MIN_VALUE) high=mid-1;
            else if(righVal >=arr[mid]) low=mid+1;
            else {
                low++;
                high--;
            }
        }
        return Integer.MAX_VALUE;
        
    }

}