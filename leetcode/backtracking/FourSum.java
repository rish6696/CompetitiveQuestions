import java.util.*;
public class FourSum {
    public static void main(String[] args) {
        int[] nums={-3,-2,-1,0,0,1,2,3};
    


        
        ArrayList<ArrayList<Integer>> big=new ArrayList<>();
        iterativeApproach(nums,big,0);
        System.out.println(big);
    }

    public static void iterativeApproach(int[] nums,ArrayList<ArrayList<Integer>>bigList,int m){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for(int j=i+1;j<nums.length;j++){
            if(i==0||nums[i-1]!=nums[i]){

                if(j==i+1||nums[j]!=nums[j-1]){

             int val =nums[i];
             int target=m-(val)-nums[j];
             int left=j+1;
             int right=nums.length-1;
             while(left<right){
                 int newSum=nums[left]+nums[right];
                 if(newSum<target){
                     left++;
                 }else if(newSum>target){
                     right--;
                 }else{
                     ArrayList<Integer> temp=new ArrayList<>();
                     temp.add(val);
                     temp.add(nums[j]);
                     temp.add(nums[left]);
                     temp.add(nums[right]);
                     bigList.add(temp);
                     while(left<right&&nums[left]==nums[left+1]) left++;
                     while(left<right&&nums[right]==nums[right-1])right--;
 
                     left++;
                     right--;
 
                 }
             }
            }
        }
 
        }
     }
    }

}


