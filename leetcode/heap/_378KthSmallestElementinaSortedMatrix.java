import java.util.HashSet;
import java.util.PriorityQueue;

public class _378KthSmallestElementinaSortedMatrix{

    public static void main(String[] args) {
        
    }

    public static class Pair implements Comparable<Pair> {
       int row;
       int col;
       int val;

       public Pair(int row,int col,int val){
          this.row =row;
          this.col =col;
          this.val =val;
       }

       @Override
       public int compareTo(Pair p){
           return p.val -this.val;
       }
    }

}
