
import java.util.Arrays;
import java.util.Stack;
public class HeapClient {

    public static void main(String[] args) {

        Integer [] arr ={2, 5 ,3 ,4 ,6 ,9, 28,21 , 45 ,5 };
        Heap heap =new Heap( arr, false );
        System.out.println(Arrays.toString(heap.heapSort()));     
    }



    // public static void next_greater_right(int []arr){
    //     Stack <Integer> st=new Stack<>();
    //     for(int i=0;i<arr.length;i++){
    //         if(st.size()==0){
    //             st.push(arr[i]);
    //             continue;
    //         }
    //         while(st.size()!=0 && st.peek()<arr[i]){
    //             System.out.println(st.pop()+"->"+arr[i]);
    //         }
    //         st.push(arr[i]);
    //     }
    //     while(st.size()!=0){
    //         System.out.println(st.pop()+"->"+"-1");
    //     }
    // }
}