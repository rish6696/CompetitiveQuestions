public class Pallindrome{
    public static void main(String[] args){
       String str="aBcba";
       System.out.println(isPallindrome(str));
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

    public static boolean isPallindrome(String str){
        int left=0;
        int right=str.length()-1;
        while(left<right){
           int leftval=(int)str.charAt(left);
           int rightVal=(int)str.charAt(right);
           int lc=Complement(leftval);
           if(rightVal!=leftval&&rightVal!=lc){
               return false;
           }
           left++;
           right--;
           
        }
        return true;
       
    }
}