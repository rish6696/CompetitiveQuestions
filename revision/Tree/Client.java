public class Client {
    public static void main(String[] args) {
        int[] arr = { 5,25,7,4,-1,-1,9,-1,-1,24,-1,33,-1,-1,23,11,-1,13,-1,-1,32,-1,-1  };

        Tree t = new Tree();

        t.createTree(arr);
     System.out.println(t.lca(5, 33));

     // System.out.println( t.getPath(7));
    }
}
