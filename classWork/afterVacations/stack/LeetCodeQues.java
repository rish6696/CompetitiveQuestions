import java.util.Stack;

public class LeetCodeQues {

public static void main(String[] args) {
  //  String ques ="([{(())}]))";
    String ques ="((()))";
    System.out.println(isBalancedParenthesis(ques));

    
} 
public static boolean isOpening(Character cc){
    return cc =='('|| cc=='{'||cc=='[';
}

public static char  getOpening(char cc){
  if(cc==')') return '(';
  else if(cc=='}') return '{';
  else return '[';
}

public static boolean isBalancedParenthesis(String str){

    Stack <Character> stack =new Stack<>();
    for(int i=0;i<str.length();i++){
        char cc =str.charAt(i);
        if(isOpening(cc)) stack.push(cc);
        else{
            char open  = getOpening(cc);
            if(stack.isEmpty() || stack.peek()!=open){
                return false;
            }
            stack.pop();
        }
    }  
    return stack.isEmpty();
}





}