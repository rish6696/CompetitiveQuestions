
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
public class _1042FlowerPlantingWithNoAdjacent{
    public static void main(String[] args) {
        List< List<Integer> > graph=new ArrayList<>();
        int n=5;
        int [][] edges ={{3,4},{4,5},{3,2},{5,1},{1,3},{4,2}};
        //int [][] edges ={{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};
        createGraph(graph, edges, n);
        // for (int i = 0; i < graph.size(); i++) {
        //     Collections.sort(graph.get(i));
        // }
        int [] visited =new int [n];
        for (int i = 0; i < visited.length; i++) {
            if(visited[i]==0){
                plantFlowers(i, visited, graph);
            }
        }
        System.out.println(Arrays.toString(visited));

    }

    public static void createGraph(List< List<Integer> > graph ,int [][]edges,int n){
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u =edges[i][0]-1;
            int v =edges[i][1]-1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

    }

    public static void plantFlowers(int vertex ,int []visited,List< List<Integer> > graph){
        boolean []occupied =new boolean [4];
        for(Integer nie:graph.get(vertex)){
            int color =visited[nie];
            if(color!=0) occupied[color-1]=true;
        }
        for (int i = 0; i < occupied.length; i++) {
            if(!occupied[i]){
                visited[vertex]=i+1;
                break;
            }
        }
        for (Integer nie :graph.get(vertex)) {
            if(visited[nie]==0){
                plantFlowers(nie, visited, graph);
            }
        }
    }
}