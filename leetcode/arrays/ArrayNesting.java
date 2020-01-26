public class ArrayNesting{
    public static void main(String[] args) {
        int [] nums={5,4,0,3,1,6,2};
        System.out.println(arrayNesting(nums));
    }
    public static  int arrayNesting(int[] nums) {
        
        //boolean [] visited =new boolean [nums.length];
        int ans =Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int c=0;
            int start =i;
            while(nums[start]!=Integer.MAX_VALUE){
                int startCopy =start;
                c++;
                start=nums[start];
                nums[startCopy]=Integer.MAX_VALUE;
               
            }
            ans=Math.max(ans,c);
        }
        
        return ans;
        
    }


}