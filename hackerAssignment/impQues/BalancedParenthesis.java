import java.util.*;
public class BalancedParenthesis{
    public static void main(String[] args) {
        String str="{{a}}(jiin)";
        System.out.println(isBalanced(str));
    }


    public static boolean isOpening(Character cc){
        if(cc=='{'||cc=='['||cc=='(')return true;
        return false;
    }

    public static boolean isClosing(Character cc){
        if(cc=='}'||cc==']'||cc==')')return true;
        return false;
    }

    public static boolean isCounter(Character op,Character clo){
        String opening="[{(";
        String closing="]})";
        int oi=opening.indexOf(op+"");
        int ci=closing.indexOf(clo+"");
        return oi==ci;


    }


    public static boolean isBalanced(String str){
        Stack<Character> s=new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character cc=str.charAt(i);
            if(isOpening(cc)){
                s.push(cc);
            }
            if(isClosing(cc)){
                if(s.size()==0)return false;
                Character Opening=s.pop();
                if(!isCounter(Opening, cc))return false;
            }
            
        }
        return s.size()==0;
        
    }
}