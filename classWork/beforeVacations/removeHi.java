import java.util.*;
public class removeHi{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str="hihihitu";
       // int  n=s.nextInt();
       System.out.println(reHit(str));
       printHit(str, "", 0);
       System.out.println(countHit(str));
    }
    public static void printRemove(String str,String result,int start){
        if(start>str.length()-1){
            System.out.println(result);
           return ;
        }
        if(start==str.length()-1){
           System.out.println(result+str.charAt(start));
           return ;
        }
        if((str.substring(start,start+2)).equals("hi")){
            printRemove(str,result,start+2);
            return ;
        }
        printRemove(str,result+str.charAt(start),start+1);
    }

    public static int countHi(String str){
        if(str.length()==1){
            return 0;
        }
        char cc=str.charAt(0);
        String ros=str.substring(1);
        int recAns=countHi(ros);
        if(cc=='h'&& ros.charAt(0)=='i')return recAns+1;
        return recAns;
    }
    public static String remove(String str){
        if(str.length()==1){
            return str;
        }
        if(str.length()==2){
            if(str.charAt(0)=='h'&&str.charAt(1)=='i'){
            return "";
           }else{
                return str;
            }
        }
        String ros=str.substring(2);
        String recAns=remove(ros);
        if(str.charAt(0)=='h'&&str.charAt(1)=='i'){
            return recAns;
        }else{
            return str.charAt(0)+""+str.charAt(1)+""+recAns;
        }
    }

    public static String  reHit(String str){
        if(str.length()==0){
            return "";
        }
        char cc=str.charAt(0);
        String ros=str.substring(1);
        String recAns=reHit(ros);
        if(recAns.length()==0)return cc+"";
        if(cc=='h'&&recAns.charAt(0)=='i'){
             if(recAns.length()==1){
                return "";
             }
             if(recAns.charAt(1)=='t'){
                return cc+recAns;
             }
             return recAns.substring(1);
        }
        return cc+recAns;

    }

    public static void  printHit(String str,String result,int start){
        if(start>str.length()-1){
            System.out.println(result);
            return;
        }
        if(start==str.length()-1){
            System.out.println(result+str.charAt(start));
            return ;
        }
        if(str.substring(start,start+2).equals("hi")){
            if(start==str.length()-2){
                printHit(str, result, start+2);
                return;
            }
            if(str.charAt(start+2)=='t'){
                 printHit(str, result+"hit", start+3);
                 return ;
            }
            printHit(str, result, start+2);
            return;
             
        }
        printHit(str, result+str.charAt(start),start+1);


    }


    public static int countHit(String str){
        if(str.length()==1){
            return 0;
        }
        char cc=str.charAt(0);
        String ros=str.substring(1);
        int recAns=countHit(ros);
        if(cc=='h'&&ros.charAt(0)=='i'){
              if(ros.length()==1){
                  return recAns+1;
              }
              if(ros.charAt(1)=='t'){
                  return recAns;
              }
              return recAns+1;
        }
        return recAns;

    }

    // public static String removeHit(String str){

    //     String cc5=str.substring(0,3);
    //     String recAns=removeHit(str.substring(3));
    //     if(cc.equals("hit")){
    //          return cc+recAns;
    //     }
    // }
}