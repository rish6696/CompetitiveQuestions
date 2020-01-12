public class MinimumInRotatedArray{
    public static void main(String[] args) {
        int []arr={10,1,10,10,10};

        System.out.println(minValII(arr));
    }


    public static int minVal(int []arr){
        int left =0;
        int right =arr.length-1;
        int ans=Integer.MAX_VALUE;
        while(left<=right){
            int mid =(left+right)/2;
            if(arr[mid]> arr[left]&&arr[mid]< arr[right]){
                return Math.min(arr[left], ans);
            }else if(arr[mid]>=arr[left]){
                ans=Math.min(ans, arr[left]);
                left=mid+1;
            }else{
                ans=Math.min(ans, arr[mid]);
                right=mid-1;
            }
        }
        return ans;
    }


    public static int minValII(int []arr){
        int left =0;
        int right =arr.length-1;
        int ans=Integer.MAX_VALUE;
        while(left<=right){
            int mid =(left+right)/2;
            if(arr[mid]==arr[left]&&left!=mid){
                while(left<mid && arr[mid]==arr[left])left++;
            }
            if(arr[mid]==arr[right]&&right!=mid){
                while( right>mid && arr[mid]==arr[right])right--;
            }
            if(arr[mid]> arr[left]&&arr[mid]< arr[right]){
                return Math.min(arr[left], ans);
            }else if(arr[mid]>=arr[left]){
                ans=Math.min(ans, arr[left]);
                left=mid+1;
            }else{
                ans=Math.min(ans, arr[mid]);
                right=mid-1;
            }
        }
        return ans;
    }
}