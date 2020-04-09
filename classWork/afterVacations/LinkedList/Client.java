
public class Client {

    public static void main(String[] args) throws Exception {
        _LinkedList lista = new _LinkedList();

        int [] a ={3,5};

        for (int i = 0; i < a.length; i++) {
            lista.addLast(a[i]);
        }

        lista.display();
        lista.reverseBetwn(1,2);
        lista.display();
        
        
    }


}