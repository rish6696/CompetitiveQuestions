
import java.util.LinkedList;
import java.util.Stack;

public class _224BasicCalculator{
    public static void main(String[] args) {
        String a = "((1+(4+5+2)-3)+(6+8))";
        System.out.println(calculate(a));   
    }
    public  static int calculate(String s) {
        
        s ="(" + s +")";
           
        Stack<String> stack =new Stack<>();
        int i =s.length() -1;
        while(i>=0){
            char cc =s.charAt(i);
            if(cc==')' || cc=='+' || cc=='-') stack.push(cc+"");
            
            else if(cc-'0' >=0 && cc-'0'<=9 ){
                String num =returnNum(s,i);
                stack.push(num);
                i-=num.length();
                continue;
            } else if( cc=='('){
                int sign =1;
                int val = 0;
                while(!stack.isEmpty()  && !stack.peek().equals(")") ){
                    String str =stack.pop();
                    if(str.equals("+")) {
                        sign =1;
                    }else if(str.equals("-")){
                        sign =-1;
                    }
                    else{
                        int num =Integer.parseInt(str);
                        val+= (num * sign ) ;
                    }
                }
                stack.pop();
                stack.push(val+"");
            } 
            i--;
        }
           
           return Integer.parseInt(stack.peek());
       }
       
        public static String returnNum(String str,int endIndex){
           int i =endIndex-1;
           int num = str.charAt(i)-'0';
           while(i>=0&&num >=0 && num <=9 ){
               i--;
               num =str.charAt(i)-'0';
           }
           return str.substring(i+1,endIndex+1);
       }
}