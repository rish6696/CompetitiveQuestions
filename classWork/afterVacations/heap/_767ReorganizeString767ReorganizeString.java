import java.util.HashMap;
public class _767ReorganizeString767ReorganizeString{
    public static void main(String[] args) {
        String str ="vvvlo";
        System.out.println(reorganizeString(str));
    }

    public static  String reorganizeString(String S) {
        
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i =0;i<S.length();i++){
            char cc = S.charAt(i);
            if(!map.containsKey(cc)){
                map.put(cc,1);
            }else{
                map.put(cc ,map.get(cc)+1);
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int k =0; k<S.length(); k++) {
            
            for(int i=0; i<S.length(); i++){
                char cc =S.charAt(i);
                if(map.containsKey(cc)){

                    if(sb.length()==0){
                      sb.append(cc);
                      readd(map,cc);
                      break; 
                    }else{
                        
                        int last =sb.length()-1;
                        if(cc!=sb.charAt(last)){
                            sb.append(cc);
                            readd(map,cc);
                            break;
                        }
                    
                    }
                    
                }
            
            }
        }
        
        
        if(sb.length()==S.length()) return sb.toString();
        return "";
        
        
    }
    
    public static  void readd(HashMap<Character,Integer> map,char cc){
        if(map.get(cc)==1) map.remove(cc);
        else{
            map.put(cc,map.get(cc)-1);
        }
    }
}