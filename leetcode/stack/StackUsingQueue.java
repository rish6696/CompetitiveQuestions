import java.util.LinkedList;
public class StackUsingQueue{


    LinkedList<Integer> queue ;

    /** Initialize your data structure here. */
    public StackUsingQueue() {
        queue =new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.addLast(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        adjust();
        return queue.removeFirst();
        
    }
    
    /** Get the top element. */
    public int top() {
         adjust();
        return queue.getFirst();
        
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size()==0;
        
    }
    
    
    public void adjust(){
        int size =queue.size();
        for(int i =1;i<size;i++){
            int a =queue.removeFirst();
            queue.addLast(a);
        }
    }

}