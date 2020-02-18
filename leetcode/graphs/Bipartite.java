import java.util.Arrays;
import java.util.LinkedList;

public class Bipartite{
    public static void main(String[] args) {
       // int [][] graph ={{1,3}, {0,2}, {1,3}, {0,2}};
        int [][] graph={{1,2,3}, {0,2}, {0,1,3}, {0,2}};
        int size =graph.length;
        int [] visited =new int [size];
        Arrays.fill(visited,-1);
        for (int i = 0; i < visited.length; i++) {
            if(visited[i]==-1){
                boolean ans =isByPartite(graph, i, visited);
                if(!ans){
                    System.out.println("graph is not bipartite");
                    return ;
                }
                 
            }
        }
        System.out.println("graph is bypartite");
        return ;

    }

    public static class ByPartitePair{
        int vertex =0;
        int color=0;
        public ByPartitePair(int vertex,int color){
            this.vertex=vertex;
            this.color=color;
        }
    }

    public static boolean isByPartite(int [][] graph,int i,int [] visited) {

        LinkedList<ByPartitePair> queue=new LinkedList<>();
        queue.addLast(new ByPartitePair(i, 0));
        while(!queue.isEmpty()){
            ByPartitePair rvpair =queue.removeFirst();
            //detect cycle here 
            if(visited[rvpair.vertex]!=-1){
                if(rvpair.color!=visited[rvpair.vertex]){
                    return false;
                }
                continue;
            }
            visited[rvpair.vertex]=rvpair.color;
            for(int nie: graph[rvpair.vertex]){
                if(visited[nie]==-1){
                    queue.addLast(new ByPartitePair(nie, (rvpair.color+1)%2));
                }
            }
        }
        return true;
    }
}