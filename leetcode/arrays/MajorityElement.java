import java.util.*;

public class MajorityElement{
    public static void main(String[] args) {
        int []arr={2147483647};
        Integer [] a=MajorityElementII(arr);

        //System.out.println(Arrays.toString(a));
    }


    public static Integer []  MajorityElementII(int []arr){

    
        int first =Integer.MAX_VALUE;
        int second =Integer.MAX_VALUE;
        int count1=0;
        int count2=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==first&&arr[i]!=Integer.MAX_VALUE)count1++;
            else if(arr[i]==second&&arr[i]!=Integer.MAX_VALUE)count2++;
            else if(count1==0){
                first=arr[i];
                count1++;
            }
            else if(count2==0){
                second=arr[i];
                count2++;
            }
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
        ArrayList<Integer> ans=new ArrayList<>();
        

        if(count1>arr.length/3)ans.add(first);
        if(count2>arr.length/3)ans.add(second);

        System.out.println(ans);
         Integer[] a =new Integer[ans.size()];
         for (int i = 0; i < a.length; i++) {
            a[i]= ans.get(i);
         }
         return a;


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