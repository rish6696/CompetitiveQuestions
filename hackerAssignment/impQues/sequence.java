import java.util.Scanner;

public class sequence{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=s.nextInt();
        }
        System.out.println(decInc(arr)||IncDec(arr));
      //  System.out.println(IncDec(arr));
    }

        public static  boolean IncDec(int[]arr){
        boolean goingUp=true;
        int prev=arr[0],curr;
        int i=1;
        while(i<arr.length){
            curr=arr[i];
            if(curr>prev){
                if(!goingUp)return false;
            }else{
               goingUp=false;
            }
            i++;
            prev=curr;

        }
        return true;
    }

    public static  boolean decInc(int[]arr){
        boolean goingDown=true;
        int prev=arr[0],curr;
        int i=1;
        while(i<arr.length){
            curr=arr[i];
            if(curr>prev){
                goingDown=false;
            }else{
                if(!goingDown){
                    return false;
                }
            }
            i++;
            prev=curr;

        }
        return true;
    }
}