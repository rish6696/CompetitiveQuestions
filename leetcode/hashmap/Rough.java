import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.HashMap;
import java.util.Set;

public class Rough{
    public static void main(String[] args) {

        Set<Integer> set =new LinkedHashSet<>();
        

       // HashSet<Character> set = new HashSet<>();
    //    String str ="AAAAAAAAAA";
    //    System.out.println(str.length());
    //    //System.out.println(lengthOfLongestSubstring(str));
        
    }

    public  static int lengthOfLongestSubstring(String s) {
        
        if(s.length()==0) return 0;

            
        HashMap<Character,Integer> map = new HashMap<>();
        //HashSet<Character> set = new HashSet<>();
        int ans = -1;
        int start =0;
        
        for(int end =0; end<s.length(); end++){
            char cc = s.charAt(end);
            if(map.containsKey(cc) && map.get(cc) >= start ){
                start=map.get(cc)+1;
            }
            map.put(cc,end);
            ans=Math.max(ans,end-start+1);
          
        }
        ans =Math.max(ans,s.length()-start);
        return ans ;
        
    }
}