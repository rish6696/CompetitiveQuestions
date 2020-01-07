
import java.util.*;
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums={-2,0,0,2,2};
        
        ArrayList<ArrayList<Integer>> big=new ArrayList<>();
        iterativeApproach(nums,big);
        System.out.println(big);

       // Arrays.sort(nums);
        
        // List<List<Integer>> bigAns=new ArrayList<>();
        // List<Integer> temp=new ArrayList<>();
        // solution(nums,bigAns,temp,0);
        // System.out.println(bigAns);
    }

    public static void iterativeApproach(int[] nums,ArrayList<ArrayList<Integer>>bigList){
       Arrays.sort(nums);
       for (int i = 0; i < nums.length; i++) {
           if(i==0||nums[i-1]!=nums[i]){
            int val =nums[i];
            int target=0-(val);
            int left=i+1;
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

     
    public static int calSum(List<Integer> arr){
        int sum=0;
        for(Integer a:arr){
            sum+=a;
        }
        return sum;
    }
    
    
    public static void solution(int [] nums,List<List<Integer>>bigAns,List<Integer>tempans,int start){
        if(tempans.size()==3){
            if(calSum(tempans)==0){
                List<Integer> base=new ArrayList<>();
                base.addAll(tempans);
                bigAns.add(base);
                return ;
                
            }
            return ;
        }
        for(int i=start;i<nums.length;i++){
           if(i==start|| nums[i]!=nums[i-1]){
            tempans.add(nums[i]);
            solution(nums,bigAns,tempans,i+1);
            tempans.remove(tempans.size()-1);
           }
        }
    }
}