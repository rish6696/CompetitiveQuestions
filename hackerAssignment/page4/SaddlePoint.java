import java.util.Scanner;
public class SaddlePoint {
    public static  void main(String [] args){
        Scanner s=new Scanner (System.in);
        int m=s.nextInt();
        int n=s.nextInt();
        int [][] arr=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=s.nextInt();
            }
        }
        int ans=saddlePoint(arr);
        if(ans==0) System.out.println("No Such Point Exist");
   
    }
    public static int saddlePoint(int[][]arr){
        int not=0;
        for(int i=0;i<arr.length;i++){
            int []array=arr[i];
            int minIndex=0;
            for(int j=1;j<array.length;j++){
                if(array[j]<array[minIndex]){
                    minIndex=j;
                }
            }
            int j=0;
            while(j<arr.length){
                if(j!=i&&arr[j][minIndex]>arr[i][minIndex]){
                    break;
               }
               j++;
            }
            if(j==arr.length){
                  not++;
                  System.out.println(arr[i][minIndex]);
            }
        }
        return not;
    }
}