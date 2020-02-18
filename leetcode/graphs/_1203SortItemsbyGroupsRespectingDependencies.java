import java.util.ArrayList;
import java.util.Arrays;

public class _1203SortItemsbyGroupsRespectingDependencies {
    public static void main(String[] args) {

        int n = 4;
        int m = 1;
        int[] group = { -1,0,0,-1 };
       // int[][] beforeItems = { {}, { 6 }, { 5 }, { 6 }, { 3, 6 }, {}, {}, {} };
        int[][] beforeItems = { {},{0},{1,3},{2} };

        ArrayList<Integer>[] parents = new ArrayList[m];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = new ArrayList<>();
        }
        for (int i = 0; i < group.length; i++) {
            if (group[i] != -1)
                parents[group[i]].add(i);
        }

        System.out.println(Arrays.toString(parents));
        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];
        boolean[] printed = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                boolean rec = dfs(group, beforeItems, parents, i, visited, inStack,printed, ans);
                if (rec) {
                    System.out.println("not possible");
                    return;
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean dfs(int[] group, int[][] beforeItems, ArrayList<Integer>[] parents, int idx,
        boolean[] visited, boolean[] inStack, boolean[] printed, ArrayList<Integer> ans) {
        inStack[idx] = true;
        visited[idx]=true;
        for (int nie : beforeItems[idx]) {
            if (inStack[nie])
            return true;
            if (!visited[nie]) {
                boolean recAns = dfs(group, beforeItems, parents, nie, visited, inStack,printed, ans);
                if (recAns)
                    return true;
            }
        }
        if (!printed[idx]) {
            printed[idx]=true;
            ans.add(idx);
            int p = group[idx];
            if (p != -1) {
                ArrayList<Integer> componentMembers = parents[p];
                for (int i = 0; i < componentMembers.size(); i++) {
                    if(componentMembers.get(i)!=idx){
                        printed[componentMembers.get(i)] = true;
                        ans.add(componentMembers.get(i));
                    }
                }
            }

        }

        inStack[idx] = false;
        return false;

    }

}