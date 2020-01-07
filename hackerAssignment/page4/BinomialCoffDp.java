import java.util.*;
public class BinomialCoffDp{
    public static void main(String[] args) {
       // Scanner s=new Scanner(System.in);
        // int n=s.nextInt();
        // int r=s.nextInt();
        //System.out.println(combination(4, 2));
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        
        System.out.println(isSorted(arr,0));
    }
    public static boolean isSorted(int[]arr,int i){
        if(i==0)return true;
        if(arr[i]>arr[i+1])return false;
        return isSorted(arr,i+1);
    }

    public static int combination(int n,int r){
        int[][] arr=new int[n+1][r+1];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<=r&&j<=i;j++){
                if(j==0||i==j){
                   arr[i][j]=1;
                }else{
                    arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
                }
            }
        }
        return arr[n][r];
    }
}