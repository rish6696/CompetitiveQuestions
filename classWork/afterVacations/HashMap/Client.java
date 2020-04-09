import java.util.HashMap;
import java.util.LinkedList;

public class Client{
    public static void main(String[] args) {
        
        HashMap_ map =new HashMap_();
        map.put(3, 20);
        map.put(13, 79);
        map.put(33, 210);
        map.put(43, 210);
        map.put(53, 210);

        System.out.println(map.keySet());

        map.remove(43);

        System.out.println(map.keySet());
    }
}