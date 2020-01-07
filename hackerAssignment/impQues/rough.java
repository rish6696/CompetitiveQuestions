
import java.util.*;
public class rough{
    public static void main(String[] args) {
        // char cc ='9';
        // char code = (char) (cc - '1' + 'a');
        // System.out.println(code);
         System.out.println(powTwo(2));
     
    }

    public static boolean powTwo(int n){
         int i=0;
        int pow=0;
        while(pow<n){
            pow=(1<<i);
            if(pow==n){
                return true;
            }
            i++;
        }
        return false;
    }

    private static void printCodes(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch1 = str.charAt(0);
        char code = (char) (ch1 - '1' + 'a');
        printCodes(str.substring(1), ans + code);

        if (str.length() >= 2 && ch1 <= '2') {
            int i = Integer.parseInt(str.substring(0, 2), 10);
            if (i > 0 && i <= 26) {
                code = (char) (i + 'a' - 1);
                printCodes(str.substring(2), ans + code);
            }
        }
    }
}