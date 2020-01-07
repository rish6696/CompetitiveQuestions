import java.util.ArrayList;

public class possibleCodes{
    public static void main(String[] args) {
        String str="1123";
       // print(str, "");
       System.out.println(get(str));
    }

    public static ArrayList<String> get(String str){
        if(str.length()==0){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        String cc=str.substring(0, 1);
        int value=Integer.parseInt(cc, 10);
        char toAdd=(char)(value+96);
        ArrayList<String> myAns=new ArrayList<>();
        ArrayList<String> recAns=get(str.substring(1));
        if(value!=0){
             for(String s:recAns){
                 myAns.add(toAdd+s);
             }
        }else{
            for(String s:recAns){
                 myAns.add(s);
             }
        }
        if(str.length()>=2){
            cc=str.substring(0,2);
            value=Integer.parseInt(cc, 10);
            if(value>=10&&value<=26){
                toAdd=(char)(value+96);
                recAns=get(str.substring(2));
                for(String s:recAns){
                 myAns.add(toAdd+s);
            }    
          }
          
        }
        return myAns;
    }


    public static void print(String str,String result){
        if(str.length()==0){
            System.out.println(result);
            return ;
        }
        String cc=str.substring(0, 1);
        int value=Integer.parseInt(cc, 10);
        char toAdd=(char)(value+96);
        if(value!=0){
             print(str.substring(1), result+toAdd);
        }else{
             print(str.substring(1), result);
        }
        
        if(str.length()>=2){
            cc=str.substring(0,2);
            value=Integer.parseInt(cc, 10);
            if(value>=10&&value<=26){
                toAdd=(char)(value+96);
                print(str.substring(2), result+toAdd);
            }
          
        }
    }
}