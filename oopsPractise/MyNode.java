public class MyNode implements Comparable<MyNode> {

    String name ;
    int age ;
    public MyNode (String name,int age) {
       this.name=name;
       this.age=age;
    }


    @Override
    public int compareTo(MyNode o){
        return this.age-o.age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name = "+this.name+", age = "+this.age);
        return sb.toString();
    }
}