import java.util.Stack;
import java.util.Map.Entry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class _735AsteroidCollision{
    public static void main(String[] args) {


        Map<Integer,Integer> mapper =new HashMap<>();
        Set < Map.Entry<Integer,Integer> > entries =mapper.entrySet();
        

        int [] arr ={-2,-1,1,2};
        int [] ans =asteroid(arr);
        System.out.println(Arrays.toString(ans));
    }


    public static int [] asteroid(int []arr){
        Stack<Integer> stack =new Stack<>();
        for (int i = 0; i < arr.length; i++) {

            int val =arr[i];
            int flag =0;
            while( !stack.empty() && val <0 && stack.peek() >0 ){
                if( Math.abs(val) > stack.peek() ){
                    stack.pop();
                }else if(Math.abs(val)==stack.peek()){
                    stack.pop();
                    flag=1;
                    break;
                }else{
                    flag=1;
                    break;
                }
            }
            if(flag==1) continue;
            stack.push(val);
            // if(stack.isEmpty() || arr[i] > 0 || arr[i] <0 && stack.peek()< 0 ) stack.push(arr[i]);     
        }

        int [] ans =new int [stack.size()];
        int i =ans.length-1;
        while(!stack.isEmpty()){
            int a =stack.pop();
            ans[i]=a;
            i--;
        }
        return ans ;




    }
}