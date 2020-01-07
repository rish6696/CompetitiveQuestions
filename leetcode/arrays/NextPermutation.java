import java.util.Arrays;

public class NextPermutation {
  public static void main(String[] args) {

    int [] nums={3,2,1};
    nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
      
  }

  public static void nextPermutation(int[]nums){

    int i=nums.length-2;
    while(i>=0&&nums[i]>=nums[i+1]){
        i--;
    }
    int j=nums.length-1;
    if(i>=0){
    while(j>=0&&nums[j]<=nums[i]){
        j--;
    }
    swap(nums, i, j);
    } 
    reverse(nums, i+1, nums.length-1);
    
  }

  public static void reverse(int[] nums,int start,int end){
      int i=start;
      int j=end;
      while(i<j){
          swap(nums, i, j);
          i++;
          j--;
      }
  }

  public static void swap(int [] nums,int i,int j){
      nums[i]^=nums[j];
      nums[j]^=nums[i];
      nums[i]^=nums[j];
  }
}