
import java.util.Stack;;
public class _1209RemoveAllAdjacentDuplicatesinStringII{
    public static void main(String[] args) {
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
    }


    public static String removeDuplicates(String s, int k) {
        
        
        Stack<Pair> stack =new Stack<>();
        for(int i =0; i<s.length(); i++ ){
           char cc =s.charAt(i);

           if(!stack.isEmpty()  && stack.peek().cc == cc){

            if(stack.peek().count == k-1){
                while(!stack.isEmpty()  && stack.peek().cc ==cc ) stack.pop(); 
            }else{
                stack.push( new Pair( cc , stack.peek().count +1 ) );
            }

           }
            
           else stack.push(new Pair(cc,1)); 
        }
        
        
        StringBuilder str =new StringBuilder();
        while(!stack.isEmpty()){
            str.insert(0,stack.pop().cc);
        }
        
        
        return str.toString();
        
    }
    
    
    
     static class Pair {
        char cc ;
        int count =0;
        public Pair(char cc , int count ){
            this.count = count ;
            this.cc =cc;
        }
    }
}