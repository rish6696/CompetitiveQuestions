import java.util.Arrays;
import java.util.Scanner;

public class rough {
    public static void main(String[] args) {
        String str="9761";
        System.out.println(sortString(str));
    }

    public static String sortString(String str){
        char[] arr=str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);

    }

    public static int count (int cr,int cc,int er,int ec){
        if(cr>er||cc>ec){
            return 0;
        }
        if(cr==er&&cc==ec){
            return 1;
        }
        int count =0;
        count+=count(cr+1,cc,er,ec);
        count+=count(cr,cc+1,er,ec);
        return count;
    }
}