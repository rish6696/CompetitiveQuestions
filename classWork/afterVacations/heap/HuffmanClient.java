import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HuffmanClient{
    public static void main(String[] args) {

        PriorityQueue<List<Integer>> q = new PriorityQueue<>( new Comparator<List<Integer>>() {
               @Override
               public int compare(List<Integer>a,List<Integer> b){
                   return b.get(0)-a.get(0);
               }
        }  );





       int [] arr =new int [26];

       int k =30;

       for (int i = 0; i < arr.length; i++) {
           arr[i] = k;
           k--;
       }
       HuffManED h =new HuffManED(arr);

       String str ="abc";
       String en = h.enCodeString(str);
       System.out.println(en);
       String de =h.deCodeString(en);
       System.out.println(de);
    }
}