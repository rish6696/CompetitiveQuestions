public class PermutationPrint{
    public static void main(String[] args) {
      String str="abc";
      printPermutation(str, "");
    }

    public static void printPermutation(String str,String result){
        if(str.length()==0){
            System.out.println(result);
        }
        for(int i=0;i<str.length();i++){
            char cc=str.charAt(i);
            String ros=str.substring(0,i)+str.substring(i+1);
            printPermutation(ros,result+cc);
        }
    }
}