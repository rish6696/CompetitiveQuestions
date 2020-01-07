import java.util.Scanner;

public class DuplicateRec {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.next();
        int in=s.nextInt();
        System.out.println(getDuplicateString(str,str.charAt(0),1));
    }

    public static String getDuplicateString(String str,char prev,int start){
        if(start==str.length())return str;
        char cur=str.charAt(start);
        if(cur==prev){
            String result=str.substring(0,start)+"*"+str.substring(start);
            return getDuplicateString(result,cur,start+1);
        }
        return getDuplicateString(str,cur,start+1);
    }
}