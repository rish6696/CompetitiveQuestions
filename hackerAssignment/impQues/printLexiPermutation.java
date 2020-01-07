import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.*;

public class printLexiPermutation{
    public static void main(String[] args) {
    
        Scanner s=new Scanner(System.in);
        String str=s.next();
        char[] stringArray=str.toCharArray();
        TreeMap<Character,Integer> map=new TreeMap<>();
        Arrays.sort(stringArray);
        for(char cc:stringArray){
            if(map.containsKey(cc)){
                  int val=map.get(cc);
                  map.put(cc, val+1);
            }
            else{
                map.put(cc, 1);
            }
        }
        
        
        char[] result=new char[str.length()];
        System.out.println(count(map, str.length()));
        print(map, result, 0);
 
    }
    public static int count(TreeMap<Character,Integer>map,int len){
        int deno=1;
        Collection<Integer> values=map.values();
        for(Integer val:values){
            if(val>1){
                deno*=fact(val);
            }
        }
        return fact(len)/deno;

    }

    public static int fact(int n){
        if(n==1)return 1;
        return n*fact(n-1);
    }

    public static void printArray(char[] result){
          for(char cc:result){
              System.out.print(cc);
          }
          System.out.println();
    }

    public static void print(TreeMap<Character,Integer> map,char[] result,int level){
        if(level==result.length){
            printArray(result);
            return ;
        }
        Set<Map.Entry<Character,Integer>> entries=map.entrySet();
        for(Map.Entry<Character,Integer> entry:entries){
            Character key=entry.getKey();
            Integer val=entry.getValue();
            if(val>0){
                result[level]=key;
                TreeMap<Character,Integer> newHashmap = new TreeMap<>();
                newHashmap.putAll(map);
                newHashmap.put(key, val-1);
                print(newHashmap, result, level+1);
            }
        }

    }
}