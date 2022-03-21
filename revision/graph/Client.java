import java.util.ArrayList;
import java.util.Arrays;

public class Client {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>(
            Arrays.asList(
                new ArrayList<>(Arrays.asList(0, 1, 5)),
                new ArrayList<>(Arrays.asList(0, 2, 2)),
                new ArrayList<>(Arrays.asList(1, 3, 10)),
                new ArrayList<>(Arrays.asList(3, 2, 7)),
                new ArrayList<>(Arrays.asList(3, 5, 8)),
                new ArrayList<>(Arrays.asList(5, 6, 12)),
                new ArrayList<>(Arrays.asList(6, 4, 3)),
                new ArrayList<>(Arrays.asList(4, 5, 4))

            )
        );

        Graph gr = new Graph(edges, 7);

       gr.displayGraph();
       gr.bfs();
    }
}
