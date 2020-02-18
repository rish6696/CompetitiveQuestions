import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _839SimilarStringGroups {
    public static void main(String[] args) {
        String[] A={"tars","rats","arts","stars"};
        HashMap<String, HashMap<String, Boolean>> graph = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            HashMap<String,Boolean> niegbours=new HashMap<>();
            graph.put(A[i], niegbours);
        }
        createGraph(A, graph);
        HashSet<String> visited =new HashSet<>();
        int count =0;
        for (int i = 0; i < A.length; i++) {
            if(!visited.contains(A[i])){
                count++;
                dfs(A[i], graph, visited);
            }
        }

        System.out.println(graph.toString());
         System.out.println(count);

    }

    public static void createGraph(String[] A, HashMap<String, HashMap<String, Boolean>> graph) {
        int N = A.length;
        int w = A[0].length();

        if( N <w*w){
            for (int i = 0; i < A.length-1; i++) {
                for (int j = i+1; j < A.length; j++) {
                    if(isSimiliar(A[i], A[j])){
                        graph.get(A[i]).put(A[j], true);
                        graph.get(A[j]).put(A[i], true);

                    }
                }
            }
        }else{
            
            for (int i = 0; i < A.length; i++) {
                String word =A[i];
                for (int j = 0; j < word.length()-1; j++) {
                    for (int k = j+1; k < word.length(); k++) {
                        char [] temp =word.toCharArray();
                        swap(j, k, temp);
                        String str =new String(temp);
                        if(!str.equals(word) &&graph.containsKey(str)){
                            graph.get(word).put(str, true);
                        }   
                    }
                    
                }
            }
        }
        
        
    }


    public static boolean isSimiliar(String a,String b){
        int c=0;
        for (int i = 0; i < a.length(); i++){
          if(a.charAt(i)!=b.charAt(i))c++;
        }
        return c <=2;
    }

    public static void dfs(String vertex,HashMap<String, HashMap<String, Boolean>> graph,HashSet<String> visited ){
        visited.add(vertex);
        for(Map.Entry <String,Boolean> nie: graph.get(vertex).entrySet()){
           if(!visited.contains(nie.getKey())){
               dfs(nie.getKey(), graph, visited);
           }
        }
    }

    public static void swap(int i,int j,char []arr){
        arr[i]^=arr[j];
        arr[j]^=arr[i];
        arr[i]^=arr[j];

    }
}