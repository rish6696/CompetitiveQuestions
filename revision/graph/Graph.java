import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {

    private class Edge {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    ArrayList<Edge>[] graph;

    public Graph(ArrayList<ArrayList<Integer>> edges, int totalVertex) {
        graph = new ArrayList[totalVertex];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (ArrayList<Integer> edge : edges) {
            addEdge(edge.get(0), edge.get(1), edge.get(2));
        }

    }

    private void addEdge(int from, int to, int weight) {
        graph[from].add(new Edge(to, weight));
        graph[to].add(new Edge(from, weight));
    }

    public void displayGraph() {

        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " => ");

            ArrayList<Edge> edges = graph[i];
            for (Edge edge : edges) {
                System.out.print("(" + edge.vertex + "," + edge.weight + "),");
            }

            System.out.println();
        }
    }

    public void bfs() {
        LinkedList<BFSPair> queue = new LinkedList<>();

        queue.add(new BFSPair(0, 0));

        int level = 0;
        int size = 0;
        boolean[] visited = new boolean[this.graph.length];

        while (!queue.isEmpty()) {

            size = queue.size();
            while (size-- > 0) {

                BFSPair rmPair = queue.removeFirst();

                if (visited[rmPair.vertex]){
                    System.out.println("Already Visited "+ rmPair.vertex);
                    continue;
                }
                visited[rmPair.vertex] = true;
                System.out.println("Node: "+ rmPair.vertex+", Level:"+ rmPair.level );
                for (Edge edge : this.graph[rmPair.vertex]) {
                    if (!visited[edge.vertex]) {
                        queue.add(new BFSPair(edge.vertex, rmPair.level+1));
                    }
                }
            }
            level++;
        }

    }

    private class BFSPair {
        int vertex;
        int level;

        public BFSPair(int vertex, int level) {
            this.vertex = vertex;
            this.level = level;
        }
    }
}