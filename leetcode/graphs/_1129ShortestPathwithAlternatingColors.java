
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
public class _1129ShortestPathwithAlternatingColors {

    public static class Edge{
        int vertex;
        int color ;
        public Edge(int vertex,int color){
            this.color=color;
            this.vertex=vertex;
        }
    }
    public static  class Pair{
        int vertex;
        int color ;
        public Pair(int vertex,int color){
            this.vertex=vertex;
            this.color=color;
        }
    }
    public static void main(String[] args) {
        List <List<Edge>> graph =new ArrayList<>();
        int n=5;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        } 
        int [][] redEdges ={{2,2},{0,1},{0,3},{0,0},{0,4},{2,1},{2,0},{1,4},{3,4}};
        int [][] blueEdges={{1,3},{0,0},{0,3},{4,2},{1,0}};

        //0 for red color 
        //1 for blue color
        for (int i = 0; i < blueEdges.length; i++) {
            int u =blueEdges[i][0];
            int v =blueEdges[i][1];
            int color =1;
            graph.get(u).add(new Edge(v, color));
        }
        for (int i = 0; i < redEdges.length; i++) {
            int u =redEdges[i][0];
            int v =redEdges[i][1];
            int color =0;
            graph.get(u).add(new Edge(v, color));
        }
        
        int[][]visited=new int [n][2];
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i],-1);
        }
        bfs(graph, visited);
        int [] ans =new int [n];
        ans[0]=0;
        for (int i = 1; i < ans.length; i++) {
            int a =visited[i][0];
            int b =visited[i][1];
            System.out.print("x="+a+",y="+b+" ");
            if(a==-1 && b==-1) ans [i]=-1;
            else if( a*b<0) ans [i]= a<0?b:a;
            else ans[i]=Math.min(a, b);
        }
        System.out.println(Arrays.toString(ans));
    }


    public static void bfs( List <List<Edge>> graph ,int [][]visited ){
        boolean zeroVisited=false;
        LinkedList<Pair> queue =new LinkedList<>();
        queue.add(new Pair(0,3)) ;
        int level =0;
        while(!queue.isEmpty()){
            int size =queue.size();
            while(size >0){
                size--;
                Pair rmPair=queue.removeFirst();
                //check if already visited 
                if(rmPair.vertex==0){
                    if(zeroVisited)continue;
                }else{
                   if(visited[rmPair.vertex][rmPair.color]!=-1)continue;
                }
                 


                //mark visited 
                if(rmPair.color==3){
                    visited[0][0]=0;
                    visited[0][1]=0;
                    zeroVisited=true;
                }else visited[rmPair.vertex][rmPair.color]=level;
                
                if(rmPair.vertex!=0) visited[rmPair.vertex][rmPair.color]=level;
                for(Edge e:  graph.get(rmPair.vertex)){
                    if(rmPair.color==3)queue.add(new Pair(e.vertex, e.color) );
                    else if( visited[e.vertex][e.color]==-1 && rmPair.color!=e.color) queue.add(new Pair(e.vertex, e.color) );     
                }
            }
            level++;
        }
    }
}