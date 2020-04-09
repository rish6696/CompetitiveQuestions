import java.util.Stack;
import java.util.Arrays;
public class NextGreater{
    public static void main(String[] args) {
        int []arr ={2,1,5,6,2,3};
        int [] ans =nextSmallerRight(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
        //System.out.println(Arrays.toString(nextSmallerRight(arr)));
       
    }


    public static void nextGreaterRight(int []arr){
        int [] ans =new int [arr.length];
       Stack <Integer> stack=new Stack<>();
       ans[arr.length-1] =-1;
       stack.push(arr[arr.length-1]);
       for(int i=arr.length-2;i>=0 && !stack.empty() ;i--){
           if(arr[i]<stack.peek()){
            ans[i]=stack.peek();
           }
           else{
               while(!stack.empty() && stack.peek() <arr[i]){
                  stack.pop();
               }
               ans[i]= stack.isEmpty() ? -1: stack.peek();
           }
           stack.push(arr[i]);
       }
       System.out.println(Arrays.toString(ans));

    }




    public static void nextGreaterLeft(int []arr){
        int [] ans =new int [arr.length];
       Stack <Integer> stack=new Stack<>();
       ans[0] =-1;
       stack.push(arr[0]);
       for(int i=1;i<arr.length && !stack.empty() ;i++){
           if(arr[i]<stack.peek()){
            ans[i]=stack.peek();
           }
           else{
               while(!stack.empty() && stack.peek() <arr[i]){
                  stack.pop();
               }
               ans[i]= stack.isEmpty() ? -1: stack.peek();
           }
           stack.push(arr[i]);
       }
       System.out.println(Arrays.toString(ans));

    }



    //  public static void nextSmallerRight(int []arr){
    //     int [] ans =new int [arr.length];
    //    Stack <Integer> stack=new Stack<>();
    //    ans[arr.length-1] =-1;
    //    stack.push(arr[arr.length-1]);
    //    for(int i=arr.length-2;i>=0 && !stack.empty() ;i--){
    //        if(arr[i]>stack.peek()){
    //         ans[i]=stack.peek();
    //        }
    //        else{
    //            while(!stack.empty() && stack.peek() >arr[i]){
    //               stack.pop();
    //            }
    //            ans[i]= stack.isEmpty() ? -1: stack.peek();
    //        }
    //        stack.push(arr[i]);
    //    }
    //    System.out.println(Arrays.toString(ans));

    // }




    public static void nextSmallerLeft(int []arr){
        int [] ans =new int [arr.length];
       Stack <Integer> stack=new Stack<>();
       ans[0] =-1;
       stack.push(arr[0]);
       for(int i=1;i<arr.length && !stack.empty() ;i++){
           if(arr[i]>stack.peek()){
            ans[i]=stack.peek();
           }
           else{
               while(!stack.empty() && stack.peek() > arr[i]){
                  stack.pop();
               }
               ans[i]= stack.isEmpty() ? -1: stack.peek();
           }
           stack.push(arr[i]);
       }
       System.out.println(Arrays.toString(ans));

    }




    public static int[] asteroidCollision(int[] asteroids) {
        
        
        Stack<Integer> stack =new Stack<>();
        stack.push(asteroids[0]);
        int i =1;
        
        while(i<asteroids.length){
            int curr =asteroids[i];
            while(i<asteroids.length && curr<0 && stack.peek() >0 ){
                if(Math.abs(curr) >=stack.peek()){
                    stack.pop();
                    i++;
                }else{
                    i++;
                    curr= i<asteroids.length ?  asteroids[i]  :-1;
                }
               
            }
            i++;
            if(i<asteroids.length)   stack.push(curr); 
        }
        
        
        int [] ans = new int [stack.size()];
        int k=ans.length-1;
        
        while(!stack.isEmpty()){
            ans[k]=stack.pop();
            k--;
        }
        return ans;
        
    }



    public static int [] nextSmallerRight(int [] arr ){
        Stack<Integer> stack =new Stack<>();
        int [] ans =new int [arr.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=i+1;
        }
        stack.add(0);
        for(int i =1;i<arr.length;i++){
            int val =arr[i];
            while(!stack.isEmpty() && val < arr[stack.peek()] ){
                int idx =stack.pop();
                ans[idx] =val;
            }
            stack.push(i);
        }
        
        return ans;
    }
}