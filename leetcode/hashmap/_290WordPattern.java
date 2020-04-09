import java.util.HashMap;
import java.util.HashSet;
public class _290WordPattern{
    public static void main(String[] args) {
        String pattern ="aaa";
        String str ="aa aa aa aa";
        System.out.println(wordPattern(pattern, str));
    }
    public static  boolean wordPattern(String pattern, String str) {
        
        
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        
        int i=0;
        int j =0;
        
        while(i<pattern.length()&&j<str.length()){
            char p = pattern.charAt(i);
            i++; 
            int k =j;
            while(k<str.length()&&str.charAt(k)!=' ') k++;
            
            String word = str.substring(j,k);
            j=k+1;
            
            if(map.containsKey(p)){
                if(!map.get(p).equals(word)) return false;
            }else{
                if(set.contains(word)) return false;
                map.put(p,word);
                set.add(word);
            }            
            
        }
        if(i < pattern.length()  || j < str.length()  ) return false;
        
        return true;   
    }
}