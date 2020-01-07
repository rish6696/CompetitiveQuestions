import java.util.Arrays;
public class FirstPositiveMissing{
    public static void main(String[] args) {

        int []arr={0};
        System.out.println(missingNegative(arr));
        // System.out.println(geeksAllPositiveSolution(arr, arr.length));   

    }

    public static int segregate(int[]arr){
        int pindex=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<=0){
                swap(arr, i, pindex);
                pindex++;
            }
        }
        return pindex;
    }
    public static void swap(int []arr,int i,int j){
        arr[i]^=arr[j];
        arr[j]^=arr[i];
        arr[i]^=arr[j];

    }


    public static int missingNegative(int []arr){
        int pindex=segregate(arr);
        int[] newArray=new int [arr.length-pindex];
        for(int i=0;i<newArray.length;i++){
            newArray[i]=arr[i+pindex];
        }
        return missingPositive(newArray);

    }

    public static int missingPositive(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            int val =Math.abs(arr[i]);
            if( val>0 && val-1<arr.length&& arr[val-1] >0 ){
                arr[val-1]=-arr[val-1];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>0){
                return i+1;
            }
        }
        return arr.length+1;
    }

    public static int  geeksAllPositiveSolution(int[]arr,int size){
        int i; 
  
        // Mark arr[i] as visited by making 
        // arr[arr[i] - 1] negative. Note that 
        // 1 is subtracted because index start 
        // from 0 and positive numbers start from 1 
        for (i = 0; i < size; i++) { 
            int x = Math.abs(arr[i]); 
            if (x>0&& x - 1 < size && arr[x - 1] > 0) 
                arr[x - 1] = -arr[x - 1]; 
        } 
  
        // Return the first index value at which 
        // is positive 
        for (i = 0; i < size; i++) 
            if (arr[i] > 0) 
                return i + 1; // 1 is added becuase indexes 
        // start from 0 
  
        return size + 1; 
    }
}