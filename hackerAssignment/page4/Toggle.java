import java.util.Scanner;

public class Toggle{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.next();
        ToggleString(str);

    }
    public static int Complement(int m){
        if(m>=65&&m<=90){
             return m+32;
        }
        if(m>=97&&m<=122){
            return m-32;
        }
        return m;
    }


    public static void ToggleString (String str){
        for(int i=0;i<str.length();i++){
            int curr=(int)str.charAt(i);
            int comp=Complement(curr);
            char cc=(char)comp;
            System.out.print(cc);
        }
    }
}