import java.lang.Math;
public class Index{
    public static void main(String[] args) {
       // System.out.println(ithBit(4, 1));
      // System.out.println(rightShift(2, 3));
      System.out.println(rightSetBit(8));
        
    }

    public static int rightShift(int a,int b){
        return (a<<b);
    }

    public static int rightSetBit(int n){
        return (int)(Math.log(n)/(Math.log(2)));
    }




    public static int ithBit(int n,int i){
        return (n&1<<i)==0?0:1;
    }
}