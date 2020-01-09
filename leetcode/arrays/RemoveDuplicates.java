public class RemoveDuplicates{
    public static void main(String[] args) {
        int []arr={0,0,0,1,1,1,2,2,3,3,4,4,5};
    
        int a=removeDuplicateII(arr);
        System.out.println(removeDuplicateII(arr));
        for (int i = 0; i <=a; i++) {
            System.out.print(arr[i]+" ");
        }
        
    }

    public static int removeDuplicateI(int[] arr){
        int i=0;
        for (int j = 1; j < arr.length; j++) {
            if(arr[j-1]!=arr[j]){
               i++;
               arr[i]=arr[j];
            }
            
        }
        return i;
    }

    public static int removeDuplicateII(int[] arr){
        int i=0;
        int counter=1;
        for (int j = 1; j < arr.length; j++) {
            if(arr[j-1]!=arr[j]){
               i++;
               arr[i]=arr[j];
               counter=1;
            }else{
               if(counter==1){
                   i++;
                   arr[i]=arr[j];
               }
               counter++;
            }
            
        }
        return i;
    }


}