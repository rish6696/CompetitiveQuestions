public class BinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int lh;
        int rh;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.lh = 0;
            this.rh = 0;
        }
    }

    TreeNode root = null;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(int[] arr) {
        this.root = treeFromArray(arr, 0, arr.length - 1);
    }

    private TreeNode treeFromArray(int[] arr, int s, int e) {
        if (s > e)
            return null;
        int mid = (s + e) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = treeFromArray(arr, s, mid - 1);
        node.right = treeFromArray(arr, mid + 1, e);
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        getString(this.root, sb);
        return sb.toString();
    }

    private void getString(TreeNode node, StringBuilder sb) {

        if (node == null)
            return;
        String left = node.left == null ? "NULL=>" : node.left.val + "=>";
        String right = node.right == null ? "<=NULL" : "<=" + node.right.val;
        sb.append(left);
        sb.append(node.val);
        sb.append(right);
        sb.append("\n");
        getString(node.left, sb);
        getString(node.right, sb);
    }

    public void addNode(int data) {
        this.root = addNode(this.root, data);
    }

    private TreeNode rrRotation(TreeNode node){
        TreeNode temp = node.right;
        node.right=temp.left;
        temp.left=node;


        node.lh = node.left!=null ? Math.max(node.left.rh, node.left.lh)+1:0;
        node.rh = node.right!=null? Math.max(node.right.rh,node.right.lh)+1:0;

        temp.lh =temp.left!=null ? Math.max(temp.left.rh, temp.left.lh)+1:0;
        temp.rh = temp.right!=null? Math.max(temp.right.rh,temp.right.lh)+1:0;

        return temp;
    }


    private TreeNode llRotation(TreeNode node){
        TreeNode temp = node.left;
        node.left=temp.right;
        temp.right=node;


      
        node.lh = node.left!=null ? Math.max(node.left.rh, node.left.lh)+1:0;
        node.rh = node.right!=null? Math.max(node.right.rh,node.right.lh)+1:0;

        temp.lh =temp.left!=null ? Math.max(temp.left.rh, temp.left.lh)+1:0;
        temp.rh = temp.right!=null? Math.max(temp.right.rh,temp.right.lh)+1:0;
        return temp;
    }

    private TreeNode addNode(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        }
        if (data < node.val) {
            TreeNode recans = addNode(node.left, data);
            node.left = recans;
            node.lh = Math.max(recans.lh, recans.rh) + 1;
        } else {
            TreeNode recans = addNode(node.right, data);
            node.right = recans;
            node.rh = Math.max(recans.lh, recans.rh) + 1;
        }
        int bf = node.lh-node.rh;
        if(bf ==-2){
           if(node.right.right==null){
               //its a rl rotation 
               TreeNode temp = llRotation(node.right);
               node.right= temp;
               node.rh = Math.max(node.right.rh, node.right.lh)+1;
               node= rrRotation(node);
           }else{
               // its a rr rotation
               node=rrRotation(node);
           }
        }else if(bf ==2){

            if(node.left.left==null){
                //its a lr rotation 
                TreeNode temp = rrRotation(node.left);
                node.left= temp;
                node.lh = Math.max(node.left.lh, node.left.rh)+1;
                node=llRotation(node);
            }else{
                // its a ll rotation
                node=llRotation(node);
            }
        }
        return node;
    }

    public void removeNode(int data) {
        this.root = removeNode(this.root, data);
    }

    private int greatestLeft(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    public void printHeights() {
        printHeights(this.root);
    }

    private void printHeights(TreeNode node) {
        if (node == null)
            return;
        System.out.println(node.val + " lh=>" + node.lh + " rh=>" + node.rh);
        printHeights(node.left);
        printHeights(node.right);
    }

    private TreeNode removeNode(TreeNode node, int data) {

        if (node == null)
            return null;
        if (node.val == data) {
            if (node.left == null && node.right == null)
                return null;
            if (node.left == null)
                return node.right;
            if (node.left == null)
                return node.left;

            int leftG = greatestLeft(node.left);
            node.val = leftG;
            TreeNode recans = removeNode(node.left, leftG);
            if (recans == null) node.lh = 0;
            else node.lh = Math.max(recans.lh, recans.rh) + 1;
            
        } else if (data < node.val) {
            TreeNode recans = removeNode(node.left, data);
            node.left = recans;
            if (recans == null) {
                node.lh = 0;
            } else {
                node.lh = Math.max(recans.lh, recans.rh) + 1;
            }
        } else {
            TreeNode recans = removeNode(node.right, data);
            node.right = recans;
            if (recans == null) {
                node.rh = 0;
            } else {
                node.rh = Math.max(recans.lh, recans.rh) + 1;
            }
        }


        int bf = node.lh-node.rh;
        if(bf ==-2){
           if(node.right.right==null){
               //its a rl rotation 
               TreeNode temp = llRotation(node.right);
               node.right= temp;
               node.rh = Math.max(node.right.rh, node.right.lh)+1;
               node= rrRotation(node);
           }else{
               // its a rr rotation
               node=rrRotation(node);
           }
        }else if(bf ==2){

            if(node.left.left==null){
                //its a lr rotation 
                TreeNode temp = rrRotation(node.left);
                node.left= temp;
                node.lh = Math.max(node.left.lh, node.left.rh)+1;
                node=llRotation(node);
            }else{
                // its a ll rotation
                node=llRotation(node);
            }
        }
        return node;
    }
}