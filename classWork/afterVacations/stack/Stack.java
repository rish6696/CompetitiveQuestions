public class Stack {
    private int [] arr ;
    private  int top =-1;

    private static final int DEFAULT_CAPACITY = 10;

    public Stack(){
      this(DEFAULT_CAPACITY);
    }

    public Stack(int capacity){
     this.arr=new int [capacity];
    }

    public Stack(int []arr){
        this.arr=new int [2*arr.length];
        for (int i = 0; i < arr.length; i++) {
            this.arr[i]=arr[i];
        }
        this.top=this.arr.length-1;
    }

    public void push(int val) throws Exception {
      if(top+1==arr.length){
          throw new Exception("Stack OverFlow");
      }
      this.arr[++top]=val;
    }

    public void display(){
        for(int i =top;i>=0;i--){
            System.out.println(arr[i]);
        }
    }

    public boolean isEmpty(){
        return this.top==-1;
    }

    public int pop() throws Exception {
      if(top==-1){
        throw new Exception("Stack is Empty");
      }
      int rv =arr[top];
      arr[top]=0;
      top--;
      return rv;
    }


    public void fun(){
        System.out.println("inside stack");
    }

    public void fun1(){
        System.out.println("inside stack");
    }

   
}