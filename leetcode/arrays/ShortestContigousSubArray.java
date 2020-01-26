
public class ShortestContigousSubArray{
    public static void main(String[] args) {
        int [] nums={1,3,2,2,2};
        System.out.println(solution(nums));
    }



    public static boolean isSorted(int [] nums){
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]>nums[i+1])return false;
        }
        return true;
    }


    public static int solution(int []nums){
        int left =-1;
        int right =-1;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i+1]<nums[i]){
                left=i;
                break;
            }
        }

        for (int i = nums.length-1; i >=1; i--) {
            if(nums[i]<nums[i-1]){
                right=i;
                break;
            }
        }
        if(left==-1&& right ==-1)return 0;
        int max=Integer.MIN_VALUE;
        int min =Integer.MAX_VALUE;
        for (int i = left; i <= right;i++) {
            max =Math.max(max, nums[i]);
        }
        for (int i = left; i <= right;i++) {
            min =Math.min(min, nums[i]);
        }
        for(int i=0;i<=left-1;i++){
            if(nums[i]>min){
                left=i;
            }
        }
        for(int i=right+1;i<nums.length;i++){
            if(nums[i]<max){
                right=i;
            }
        }

        return right-left+1;     
        
    }

}