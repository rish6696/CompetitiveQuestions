import java.util.Scanner;
public class betParen{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.next();
        System.out.println(returnString(str,"",0,false));
    }

    public static String returnString(String str,String result,int start,boolean toAdd){
        if(start==str.length()){
            return result;
        }
        if(str.charAt(start)==')'){
            if(toAdd)return returnString(str,result+")",start+1,false);
            return returnString(str,result,start+1,toAdd);
            
        }
        if(toAdd){
            return returnString(str,result+str.charAt(start),start+1,true);
        }
        if(str.charAt(start)=='('){
            return returnString(str,result+'(',start+1,true);
        }
        
        return returnString(str,result,start+1,toAdd);
    }
}