
import java.util.Stack;

public class CustomStack {
    
    int [] arr ;
    int top =-1;
    int size=0;
    

    public CustomStack(int maxSize) {
        this.arr =new int [maxSize];
        this.size =0;
        this.top =-1;
        
    }
    
    public void push(int x) {
        if( this.size == arr.length ) return ;
        this.top++;
        arr[top]=x;
        this.size ++;
        
    }
    
    public int pop() {
        if(top ==-1 ) return -1;
        int val =arr [top];
        arr[top]=0;
        this.size--;
        this.top--;
        return val;
        
    }
    
    public void increment(int k, int val) {
        
        Stack<Integer> temp =new Stack<>();
        while(this.size!=0){
            temp.push(this.pop());
        }
        
        while(!temp.isEmpty() ){
           if( k>0 ) this.push(temp.pop() + val ); 
           else this.push(temp.pop());
            k--;                    
        }
        
    }
}