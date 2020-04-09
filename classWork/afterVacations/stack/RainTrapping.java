
import java.util.Stack;

public class RainTrapping{
    public static void main(String[] args) {
        int [] arr ={6,3,4,2,1,6,3,2,8};
        System.out.println(trap(arr));

        
        
    }

    public static int trap(int[] height) {
        
        if(height.length==0) return 0 ;
        Stack<Integer> stack =new Stack<>();
        int ans =0;
        stack.push(0);
        
        for(int i =1;i< height.length;i++){
            int val =height[i];
            while(stack.size() >1 && val > height[stack.peek()] ){
                int idx =stack.pop();
                int width = i -stack.peek()-1;
                int minH=Math.min( val,height[stack.peek()] );
                ans += width* ( minH- height[idx] ) ; 
            }
            stack.push(i);
        }
        return ans;
    }
}