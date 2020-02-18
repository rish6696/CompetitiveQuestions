import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.PriorityQueue;

public class _1334FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance{

    public static class Edge {
        int v = 0;
        int w = 0;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;

        }
    }
    public static void main(String[] args) {
        
        int [][] edges={{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int d =4;
        int n =4;
        List< List<Edge> > graph =new ArrayList<>();
        createGraph(n, graph, edges);
        int lCount=Integer.MAX_VALUE;
        int lvertex=-1;

        int [] ans =new int[n];

        for (int i = 0; i < n; i++) {
            int []dis=djisktraAlgo(i, graph);
            //System.out.println( Arrays.toString(dis));
            int c=-1;
            for (int j = 0; j < dis.length; j++) {
                if(dis[j]<=d){
                    c++;
                }
            }
            ans[i]=c;
        }


        for(int i =0;i<ans.length;i++){
            if(ans[i]<=lCount) {
                lCount=ans[i];
                lvertex=i;
            }
        }
        System.out.println(lvertex);

        System.out.println(Arrays.toString(ans));
        

    }


    public static void  dfs(List<List<Edge>> graph,int idx,boolean []visited,int wsf,int d,int []ans ,int visitor){
        visited[idx]=true;
        ans[visitor]++;
        for(Edge e: graph.get(idx)){
            if(!visited[e.v] && wsf+e.w <=d ){
               dfs(graph, e.v, visited, wsf+e.w, d,ans,visitor);
            }
        }
        
    }

    public static void addEdge(int u, int v, int w,List< List<Edge> > graph) {
        if (u < 0 || v < 0 || u >= graph.size() || v >= graph.size())
        return;
        graph.get(u).add(new Edge(v, w));
        graph.get(v).add(new Edge(u, w));

    }


    public static void createGraph(int n,List<List<Edge>> graph,int [][]edges) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            addEdge(edges[i][0],edges[i][1],edges[i][2],graph);
        }
    }


    public static class DjisktaPair implements Comparable<DjisktaPair> {
        int vertex = 0;
        int parent = 0;
        int wsf = 0;
        int w = 0;

        public DjisktaPair(int vertex, int parent, int wsf, int w) {
            this.parent = parent;
            this.vertex = vertex;
            this.w = w;
            this.wsf = wsf;
        }

        @Override
        public int compareTo(DjisktaPair other) {
            return this.wsf-other.wsf;
        }

    }



    public static int[] djisktraAlgo(int source,  List< List<Edge> > graph) {
        int[] ans = new int[graph.size()];
        DjisktaPair base = new DjisktaPair(source, -1, 0, 0);
        PriorityQueue<DjisktaPair> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[graph.size()];
        queue.add(base);
        while (!queue.isEmpty()) {
            DjisktaPair rvPair = queue.poll();
            if(visited[rvPair.vertex]){
                continue;
            }
            ans[rvPair.vertex]=rvPair.wsf;
            visited[rvPair.vertex] = true;
            for (Edge e : graph.get(rvPair.vertex)) {
                if (!visited[e.v]) {
                    queue.add(new DjisktaPair(e.v, rvPair.vertex, rvPair.wsf + e.w, e.w));
                }
            }
        }
        return ans;
    }


}