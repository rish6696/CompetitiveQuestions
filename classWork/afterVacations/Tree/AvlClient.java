public class AvlClient{
    public static void main(String[] args) {
        AVL t =new AVL();
        t.addNode(100);
        t.addNode(50);
        t.addNode(30);
        t.addNode(75);
        t.addNode(150);
        t.addNode(125);
        t.addNode(200);
        t.addNode(300);
        t.addNode(400);
        t.addNode(500);

    
        t.display();

        System.out.println("***************************");

       System.out.println(t.verticalView());
    }

      
}