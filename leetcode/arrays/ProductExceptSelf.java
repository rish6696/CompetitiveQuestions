import java.util.Arrays;

public class ProductExceptSelf{
    public static void main(String[] args) {
        int [] nums={2,3,2,4};
        int []ans=new int [nums.length];
        int []left =new int [nums.length];
        int mul=1;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                left[i]=mul;
            }else{
            left[i]=mul*nums[i-1];
            mul*=nums[i-1];
            }
        }
        mul=1;
       int  i=ans.length-1;
        while(i>=0){
            if(i==ans.length-1){
                ans[i]=left[i];
            }else{
                ans[i]=left[i]*mul*nums[i+1];
                mul*=nums[i+1];
            }
            i--;
        }
        System.out.println(Arrays.toString(ans));
    }


}