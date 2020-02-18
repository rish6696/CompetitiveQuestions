import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _990SatisfiabilityofEqualityEquations{
    public static void main(String[] args) {
        HashMap<Character,Integer>mapper=new HashMap<>();
        String [] equations ={"a==b","e==c","b==c","a!=e"};
        System.out.println(isEqual(mapper, equations));
    }


    public static boolean isEqual(HashMap<Character,Integer>mapper,String []equations){
        //caadd equals in set 
        int assigner =0;
        for (int i = 0; i < equations.length; i++) {
            if(equations[i].charAt(1) =='='){
               char a = equations[i].charAt(0);
               char b = equations[i].charAt(3);
               //che ch for a==a here 
               if(mapper.containsKey(a) && mapper.containsKey(b)){
                int vala =mapper.get(a);
                int valB =mapper.get(b);
                    if(vala!=valB){
                        setValuesIfDiff(mapper, vala, valB);
                    }
               }
               else if(mapper.containsKey(a)){
                   int val =mapper.get(a);
                   mapper.put(b, val);
               }
               else if(mapper.containsKey(b)){
                  int val =mapper.get(b);
                  mapper.put(a, val);
               }else{
                   mapper.put(a, assigner);
                   mapper.put(b, assigner);
                   assigner++;
               }
               
            }
        }

        //now check for all not equals

        for (int i = 0; i < equations.length; i++) {
            if(equations[i].charAt(1) =='!'){
                char a = equations[i].charAt(0);
                char b = equations[i].charAt(3);
                if(a==b)return false;
                if(mapper.containsKey(a) && mapper.containsKey(b)){
                    int vala =mapper.get(a);
                    int valB =mapper.get(b);
                    if(vala==valB)return false;
                }
            }
        }

        return true;
    }


    public static void setValuesIfDiff(HashMap<Character,Integer>mapper,int vala,int valb){
        Set<Character> keySet=mapper.keySet(); 
        Iterator it=keySet.iterator();
        while(it.hasNext()){
            Character cc= (Character)it.next();
           // System.out.println(cc);
            int v=mapper.get(cc);
            if(v==vala){
                mapper.put(cc, valb);
            }
        }
    }

    
}