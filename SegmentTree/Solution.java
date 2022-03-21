public class Solution {
    public static void main(String[] args) {

        int [] arr = { 10,19,14,2,3,7,32,28 };
        SegmentTree tree = new SegmentTree(arr);

       // tree.printSegmentTree();

        // System.out.println(tree.maxQuery(3,5));
         System.out.println(tree.sumQuery(3,5));
    }
}
