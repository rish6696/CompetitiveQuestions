import java.util.Scanner;

public class numLexi{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        print(1, 9,n);
        
    }
    public static void print(int start,int end,int n){ 
        while(start<=end&&start<=n){
            System.out.println(start);
            print(start*10,start*10+9,n);
            start++;
        }
    }
}