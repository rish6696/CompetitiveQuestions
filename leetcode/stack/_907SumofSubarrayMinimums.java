import java.util.Stack;
import java.util.Arrays;

public class _907SumofSubarrayMinimums{

    public static void main(String[] args) {
        int [] A ={71,55,82,55};
        System.out.println(sumSubarrayMins(A)); 
    }


    public static  int sumSubarrayMins(int[] A) {
        
        int [] left = nextSmallLeft(A);
        int [] right =nextSmallRight(A);


        for(int i =0;i<left.length;i++){
           left[i]= i-left[i];
        }


        for(int i =0;i<right.length;i++){
            right[i]= right[i]- i;
        }
        
        
        
        
        int sum =0;
        for(int i =0;i<A.length;i++){
            sum += A[i]*left[i]*right[i];
        }
        
        
        
        return sum % ( 7+ (int)(Math.pow(10,9))  );   
    }
    
    
    
    public static  int [] nextSmallLeft(int []A){
        int [] ans =new int [A.length];
        Arrays.fill(ans,-1);
        Stack<Integer> stack =new Stack<>();
        for(int i= A.length -1; i>=0 ; i-- ){
           int val  = A[i];
           while(!stack.isEmpty() &&  val < A[stack.peek()] ){
               int top =stack.pop();
               ans[top] = i;
           }            
           stack.push(i);
        }
        
        return ans;
    }
    

       public static  int [] nextSmallRight(int []A){
        int [] ans =new int [A.length];
        Arrays.fill(ans,A.length);
        Stack<Integer> stack =new Stack<>();
        for(int i=0 ; i < A.length; i++ ){
           int val  =  A[i];
           while(!stack.isEmpty() &&  val < A[stack.peek()] ){
               int top =stack.pop();
               ans[top]=i;
           }            
           stack.push(i);
        }
        return ans;
    }
}