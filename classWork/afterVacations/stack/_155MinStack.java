import java.util.Stack;
public class _155MinStack{
    Stack<Integer> stack ;
    int min =Integer.MAX_VALUE;
 

    /** initialize your data structure here. */
    public _155MinStack() {
        stack =new Stack<>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(x);
            this.min=x;
        }
        else if(x >=this.min ) stack.push(x);
        else{
            int toadd = x -this.min + x;
            this.min=x;
            stack.push(toadd);
        }
        
    }
    
    public void pop() {
        if(this.min < stack.peek() )  stack.pop();
        else{
            int a =stack.pop();
            min = min -a+min;
        } 
        
        if(stack.isEmpty()) min =Integer.MAX_VALUE;
    }
    
    public int top() {
        if(stack.peek() <min ) return min;
        return stack.peek();
        
    }
    
    public int getMin() {
        return min;   
    }
}