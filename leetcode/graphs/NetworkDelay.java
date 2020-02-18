import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
public class NetworkDelay{

    public static void display(ArrayList<ArrayList<Edge>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + "->");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print("(" + graph.get(i).get(j).v + "," + graph.get(i).get(j).w + ")");
            }
            System.out.println();
        }
    }

    public static void addEdge(int u, int v, int w,ArrayList<ArrayList<Edge>> graph) {
        if (u < 0 || v < 0 || u >= graph.size() || v >= graph.size())
            return;
        graph.get(u).add(new Edge(v, w));
      //inDeegreeList[v]++;
        //graph.get(v).add(new Edge(u, w));

    }

    public static void createGraph(int n, ArrayList<ArrayList<Edge>> graph,int [][]edges ) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int [] edge =edges[i];
            addEdge(edge[0]-1, edge[1]-1, edge[2], graph);
        }
    }

    public static class Edge {
        int v = 0;
        int w = 0;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;

        }
    }
    public static void main(String[] args) {
        int n=3;
        int k=2;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        int [][] edgesArray={{1,2,1},{2,3,2},{1,3,1}};

       // int [][] edgesArray={{2,1,1},{2,3,1},{3,4,1}};
     //  int [][] edgesArray={{1,2,1}};
        createGraph(n, graph, edgesArray);
        display(graph);

        System.out.println(djisktraAlgo(graph,k-1));
        


        
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

    public static int djisktraAlgo(ArrayList<ArrayList<Edge>> graph,int source) {
        int[] ans = new int[graph.size()];
        Arrays.fill(ans,Integer.MIN_VALUE);
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

        int ansToreturn=Integer.MIN_VALUE;
        for (int i = 0; i < ans.length; i++) {
            if(ans[i]==Integer.MIN_VALUE) {
                ansToreturn=Integer.MIN_VALUE;
                break;
            }
            if(i!=source) ansToreturn=Math.max(ansToreturn, ans[i]);
            
        }
        return ansToreturn ==Integer.MIN_VALUE?-1:ansToreturn;

    }

    
}