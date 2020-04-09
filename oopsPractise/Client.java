import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Client{
    public static void main(String[] args) {
        int [] ages= {  89,121,987,23  };
        String [] names ={ "rishu","dikshu","mohan","ram"};

        // PriorityQueue<MyNode> queue = new PriorityQueue<>(new Comparator< MyNode >(){
        //     @Override
        //     public int compare(MyNode a,MyNode b){
        //         return  a.age - b.age;
        //     }
        // }  );
      
        
        MyNode [] arr =new MyNode [4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new MyNode(names[i], ages[i]);
        }

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // for (int i = 0; i < arr.length; i++) {
        //     queue.add(arr[i]);
        // }


        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println(queue.poll());
        // }
    }
}