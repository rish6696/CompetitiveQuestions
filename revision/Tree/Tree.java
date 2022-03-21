import java.util.ArrayList;
import java.util.List;

public class Tree {

    int[] arr;
    TreeNode root;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;

        }
    }

    public void createTree(int[] arr) {
        this.arr = arr;
        int[] i = { 0 };
        this.root = createRecursion(i);
    }

    private TreeNode createRecursion(int[] i) {

        if (i[0] >= this.arr.length)
            return null;

        if (arr[i[0]] == -1) {
            i[0]++;
            return null;
        }

        TreeNode node = new TreeNode(this.arr[i[0]]);
        i[0]++;

        node.left = createRecursion(i);
        node.right = createRecursion(i);
        return node;
    }

    public void display() {
        display(this.root);
    }

    private void display(TreeNode root) {

        String left = root.left == null ? "NULL" : root.left.val + "";
        left = left + "=>";
        String right = root.right == null ? "NULL" : root.right.val + "";
        right = "<=" + right;

        System.out.println(left + root.val + right);

        if (root.left != null)
            display(root.left);

        if (root.right != null)
            display(root.right);
    }

    public List<Integer> getPath(int fireNode) {
        List<TreeNode> list = new ArrayList<>();

        getPath(this.root, list, fireNode);

        List<Integer> ans = new ArrayList<>();

        for (TreeNode k : list) {
            ans.add(k.val);
        }
        return ans;
    }

    private boolean getPath(TreeNode node, List<TreeNode> list, int fireNode) {

        if (node.val == fireNode) {
            list.add(node);
            return true;
        }

        list.add(node);

        boolean la = false;

        if (node.left != null) {
            la = getPath(node.left, list, fireNode);
        }

        if (la) return true;

        boolean ra = false;

        if (node.right != null) {
            ra = getPath(node.right, list, fireNode);
        }

        if (ra)
            return true;

        list.remove(list.size() - 1);
        return false;

    }


    public int lca(int B, int C) {

        int [] found ={0};

        TreeNode ans = dfs(this.root,B,C,found);

        if ( ans == null  ) return -1;

        if( found[0]==1 ){
            if(B==C) return ans.val;
            else return -1;
        }

        return ans.val;
    }


    private TreeNode dfs(TreeNode curr,int B,int C,int []found){
        if( curr == null) return null;

    
    
        if(curr.val == B || curr.val == C ){
            found[0]++;
            return curr;
        }

        TreeNode left = dfs(curr.left,B,C,found);
        TreeNode right = dfs(curr.right,B,C,found);

        if(left!= null && right!= null){
            return curr;
        }

        if(left != null){
            return left;
        }

        if(right!= null){
            return right;
        }

        return null;
    }

}