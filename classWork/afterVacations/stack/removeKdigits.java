import java.util.Stack;
public class removeKdigits{
    public static void main(String[] args) {

        String num ="10";
        int k =1;
        System.out.println(removeKdigits(num, k));
        
    }
    public static  String removeKdigits(String num, int k) {
        
        Stack<Character> stack =new Stack<>();
        int i =0;
        while( i<num.length() ){
            char cc = num.charAt(i);
            while(k>0&&!stack.isEmpty()  && cc-'0' < stack.peek()-'0'){
                stack.pop();
                k--;
            }
            stack.push(cc);
            i++;
        }
        
        while(k>0){
            stack.pop();
            k--;
        }
        
        StringBuilder str =new StringBuilder();
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }

        str.reverse();
        if(str.length()==0) return "0"; 
        
        int idx =0;
        while(idx <str.length()&& str.charAt(idx)=='0'){
            idx++;
        }
        
        return idx>=str.length() ? "0" :  str.substring(idx);
        
    }
}