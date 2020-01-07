import java.util.Scanner;

public class squareRoot{
    public static void main(String[] args) {
      
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int p=s.nextInt();
        double tans=Math.sqrt(n);
        int intg=(int)Math.sqrt(n);

        String num=tans+"";
        int in=num.indexOf('.');
        System.out.print(intg+" ");
        System.out.print(intg+num.substring(in, in+p+1));  
    }

  

}