public class NextPointerTree {

    public class Node{
        int val =0;
        Node next=null;
        Node left=null;
        Node right=null;

        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
       
    }


    public void display(){
        display(this.root);
    }


private void display (Node node){
    if(node==null)return;
    StringBuilder str =new StringBuilder();
    if(node.left==null) str.append("Null");
    else str.append(node.left.val);
    str.append("=>");
    str.append(node.val+"<=");
    if(node.right==null)str.append("Null");
    else str.append(node.right.val);


    String nxt =node.next!=null? node.next.val+"":"NUll";

    System.out.println(str+ " Next of this node is "+nxt);
    
    display(node.left);
    display(node.right);
    
}

    private Node root;
    private int [] preOrder=null;
    private int idx =0;
 
  
    public NextPointerTree(int[]preOrder){
       this.preOrder=preOrder;
       this.idx=0;
       root=createTree();
    }

    public Node createTree(){
        if( this.preOrder[idx]==-1){
            idx++;
            return null;
        }
        Node node =new Node(preOrder[idx]);
        idx++;
        node.left=createTree();
        node.right=createTree();
        return node;
        
    }

    public static int height(Node node){
        if(node==null)return -1;
        int l =height(node.left);
        int r =height(node.right);
        return Math.max(l, r) +1;
    }

    public void populate(){
        int height=height(this.root);
        for (int i = 0; i <=height; i++) {
            Node [] prev =new Node[1];
            prev[0]=null;
            populateRecursion(0, i, this.root, prev);
        }
    }

    private void populateRecursion(int curLevel ,int level ,Node curNode,Node[] prev){
        if(curLevel==level){
            if(prev!=null){
                curNode.next=prev[0];
                prev[0]=curNode;
                return ;
            }
            return ;
        }
        populateRecursion(curLevel+1, level, curNode.right, prev);
        populateRecursion(curLevel+1, level, curNode.left, prev);
    }



    

}