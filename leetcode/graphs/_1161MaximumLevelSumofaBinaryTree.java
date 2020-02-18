import java.util.LinkedList;

public class _1161MaximumLevelSumofaBinaryTree{


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        
    }

    public static int maxLevelSum(TreeNode root){
        LinkedList<TreeNode> queue =new LinkedList<>();
        queue.push(root);
        int level=1;
        int maxLevelSum  =Integer.MIN_VALUE;
        int maxlevel =0;
        while(!queue.isEmpty()){
           int size =queue.size();
           int sum =0;
           while(size>0){
            size--;
            TreeNode rmvNode =queue.removeFirst();
            sum+=rmvNode.val;
            if(rmvNode.left!=null) queue.addLast(rmvNode.left);
            if(rmvNode.right!=null)queue.addLast(rmvNode.right);
           }
           if(sum>maxLevelSum){
               maxLevelSum=sum;
               maxlevel=level;
           }
           level++;

        }
        return maxlevel;
    }
}