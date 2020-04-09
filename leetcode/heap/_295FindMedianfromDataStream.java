import java.util.Deque;
import java.util.LinkedList;

public class _295FindMedianfromDataStream{
    public static void main(String[] args) {
        

        MedianFinder m =new MedianFinder();
        m.addNum(1);
        m.addNum(2);

        System.out.println(m.findMedian());

        m.addNum(3);
        System.out.println(m.findMedian());
    }
}