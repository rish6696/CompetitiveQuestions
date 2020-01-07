import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class targetSum{
    public static void main(String[] args) {
         Scanner s=new Scanner(System.in);
         int size=s.nextInt();
         int[]arr=new int[size];
         for (int i = 0; i < size; i++) {
             arr[i]=s.nextInt();
         }
         int target=s.nextInt();
        
        System.out.println(targetSumReturn(arr, 0, target).size());
        System.out.println(targetSumReturn(arr, 0, target));
        tagetSum(arr, 0, new ArrayList<>(), target);
         //System.out.println(getTargetViaSubsequence(arr, 0,target));
         
        // System.out.println(getArray(" 10 23 "));
        
       //tagetSum(arr, 0, new ArrayList<>(),6);

      
    }

    public static ArrayList<String> getTargetViaSubsequence(int[]arr,int idx,int target){
        if(idx==arr.length){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        int cc=arr[idx];
        int newtarget=target-cc;
        newtarget=newtarget<0?target:newtarget;
        ArrayList<String> recAns=getTargetViaSubsequence(arr, idx+1,newtarget);
        ArrayList<String> ans=new ArrayList<>();
        ArrayList<String> finalAns=new ArrayList<>();
        for(String s:recAns){
            ans.add(s);
            ans.add(cc+" "+s);
        }
        for(String s:ans){
            if(s.length()>0){
                int sum =0;
                sum=getArraySum(s);
                if(sum==target){
                  finalAns.add(s);
               }
            }
        }
        if(idx!=0){
        return finalAns.size()>0?finalAns:ans;}
        else{
            return finalAns;
        }
    }

    public static int getArraySum(String str){
           ArrayList<Integer> ans=new ArrayList<>();
           int i=1;
           int num=0;
           if(str.charAt(0)!=' '){
              num=Integer.parseInt(str.charAt(0)+"");
           }
           while(i<str.length()){
               if(str.charAt(i)==' '){
                   ans.add(num);
                   num=0;
               }else{
                   num=(num*10)+Integer.parseInt(str.charAt(i)+"");
               }
               i++;
           }
           if(num!=0){
               ans.add(num);
           }
           num=0;
           for (Integer integer : ans) {
               num+=integer;
           }
           return num;
    }



    public static void tagetSum(int[]arr,int start,ArrayList<Integer>ans,int  target){
        if(target==0){
            for (Integer integer : ans) {
                System.out.print(integer+" ");
            }
            System.out.println();

        }
        if(start==arr.length){
            return;
        }
        for(int i=start;i<arr.length;i++){
            if(arr[i]<=target){
                  ans.add(arr[i]);
                  target=target-arr[i];
                  tagetSum(arr, i+1, ans, target);
                  target=target+arr[i];
                  ans.remove(ans.size()-1);
            }
         
        }
        return ;
        
        
    }

      public static ArrayList<String> targetSumReturn(int[]arr,int start,int target){
        if(start==arr.length){
            ArrayList<String> base= new ArrayList<>();
            return base;
        }
        ArrayList myAns=new ArrayList<>();
       
         
        
        for(int i=start;i<arr.length;i++){
            if(arr[i]<=target){
                if(target-arr[i]==0){
                    myAns.add(arr[i]+" ");
                 }
                  target=target-arr[i];
                  ArrayList<String> recAns= targetSumReturn(arr, i+1, target);
                  for(String s:recAns){
                      myAns.add(arr[i]+" "+s);
                  }
                  target=target+arr[i];
                 
                  
                    
            }
         
        }
        return myAns;
        
        
    }
}