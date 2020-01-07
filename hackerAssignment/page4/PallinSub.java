public class PallinSub{
    public static void main(String[] args) {
        String str="abbccd";
        printSStr(str);
    }

    public static void printSStr(String str){
        int count=0;
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                String substr=str.substring(i, j);
                if(isPallindrome(substr)){
                     count++;
                     System.out.println(substr);
                }
            }
        }
        System.out.println(count);
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
    public static int Complement(int m){
        if(m>=65&&m<=90){
             return m+32;
        }
        if(m>=97&&m<=122){
            return m-32;
        }
        return m;
    }
}