public class AmanSethi{

    public static class Node{
        Node left ;
        Node right ;
        int data;
    }
    
    public static class allPair {
        int height = 0;
        int size = 0;
        boolean find = false;

        int ceil = (int) 1e8;
        int floor = (int) -1e8;

        Node pred = null;
        Node succ = null;
        Node prev = null;
    }

    public static void allSol(Node node, int level, int data, allPair sol) {
        if (node == null)
            return;

        sol.size++;
        sol.height = Math.max(sol.height, level);
        sol.find = sol.find || node.data == data;

        if (node.data > data && node.data < sol.ceil)
            sol.ceil = node.data;

        if (node.data < data && node.data > sol.floor)
            sol.floor = node.data;

        if (node.data == data && sol.pred == null) {
            sol.pred = sol.prev;
        }

        if (sol.prev != null && sol.succ == null && sol.prev.data == data) {
            sol.succ = node;
        }

        sol.prev = node;

        allSol(node.left, level + 1, data, sol);
        allSol(node.right, level + 1, data, sol);

    }
}