import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class Lect1 {

    public static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    public static ArrayList<ArrayList<Edge>> reverseGraph = new ArrayList<>();
    public static int[] inDeegreeList;

    public static class Edge {
        int v = 0;
        int w = 0;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;

        }
    }

    public static class Pair {
        int vertex = 0;
        int colour = 0;

        public Pair(int vertex, int colour) {
            this.vertex = vertex;
            this.colour = colour;
        }
    }

    public static void createGraph(int n) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());

        }

        addEdge(0, 1, 10);
        addEdge(0, 3, 10);
        addEdge(1, 2, 10);
        addEdge(2, 3, -2);
        addEdge(3, 4, 2);
        addEdge(4, 5, 2);
        addEdge(4, 6, 3);
        addEdge(5, 6, 8);

        // addEdge(0, 1, 2);
        // addEdge(1, 2, 2);
        // addEdge(2, 3, 2);
        // addEdge(3, 4, 2);
        // addEdge(4, 5, 2);
        // addEdge(9, 5, 2);
        // addEdge(8, 9, 2);
        // addEdge(7, 8, 2);
        // addEdge(6, 7, 2);
        // addEdge(6, 10, 2);
        // addEdge(0, 10, 2);

        // addEdge(0, 1, 2);
        // addEdge(1, 2, 2);
        // addEdge(2, 3, 2);
        // addEdge(3, 0, 2);

    }

    public static void addEdge(int u, int v, int w) {
        if (u < 0 || v < 0 || u >= graph.size() || v >= graph.size())
            return;
        graph.get(u).add(new Edge(v, w));
      //  inDeegreeList[v]++;
        graph.get(v).add(new Edge(u, w));

    }

    public static void display() {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + "->");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print("(" + graph.get(i).get(j).v + "," + graph.get(i).get(j).w + ")");
            }
            System.out.println();
        }
    }

    public static Edge removeEdge(int u, int v) {
        ArrayList<Edge> m = graph.get(u);
        int w = 0;

        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).v == v) {
                w = m.get(i).w;
                m.remove(i);
            }
        }
        m = graph.get(v);

        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).v == u) {
                m.remove(i);
            }
        }
        return new Edge(v, w);

    }

    public static void removeVertex(int vertex) {
        ArrayList<Edge> indexList = graph.get(vertex);
        while (indexList.size() != 0) {
            removeEdge(vertex, indexList.get(indexList.size() - 1).v);
        }

    }

    public static void main(String[] args) {
        /// graph is not original

        int n = 7;
      //  inDeegreeList = new int[n];
        createGraph(n);

        display();
        System.out.println("*******************");
        // System.out.println(Arrays.toString(inDeegreeList));
      //  khanTopo();
        //printTopologicalSort();

        djisktraAlgo();

    }

    public static void DFS(int source, boolean[] visited) {

        visited[source] = true;
        ArrayList<Edge> indexList = graph.get(source);
        for (int i = 0; i < indexList.size(); i++) {
            Edge e = indexList.get(i);
            if (!visited[e.v]) {
                DFS(e.v, visited);
            }
        }

    }

    public static int getConnectedComponent() {
        int count = 0;
        boolean[] visited = new boolean[graph.size()];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                count++;
                DFS(i, visited);
            }
        }
        return count;
    }

    public static void allPath(int source, int destination, boolean[] visited, String ans) {
        System.out.println(ans);
        visited[source] = true;
        ArrayList<Edge> indexList = graph.get(source);
        for (int i = 0; i < indexList.size(); i++) {
            Edge e = indexList.get(i);
            if (!visited[e.v]) {
                allPath(e.v, destination, visited, ans + e.v);
            }
        }
        visited[source] = false;

    }

    public static int maxWeight(int source, int destination, int wieght, boolean[] visited, String str) {
        if (source == destination) {
            System.out.println(str + "@weight=" + wieght);
            return wieght;
        }
        int ans = Integer.MIN_VALUE;
        visited[source] = true;
        for (int i = 0; i < graph.get(source).size(); i++) {
            if (!visited[graph.get(source).get(i).v]) {
                int recAns = maxWeight(graph.get(source).get(i).v, destination, wieght + graph.get(source).get(i).w,
                        visited, str + graph.get(source).get(i).v);
                ans = Math.max(ans, recAns);
            }
        }
        visited[source] = false;
        return ans;

    }

    public static int minWeight(int source, int destination, int wieght, boolean[] visited, String str) {
        if (source == destination) {
            System.out.println(str + "@weight=" + wieght);
            return wieght;
        }
        int ans = Integer.MAX_VALUE;
        visited[source] = true;

        for (int i = 0; i < graph.get(source).size(); i++) {
            if (!visited[graph.get(source).get(i).v]) {

                int recAns = minWeight(graph.get(source).get(i).v, destination, wieght + graph.get(source).get(i).w,
                        visited, str + graph.get(source).get(i).v);
                ans = Math.min(ans, recAns);
            }
        }
        visited[source] = false;
        return ans;

    }

    public static boolean allVisited(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    public static int hamiltonianPath(int source, int vtxCount, boolean[] visited, String str) {
        int ans = 0;
        visited[source] = true;
        ArrayList<Edge> indexList = graph.get(source);
        for (int i = 0; i < indexList.size(); i++) {
            Edge e = indexList.get(i);
            if (!visited[e.v]) {
                ans += hamiltonianPath(e.v, vtxCount + 1, visited, str + e.v);
            }
        }
        if (vtxCount == graph.size() - 1) {
            System.out.println(str);
            ans++;
        }
        visited[source] = false;
        return ans;
    }

    public static boolean isByPartite() {
        LinkedList<Pair> queue = new LinkedList<>();
        int[] visited = { -1, -1, -1, -1, -1, -1, -1 };
        Pair s = new Pair(0, 0);
        queue.addFirst(s);
        while (!queue.isEmpty()) {
            Pair rvt = queue.removeFirst();
            if (visited[rvt.vertex] != -1) {
                if (visited[rvt.vertex] != rvt.colour) {
                    return false;
                }
                continue;
            }
            visited[rvt.vertex] = rvt.colour;
            for (Edge e : graph.get(rvt.vertex)) {
                if (visited[e.v] == -1) {
                    Pair np = new Pair(e.v, (rvt.colour + 1) % 2);
                    queue.addLast(np);
                }
            }
        }
        return true;
    }

    public static void topological(int source, boolean[] visited, ArrayList<Integer> stack) {
        visited[source] = true;
        for (Edge e : graph.get(source)) {
            if (!visited[e.v]) {
                topological(e.v, visited, stack);
            }
        }

        stack.add(source);

    }

    public static void printTopologicalSort() {
        ArrayList<Integer> stack = new ArrayList<>();
        boolean[] visited = new boolean[graph.size()];
        boolean[] inStack = new boolean[graph.size()];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                boolean ans = detectCycleInDirected(i, visited, inStack, stack);
                if (ans) {
                    System.out.println("No topo sort possible because cycle");
                    return;
                }
            }
        }

        while (!stack.isEmpty()) {
            int rvt = stack.remove(stack.size() - 1);
            System.out.print(rvt + " ");
        }

    }

    public static boolean detectCycleInDirected(int source, boolean[] visited, boolean[] inStack,
            ArrayList<Integer> topoStack) {
        visited[source] = true;
        inStack[source] = true;
        for (Edge e : graph.get(source)) {
            if (!visited[e.v]) {
                boolean recAns = detectCycleInDirected(e.v, visited, inStack, topoStack);
                if (recAns)
                    return true;
            } else {
                if (inStack[e.v])
                    return true;
            }
        }
        inStack[source] = false;
        topoStack.add(source);
        return false;
    }

    public static void khanTopo() {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDeegreeList.length; i++) {
            if (inDeegreeList[i] == 0) {
                queue.add(i);
            }
        }
        ArrayList<Integer> stack = new ArrayList<>();
        while (!queue.isEmpty()) {
            int rvtx = queue.removeFirst();
            stack.add(rvtx);
            for (Edge e : graph.get(rvtx)) {
                inDeegreeList[e.v]--;
                if (inDeegreeList[e.v] == 0) {
                    queue.push(e.v);
                }
            }

        }

        if (stack.size() < graph.size()) {
            System.out.println("No topo sort possible beacause cycle");
            return;
        }

        System.out.println(stack);
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

    public static void djisktraAlgo(int source) {
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

        System.out.println(Arrays.toString(ans));

    }

}