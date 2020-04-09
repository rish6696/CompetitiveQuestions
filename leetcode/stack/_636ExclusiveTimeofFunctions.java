import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _636ExclusiveTimeofFunctions{
    public static void main(String[] args) {
        List<String > logs =new ArrayList<>(
            Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6")
        );
        int n =2;
        System.out.println(Arrays.toString(exclusiveTime(n, logs)));
    }

    public static  int[] exclusiveTime(int n, List<String> logs) {
        int [] ans =new int [n];
    
        Stack<Pair> stack =new Stack<>();
        for(int i =0;i<logs.size();i++){
            String cc =logs.get(i);
            if(stack.isEmpty()) stack.push(getPair(cc));
            
            else if( isStart(cc) ){
                Pair np =getPair(cc);
                Pair old =stack.peek();
                ans[old.id]= np.time-old.time;
                stack.push(np);
            }else {
                Pair np =getPair(cc);
                Pair old =stack.pop();
                ans[np.id]+= np.time-old.time+1;
                
                if(!stack.isEmpty())  {
                    Pair pk =stack.pop();
                    pk.time = np.time+1;
                    stack.push(pk);
                }  
            }
            
        }
        
        
        
        return ans;
    }

    public static  Pair getPair(String str){
        int fi =str.indexOf(':');
        int id =Integer.parseInt(str.substring(0,fi));
        int si =str.lastIndexOf(":");
        
        int time =Integer.parseInt(str.substring(si+1));
        
        return new Pair(id,time);
        
    }
    
    
    public static  boolean isStart(String str){
        int idx=0;
        while(idx < str.length() && str.charAt(idx)!=':') idx++;
        return str.charAt(idx+1)=='s' ;
    }
    
    
    public static  class Pair {
        int id;
        int time ; 
        
        public Pair(int id ,int time){
            this.id =id;
            this.time =time;
        }
        
        public String toString(){
            return this.id +","+this.time;
        }
    }
}