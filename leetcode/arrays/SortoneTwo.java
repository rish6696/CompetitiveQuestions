public class SortoneTwo{
    public static void main(String[] args) {
        int []arr={1,0,1,0,1,0};
        sortZeroOne(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void sortZeroOne(int []arr){
        int pindex=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                arr[pindex]^=arr[i];
                arr[i]^=arr[pindex];
                arr[pindex]^=arr[i];
                pindex++;
            }
        }
        System.out.println(pindex);
    }
}