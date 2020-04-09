import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Rough{
    public static void main(String[] args) {



        System.out.println(Integer.parseInt("-987"));
        MyClass obj1 =new MyClass(10);
        MyClass obj2 =new MyClass(20);
        MyClass obj3 =new MyClass(30);

        List<MyClass> list =new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);

        ListIterator it =list.listIterator( list.size() );
        while( it.hasPrevious()){
            System.out.println(it.previous());
        }

    }

}





class MyClass{
    int a;
    public MyClass(int a){
       this.a=a;
    }

    @Override
    public String toString() {
        return this.a+"";
    }
}