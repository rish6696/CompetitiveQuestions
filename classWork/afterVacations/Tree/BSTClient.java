public class BSTClient{
    public static void main(String[] args) {
        int [] preOrder={10,5,3,7,15,18};
        BST bst =new BST();
        for (int i = 0; i < preOrder.length; i++) {
            bst.addNode(preOrder[i]);
        }
    
        bst.display();
        System.out.println(bst.rangeSum(7, 15));
          
    }

}