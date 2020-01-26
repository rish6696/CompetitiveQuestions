import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class EvaluateDivision {

    // public static class Node {
    //     String  v=null;
    //     double w=0;
    //     public  Node(double w,String  v){
    //        this.w=w;
    //        this.v=v;
    //     }

    // }

    public static void main(String[] args) {
        int sizeGraph =0;
        HashMap < String, HashMap< String ,Double > > graph =new HashMap<>();
        List<List<String>> equations=new ArrayList<>();
        equations.add(Arrays.asList("x1","x2"));
        equations.add(Arrays.asList("x2","x3"));
        equations.add(Arrays.asList("x3","x4"));
        equations.add(Arrays.asList("x4","x5"));


       // equations.add( new ArrayList<>().add("e") );
        double[] values={3.0,4.0,5.0,6.0};
        List<List<String>> queries=new ArrayList<>();
        queries.add(Arrays.asList("x1","x5"));
        queries.add(Arrays.asList("x5","x2"));
        queries.add(Arrays.asList("x2","x4"));
        queries.add(Arrays.asList("x2","x2"));
        queries.add(Arrays.asList("x2","x9"));
        queries.add(Arrays.asList("x9","x9"));
        // queries.add(Arrays.asList("a","a"));
        // queries.add(Arrays.asList("x","x"));

        double [] ansArray =new double[queries.size()];
        createGraph(graph, equations, values);

        for (int i = 0; i < queries.size(); i++) {
            String src=queries.get(i).get(0);
            String des=queries.get(i).get(1);
            HashSet<String> visited =new HashSet<>();
            boolean ans=solveQueries(graph, src, des, 1.0, i, ansArray,visited );
            if(!ans) ansArray[i]=-1;
        }


        System.out.println(Arrays.toString(ansArray));

    }


    public static boolean solveQueries( HashMap < String, HashMap< String ,Double > > graph,String cur,String dest,double ansSoFar,int si,double[] ans,HashSet<String> visited){
         
         
        if( graph.get(cur)!=null&& graph.get(cur).containsKey(dest)){
            double w=graph.get(cur).get(dest);
            ans[si]=ansSoFar*w;
            return true;
        }

        // if(  graph.get(dest)!=null&& graph.get(dest).containsKey(cur)){
        //     double w=graph.get(dest).get(cur);
        //     ans[si]=(1/w)*ansSoFar;
        //     return true;
        // }

        if(graph.get(cur)!=null){
            for(Map.Entry<String , Double  > entry : graph.get(cur).entrySet() ){
                if( !entry.getKey().equals(cur) && !visited.contains(entry.getKey())){
                    visited.add(entry.getKey());
                    boolean recAns =solveQueries(graph, entry.getKey(), dest, ansSoFar*entry.getValue(), si, ans, visited);
                    if(recAns)return true;
                }
            }
        }
        return false;

    }

    public static void createGraph(  HashMap < String, HashMap< String ,Double > > graph,List<List<String>> equations,double[] values){
        for (int i = 0; i <equations.size();i++) {
           String f=equations.get(i).get(0);
           String s=equations.get(i).get(1);
          // Node node=new Node(values[i], s);
           if(graph.containsKey(f)){
                HashMap<String,Double> nieMap=graph.get(f);
                nieMap.put(s, values[i]);
                nieMap.put(f, 1.0);
           }else{
              HashMap<String,Double> nieMap=new HashMap<>();
              nieMap.put(s, values[i]);
              graph.put(f, nieMap);
           }



           if(graph.containsKey(s)){
            HashMap<String,Double> nieMap=graph.get(s);
            nieMap.put(f, 1/(values[i]));
            nieMap.put(s, 1.0);
          }else{
            HashMap<String,Double> nieMap=new HashMap<>();
            nieMap.put(f, 1/(values[i]));
            graph.put(s, nieMap);
         }
    
        }
    }



    
}