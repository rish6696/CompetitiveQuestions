import java.util.Stack;
public class StockSpanner {
    
    Stack<Pair> stack ;
    int idx ;

    public StockSpanner() {
        stack =new Stack<>();
        idx =0;
    }
    
    public int next(int price) {
         Pair p =new Pair(price,idx);
         this.idx++;
        if(stack.isEmpty()){
            stack.push(p);
            return 1;
        }else {
             while(!stack.isEmpty() && p.val > stack.peek().val ){
                stack.pop();
            }
            int ans = stack.isEmpty()? p.idx+1 : p.idx - stack.peek().idx;
            stack.push(p);
            return ans;
        }
        
        
    }
    
    
    public class Pair{
        int val;
        int idx ;
        public Pair(int val,int idx){
            this.val =val;
            this.idx =idx;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */