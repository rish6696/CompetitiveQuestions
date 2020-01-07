class Parent {
    public void run(){
        System.out.println("hello world in parent");
        int n;
        while((n=5)>0){

        }

    }
}


class Child extends Parent {
    public void run(){
        System.out.println("hello world from child");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Parent p=new Child();
        p.run();
    }
}