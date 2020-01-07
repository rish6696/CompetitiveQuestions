import java.util.*;
public class LetterCasePermutation{
    public static void main(String[] args) {
        String S="a1b2";
        List<String> ans =new ArrayList<>();
        ans(ans,S,0);
        System.out.println(ans);
       
       
       
    }
       
    public static boolean isSmall(char c){
        int val =c;
        System.out.println(val);
        return val>=97&&val <=122;
    }
    
    
    public static void ans(List<String>bigAns,String ans,int idx){
        if(idx==ans.length()){
           // System.out.println(ans);
            bigAns.add(ans);
            return ;
        }
        
        
            if(ans.charAt(idx)-'0'>9){
                char cc=ans.charAt(idx);
                char small,big;
                if(isSmall(cc)){
                    small=cc;
                    big=(char)(cc-32);
                }else{
                    big=cc;
                    small=(char)(cc+32);
                }
                ans(bigAns,ans.substring(0,idx)+small+ans.substring(idx+1),idx+1);
                ans(bigAns,ans.substring(0,idx)+big+ans.substring(idx+1),idx+1);
               
            }else{
                ans(bigAns,ans,idx+1);
            }
        
        
    }
}