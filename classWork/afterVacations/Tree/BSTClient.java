public class BSTClient{
    public static void main(String[] args) {
        int [] preOrder={3,1,2,4};
        BST bst =new BST();
        for (int i = 0; i < preOrder.length; i++) {
            bst.addNode(preOrder[i]);
        }
    
       // bst.display();
       bst.trimBST(1,2);


        
    }

}