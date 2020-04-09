
import java.util.Stack;
public class _331VerifyPreorderSerializationofaBinaryTree{
    public static void main(String[] args) {
        String str ="9,3,4,#,#,1,#,#,#,2,#,6,#,#";
        System.out.println(isValidSerialization(str));

        
    }


    public static boolean isValidSerialization(String preorder) {
        Stack<Integer> stack =new Stack<>();
        
        int i =0;
        while(i <preorder.length() ){

            if( stack.size()==1  && stack.peek()==2 ) return false;


            char cc =preorder.charAt(i);
            
            if(preorder.charAt(i)!=','){
            
                 while(!stack.isEmpty() && stack.peek()==2) stack.pop();
                 if(stack.isEmpty()) {
                    stack.push(0);
                    i=returnNum(preorder,i);
                    continue;
                }
                
                if(preorder.charAt(i)=='#'){
                    
                int top =stack.pop();
                stack.push(top+1);
                i++;
                    
                }else{
                int top =stack.pop();
                stack.push(top+1);
                stack.push(0);
                i=returnNum(preorder,i);  
                }
                
                    
            }else{
            
            i++;
            }
           
            
        }
        
         while(!stack.isEmpty() && stack.peek()==2) stack.pop();
        return stack.isEmpty();
        
        
    }
    
    public static int  returnNum(String str,int start){
           int i =start+1;
           while(i<str.length() && str.charAt(i)!=','){
               i++;
           }
           return i+1;
       }
}