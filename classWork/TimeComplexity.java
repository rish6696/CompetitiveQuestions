import java.util.Arrays;

public class TimeComplexity{
    public static void main(String[] args) {
        int[] arr={0,2,0,1,2,1,0,1};
         Sort_012(arr);
        System.out.println(Arrays.toString(arr));
       
    }
    public static int[] mergeSort(int[]arr,int low,int high){
        if(low==high){
            int[] base=new int[1];
            base[0]=arr[low];
            return base;
        }
        int mid=(low+high)/2;
        int[] left=mergeSort(arr, low, mid);
        int[] right=mergeSort(arr, mid+1, high);
        int[] ans =mergeSortedArray(left, right);
        return ans;
    }
    public static int[] mergeSortedArray(int[]arr,int []brr){

        int size=arr.length+brr.length;
        int []ans=new int[size];
        int i=0;
        int j=0;
        int k=0;
        while(i<arr.length&&j<brr.length){
            if(arr[i]<=brr[j]){
                ans[k]=arr[i];
                i++;
                k++;
            }else{
                ans[k]=brr[j];
                j++;
                k++;
            }
        }
        while(i<arr.length){
             ans[k]=arr[i];
             i++;
             k++;
            
        }
        while(j<brr.length){
            ans[k]=brr[j];
            j++;
            k++;   
        }
        return ans;
    }

    public static void sortOneTwo(int[]arr){
        int pindex=0;
        //int pivot=arr[arr.length-1];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                int temp=arr[i];
                arr[i]=arr[pindex];
                arr[pindex]=temp;
                pindex++;       
            }
        }
        // int temp=arr[arr.length-1];
        // arr[arr.length-1]=arr[pindex];
        // arr[pindex]=temp;

    }

    public static void quickSort(int[]arr,int low,int high){
         if(low>=high){
             return ;
         }
        int pindex=getPindex(arr, low, high);
        quickSort(arr, low, pindex-1);
        quickSort(arr, pindex+1, high);
    }

    public static int getPindex(int[]arr,int low,int high){
        int pindex=low;
        int pivot=arr[high];
        for(int i=low;i<=high-1;i++){
            if(arr[i]<=pivot){
                int temp=arr[i];
                arr[i]=arr[pindex];
                arr[pindex]=temp;
                pindex++;       
            }
        }
        int temp=arr[high];
        arr[high]=arr[pindex];
        arr[pindex]=temp;
        return pindex;

    }

    public static void swap(int[]arr,int fi,int si){
        arr[fi]^=arr[si];
        arr[si]^=arr[fi];
        arr[fi]^=arr[si];
    }


    public static void Sort_012(int[]arr){
        int idx=0;
        int pindex=0;
        int high=arr.length-1;
        while(idx<high){
            if(arr[idx]==0){
             swap(arr, idx, pindex);
              idx++;
              pindex++;
            }else if(arr[idx]==1){
               idx++;
            }else{
                swap(arr, high, idx);
                high--;
            }
        }
    }
}