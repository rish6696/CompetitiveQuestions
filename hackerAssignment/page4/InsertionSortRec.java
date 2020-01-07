import java.util.Scanner;

public class InsertionSortRec {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        Insertion(arr,0,0,0);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        
    }
    public static void Insertion(int[]arr,int i,int j,int minIndex){
        if(i>arr.length-2){
            return ;
        }
        if(j>arr.length-1){
             int temp=arr[i];
             arr[i]=arr[minIndex];
             arr[minIndex]=temp;
             Insertion(arr,i+1,i+1,i+1);
             return ;
        }
        if(arr[j]<arr[minIndex]){
            minIndex=j;
        }
        Insertion(arr,i,j+1,minIndex);
        
    }
}