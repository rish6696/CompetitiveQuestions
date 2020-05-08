
public class Client {

    public static void main(String[] args) throws Exception {
        _LinkedList lista = new _LinkedList();

       // int [] a ={1,2,3,-3,-2};
        int [] a ={1,2,3,-3,4};

        for (int i = 0; i < a.length ; i++) {
            lista.addLast(a[i]);
        }

        lista.display();

        lista.removeConsecutiveZero();
        lista.display();

       
       
        
        
    }


}