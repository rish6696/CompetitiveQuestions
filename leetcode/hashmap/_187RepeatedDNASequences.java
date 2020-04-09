import java.util.*;
public class _187RepeatedDNASequences {

    public static void main(String[] args) {
        String str ="AAAAAAAAAAAAA";
        System.out.println(str.length());
        System.out.println(findRepeatedDnaSequences(str));
        
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        
        
        HashMap<String,Boolean> map = new HashMap<>();
        List<String> ans = new ArrayList<> ();
        
        for(int i =0;i<s.length ();i++){
            int start =i;
            int end = i+10;
            if(end <=s.length()){
                String str = s.substring(start,end);
                if(map.containsKey(str) ){
                    if( !map.get(str)){
                    ans.add(str);
                    map.put(str,true);
                    }
                } 
                else map.put(str,false);
            }
        }
        
        return ans;
        
    }
}