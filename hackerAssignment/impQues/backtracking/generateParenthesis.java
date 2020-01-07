import java.util.ArrayList;
import java.util.List;

public class generateParenthesis{
    public static void main(String[] args) {
        int n=2;
        ////char[] arr=new char[n*2];
        //generatePArenthesis(arr, 0, n, 0, 0);
        System.out.println(ans(2));
        
    }

    public static  List<String> ans(int n){
         List<String> myans=new ArrayList<>();
         generatePArenthesis(new char[n*2], 0, n, 0, 0,myans);
         return myans;
    } 


    public static void generatePArenthesis(char[]arr,int i,int n,int oc,int cc,List<String>bigAns){
         if(i==arr.length){
           String m=new String(arr);
           bigAns.add(m);
           return ;
         }
         if(oc<n){
             arr[i]='(';
             generatePArenthesis(arr, i+1, n, oc+1, cc,bigAns);
         }
         arr[i]='\0';
         if(cc<oc){
             arr[i]=')';
             generatePArenthesis(arr, i+1, n, oc, cc+1,bigAns);
         }
         arr[i]='\0';
    }
}