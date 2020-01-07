import java.util.Arrays;

public class PermutationSequence{
    public static void main(String[] args) {
        int n=2;
        int k=1;
       System.out.println(getPermutation("123456789", "", 115858));

    }

    public static String generateString(int n){
       String[]str={"1","12","123","1234","12345","123456","1234567","12345678","123456789"};
       return str[n-1];
    }

    public static int fact(int n){
        if(n==0)return 1;
        if(n==1)return 1;
        return n*fact(n-1);
    }

    public static String getPermutation(String str,String result,int k){
        if(str.length()==1){
            return result+str.charAt(0);
        }
        int perChar =fact(str.length()-1);
        // if(perChar==1){
        //      int m=k-1;
        //      String ros=str.substring(0, m)+str.substring(m+1);
        //      return getPermutation(ros, result+str.charAt(m), k);
             
        // }
        if(perChar<k){
           int m=k/perChar;
           int mod=k%perChar;
           if(mod==0){
               m=m-1;
           }
           String ros=str.substring(0, m)+str.substring(m+1);
           k=k-m*perChar;
           return getPermutation(ros, result+str.charAt(m),k);

        }else{
            int m=0;
            String ros=str.substring(0, m)+str.substring(m+1);
            return getPermutation(ros, result+str.charAt(0), k);
            

        }

      
    }
}