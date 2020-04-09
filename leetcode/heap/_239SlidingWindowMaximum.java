
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Deque;
public class _239SlidingWindowMaximum{
    public static void main(String[] args) {
        int [] arr ={1,3,-1,-3,5,3,6,7};
        int k =3;
        System.out.println(Arrays.toString(maxSlidingWindow(arr,k)));

    }


    public static  int[] maxSlidingWindow(int[] nums, int k) {
        
        List<Integer> list = new ArrayList<>();
        
        
        Deque<Integer> queue = new LinkedList<>();
        
        // first consider only the k size window
        
        for(int i =0;i<k;i++){
            
            int val = nums[i];
            while(!queue.isEmpty() &&  val > nums[queue.getLast()] ){
                queue.removeLast();
            }
            queue.addLast(i);
        }
        
        
        // second phase
        for(int i =k;i<=nums.length;i++){
            
            // add the current max to the list 
            list.add(nums[queue.getFirst()]);
            
            // remove those elemnts from the queue which are out of bound for cuurent i 
            
            while(!queue.isEmpty() && queue.getFirst()<= i-k) queue.removeFirst();
            
            // remove the val in the queue less than the current val
            if(i<nums.length){
                int val =nums [i];
                while(!queue.isEmpty() && val>nums[queue.getLast()] ){
                    queue.removeLast();
                }
                
                queue.addLast(i);
            }
            
        }
        
        
        int [] ans =new int [list.size()];
        for(int m =0 ;m< ans.length ;m++){
            ans[m]= list.get(m);
        }
        return ans;
             
        
    }
}