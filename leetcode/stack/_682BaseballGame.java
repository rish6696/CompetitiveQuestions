import java.util.Stack;
public class _682BaseballGame{
    public static void main(String[] args) {
        String [] c ={"5","2","C","D","+"};
        System.out.println(calPoints(c));
    }

    public static int calPoints(String[] ops) {
        Stack<Integer> stack =new Stack<>();
        int sum =0;
        int score =0;
        for(int i=0;i<ops.length;i++){
           score=0;
           String cc = ops[i];
           if(cc.equals("+")){
               int f =stack.pop();
               score =f+stack.peek();
               stack.push(f);
              
           }else if(cc.equals("D")){
               score = 2* stack.peek();    
           }else if(cc.equals("C")){
               sum-=stack.pop();
               continue;
           }else{
               score =Integer.parseInt(cc);
           }
           stack.push(score);
           sum+=score;
            
        }
        
        return sum ;
        
    }
}