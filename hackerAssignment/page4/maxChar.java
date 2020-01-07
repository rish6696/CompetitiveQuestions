import java.util.HashMap;
import java.util.*;

public class maxChar{
    public static void main(String[] args) {
        String str="aabbbcccccccaaaaaaaaaaaaa";
        maxChar(str);
        
    }
    public static void maxChar(String str){
        Character maxCharacter='\0';
        int co=Integer.MIN_VALUE;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int freq=map.get(str.charAt(i));
                map.put(str.charAt(i) ,freq+1);

            }
            else{
                map.put(str.charAt(i),1);
            }
        }
        Set<Map.Entry<Character,Integer>> entries=map.entrySet();
        for(Map.Entry<Character,Integer> entry:entries){
              if(entry.getValue()>co){
                  maxCharacter=entry.getKey();
                  co=entry.getValue();
              }
        }

        System.out.println(maxCharacter);
        
    }
}