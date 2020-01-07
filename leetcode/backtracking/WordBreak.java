import java.util.ArrayList;



import java.util.*;

class WordBreak {

    public static void main(String[] args) {
        List<String> wordDict=new ArrayList<>();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String[] arr={"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        // String[] arr={"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
         for (String string : arr) {
             wordDict.add(string);
         }
         System.out.println(wordBreak(s, wordDict));
    }
    public static  boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Boolean> dic=new HashMap<>();
        HashMap<String,Boolean> rejectedStrings=new HashMap<>();
        for(String p:wordDict){
            dic.put(p,false);
        }
        List<String>bigAns=new ArrayList<>();
        boolean ans=wordAns(bigAns,dic,s,"",rejectedStrings);  
        System.out.println(bigAns);
        return ans; 
    }
    
    
        public static boolean wordAns(List<String>bigAns,HashMap<String,Boolean>dic,String str,String res,HashMap<String,Boolean>rejectedStrings){
         if(rejectedStrings.containsKey(str)){
             return false;
         }
        System.out.println("length of ques is"+str.length());
        if(str.length()==0){
            bigAns.add(res);
            return true;
        }
        String temp="";
        boolean trueHasCome=false;
        for(int i=0;i<str.length();i++){
            temp+=str.charAt(i);
            if(dic.containsKey(temp)){
                String toSend=str.substring(i+1);
                String toAdd=toSend.length()==0?temp:temp+" ";
                boolean recAns=wordAns(bigAns,dic,toSend,res+toAdd,rejectedStrings);
                if(recAns) trueHasCome=true;
            }
        }
        if(!trueHasCome){
            rejectedStrings.put(str, true);
            return false;
        }
        return true;
    }
}