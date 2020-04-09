
import java.util.Arrays;
public class _101SymmetricTree extends Tree {

    

    public static void main(String[] args) {
      // int []preOrder={1,2,3,-1,-1,4,-1,-1,2,4,-1,-1,3,-1,-1};
      // int []preOrder={1,2,-1,3,-1,-1,2,-1,3,-1,-1};
      //int [] preOrder={3,4,5,6,-1,-1,-1,-1,4,-1,5,-1,6,-1,-1};
      // int [] preOrder={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
      //int [] preOrder={5,4,11,7,-1,-1,2,-1,-1,-1,8,13,-1,-1,4,5,-1,-1,1,-1,-1};
      // int [] preOrder={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1}; //complete tree
      //int [] preOrder={ -10,9,-1,-1,20,15,-1,-1,7,-1,-1};
   //   int [] preOrder={1,2,4,-1,-1,5,-1,-1,3,-1,7,-1,-1};



   
      int [] preOrder={-1,-2,-1,-2,-2};
      Tree t =new Tree(preOrder);
      t.display();

      System.out.println("********************");
    //  System.out.println(t.maxAncestorDiff());

     


    }
}