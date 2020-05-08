import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class _787CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int [][] flights ={{0,1,100},{1,2,100},{0,2,500}};
        int n =3;
        int src =0;
        int dst =2;
        int k =1;  

        
        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

 public static  int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<HashMap<Integer,Integer>> graph= createGraph(n,flights);
        int [][] dp = new int [n+1][K+1];
        for(int []a:dp) Arrays.fill(a, Integer.MAX_VALUE);
        int ans = sol(graph,src,dst,K,dp);
 
        return ans == Integer.MAX_VALUE ? -1 :ans ;
    }
    
    
    public  static  int sol( List<HashMap<Integer,Integer>> graph ,int curr,int dest,int k,int [][]dp){
        if(curr==dest)  return 0;
        if(k<0)  return Integer.MAX_VALUE;
        
        int ans =Integer.MAX_VALUE;
        if(dp[curr][k]!=Integer.MAX_VALUE)  return dp[curr][k];
        
        HashMap<Integer,Integer> map = graph.get(curr);
        
        if(k==0){
            return map.containsKey(dest) ? map.get(dest):ans;
        }else{ 
           for(int x : map.keySet()){
               int recAns = sol(graph,x,dest,k-1,dp);
               if(recAns!= Integer.MAX_VALUE) ans=Math.min(ans, map.get(x)+recAns);
           }
        }
        dp[curr][k]= ans;
        return ans;
    }
    
    
    
    public  static   List<HashMap<Integer,Integer>> createGraph(int n,int[][] flights){
        List<HashMap<Integer,Integer>>graph = new ArrayList<>();
        for(int i =0;i<n;i++){
            graph.add(new HashMap<>());
        }
        
        for(int i =0;i<flights.length;i++){
            int [] f = flights[i];
            graph.get(f[0]).put(f[1],f[2]);
        }
        return graph;
    }
}