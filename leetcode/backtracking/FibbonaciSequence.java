import java.util.*;
public class FibbonaciSequence{
    public static void main(String[] args) {
        List<Integer> ans=new ArrayList<>();
        String S="123456579";
        returnSol(ans,0,0,1,S);
        System.out.println(ans);
    }
    public static boolean isValid(String num){
        if(num.charAt(0)=='0'&&num.length()>1){
            return false;
        }
        try{ int a=Integer.parseInt(num); }
        catch(Exception e){
             return false;
        }
        return true;
    }
    
    public static boolean returnSol(List<Integer>bigAns,int first,int second,int counter,String ques){
        if(counter-1>=3&& ques.length()==0 ){
            return true;
        }
        for(int i=0;i<ques.length();i++){
            String valString=ques.substring(0,i+1);
            boolean recAns=false;
            if(isValid(valString)){
                int val=Integer.parseInt(valString);
              if(counter==1){
                  bigAns.add(val);
                  recAns=returnSol(bigAns,val,second,counter+1,ques.substring(i+1));
                  if(recAns)return true;
                  bigAns.remove(bigAns.size()-1);
                  
                  
                  
              }else if(counter==2){
                  
                       bigAns.add(val);
                  recAns=returnSol(bigAns,first,val,counter+1,ques.substring(i+1));
                  if(recAns)return true;
                  bigAns.remove(bigAns.size()-1);
                  
              }else {
                  if(val==first+second){
                          bigAns.add(val);
                  recAns=returnSol(bigAns,second,val,counter+1,ques.substring(i+1));
                  if(recAns)return true;
                  bigAns.remove(bigAns.size()-1);
                  } else if(val>first+second)return false;
                  
              }
                
                
            }
            
        }
        return false;
    }
}