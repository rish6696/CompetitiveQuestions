public class MajorityElement{
    public static void main(String[] args) {
        int []arr={1,1,1,3,3,2,2,2};
        System.out.println(MajorityElementII(arr));
    }


    public static int MajorityElementII(int []arr){
        int []ans=new int [2];
        int first =Integer.MAX_VALUE;
        int second =Integer.MAX_VALUE;
        int count1=0;
        int count2=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==first)count1++;
            else if(arr[i]==second)count2++;
            else if(count1==0)first=arr[i];
            else if(count2==0)second=arr[i];
            else{
                count1--;
                count2--;
            }
            
        }
        count1=0;
        count2=0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==first)count1++;
            if(arr[i]==second)count2++;
        }
        int s=0;

        if(count1>arr.length/3)return first;
        if(count2>arr.length/3)return second;
        
        return -1;

    }


    public static int  MajorityI(int []arr){
        int count =1;
        int majorityIndex=0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]==arr[majorityIndex]) count++;
            else count--;
            if(count==0){
                count=1;
                majorityIndex=i;
            }
        }
        count =0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==arr[majorityIndex]){
                count++;
            }
        }
        if(count>arr.length/2) return arr[majorityIndex];
        return Integer.MIN_VALUE;


    }
}