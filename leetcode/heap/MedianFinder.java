import java.util.Comparator;
import java.util.PriorityQueue;
public class MedianFinder {

    /** initialize your data structure here. */
    
    private PriorityQueue<Integer> maxHeap ;
    private PriorityQueue<Integer> minHeap ;
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(  new Comparator<Integer>(){
            
            @Override
            public int compare(Integer a,Integer b){
                return b -a ;
            }
            
        }   );
        
        minHeap = new PriorityQueue<>();
        
    }
    

    
    
    public void addNum(int num) {
        
        maxHeap.add(num);
        int val= maxHeap.poll();
        minHeap.add(val);
        
        
        //balance 
        if(maxHeap.size() < minHeap.size() ){
            maxHeap.add( minHeap.poll() );
        }
        
    }
    
    public double findMedian() {
        
        if(maxHeap.size()==minHeap.size()) return 1.0 * maxHeap.peek();
        else {
            int a = maxHeap.peek();
            int b = minHeap.peek();
            
            double d = (double)(a+b)/2;
            return d;
            
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */