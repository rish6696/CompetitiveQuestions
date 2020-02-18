public class _802FindEventualSafeStates {

    public static void main(String[] args) {

        int [][] graph ={{1,2},{2,3},{5},{0},{5},{},{}};
        boolean [] visited =new boolean [graph.length];
        boolean [] solutions =new boolean [graph.length];
        boolean [] inStack =new boolean [graph.length];
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) dfsSearch(i, graph, visited, solutions,inStack);
        }
     
        for (int i = 0; i < solutions.length; i++) {
            if(solutions[i])System.out.print(i+" ");
        }
        System.out.println();


    }

    public static boolean dfsSearch(int vertex, int[][] graph, boolean[] visited, boolean[] solutions,boolean []inStack) {

        inStack[vertex]=true;
        visited[vertex] = true;
        if (graph[vertex].length == 0) {
            solutions[vertex] = true;
            inStack[vertex]=false;
            return true;
        }
        boolean isAlltrue=true;
        for (int nie : graph[vertex]) {
            if(inStack[nie]){
                isAlltrue=false;
            }
            if(visited[nie]){
                if(!solutions[nie]) isAlltrue=false;
            }
            if (!visited[nie]) {
                boolean recAns = dfsSearch(nie, graph, visited, solutions,inStack);
                if(!recAns)isAlltrue=false;
            }
        }
        inStack[vertex]=false;
        if(isAlltrue){
            solutions[vertex]=true;
            return true;
        }
        return false;

    }

}