public class MedianSortedArray {
    public static void main(String[] args) {
        int [] nums1={2};
        int [] nums2 ={ 1,3 };
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }


    //  public static double findMedianSortedArrays(int[] arr, int[] brr) {
        
    //      if(arr.length>brr.length){
    //         return findMedianSortedArrays(brr, arr);
    //     }
    //     int x=arr.length;
    //     int y= brr.length;
    //     int low=0;
    //     int high=arr.length;

    //     while(low<=high){
    //     int px=(low+high)/2;
    //     int py=((x+y+1)/2)-px;

    //     int leftX=  px==0?Integer.MIN_VALUE:arr[px-1];
    //     int rightX= px==x?Integer.MAX_VALUE:arr[px];

    //     int leftY=  py==0?Integer.MIN_VALUE:brr[py-1];
    //     int rightY= py==y?Integer.MAX_VALUE:brr[py];

    //     if(leftX<=rightY&& leftY<=rightX){
    //         return (x+y)%2==0? ((double)( Math.min(rightX, rightY)+Math.max(leftX, leftY))/2):
    //         (double)Math.max(leftX, leftY);
    //     }else if(leftX>rightY){
    //         high=px-1;
    //     }
    //     else {
    //         low=px+1;
    //     }
    // }

    // return -9.9;   
    // }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int val = (nums1.length + nums2.length + 1) / 2;
        int s = 0;
        int e = nums1.length;
        int px = 0;
        int py = 0;

        int lx = 0;
        int rx = 0;
        int ly = 0;
        int ry = 0;

        while (s <= e) {
            px = (s + e) / 2;
            py = val - px;

            lx = px == 0 ? Integer.MIN_VALUE : nums1[px - 1];
            rx = px == nums1.length ? Integer.MAX_VALUE : nums1[px];

            ly = py == 0 ? Integer.MIN_VALUE : nums2[py - 1];
            ry = py == nums2.length ? Integer.MAX_VALUE : nums2[py];

            if (lx <= ry && ly <= rx) {
                if (((nums1.length + nums2.length) & (1 << 0)) == 0) {
                    return 1.0 * (Math.max(lx, ly) + Math.min(rx , ry)) / 2;
                } else {
                    return 1.0 * (Math.max(lx, ly));
                }
            } else if (lx > ry) {
                e = px - 1;
            } else {
                s = px + 1;
            }

        }

        return 1.0;

    }

}