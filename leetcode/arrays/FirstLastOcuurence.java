public class FirstLastOcuurence{
    public static void main(String[] args) {
        int[]arr={5,7,7,8,8,8,10};
        System.out.println(Ocuurenece(arr, 6,true));
        System.out.println(Ocuurenece(arr, 6,false));

    }

    public static int Ocuurenece(int[]arr,int target,boolean firstOccurrence){
        int left=0;
        int right =arr.length-1;
        int bestOcuurence=firstOccurrence?Integer.MAX_VALUE:Integer.MIN_VALUE;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){
              if(firstOccurrence){
                bestOcuurence=Math.min(bestOcuurence, mid);
                right=mid-1;
              }else{
                  bestOcuurence=Math.max(bestOcuurence, mid);
                  left=mid+1;
              }
            }else if(arr[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return bestOcuurence==Integer.MAX_VALUE || bestOcuurence==Integer.MIN_VALUE ?-1:bestOcuurence;
    }

}