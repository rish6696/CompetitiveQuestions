
public class Client {
   public static void main(String[] args) {
      
       //int [] arr ={50,20,70,10,30,60,80,40,90};
       BinaryTree tree = new BinaryTree();
       for (int i = 1; i < 10;i++) {
           tree.addNode(i*10);
       }
      System.out.println(tree);
      // tree.printHeights();

       System.out.println("***************************");
       tree.removeNode(30);
       tree.removeNode(10);
       tree.removeNode(20);

       System.out.println(tree);
   

      // tree.printHeights();
   }
} 