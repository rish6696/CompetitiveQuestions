import java.util.ArrayList;
import java.util.Scanner;
public class Kconcat{
    public static void main(String[] args) {

       printss("ab", "");
       
        // Scanner s=new Scanner(System.in);
        // int test=s.nextInt();
        // ArrayList<Integer[]> arrays=new ArrayList<>();
        // ArrayList<Integer> kvalues=new ArrayList<>();
        // for(int i=0;i<test;i++){
        //     int n=s.nextInt();
        //     Integer[] arr=new Integer[n];
        //     int k=s.nextInt();
        //     kvalues.add(k);
        //     for(int j=0;j<n;j++){
        //          arr[j]=s.nextInt();
        //     }
        //     arrays.add(arr);
           
        // }
        // print(arrays, kvalues);

    }
    public static void printss(String str,String result){
        if(str.length()==0){
            System.out.println(result);
            return ;
        }
        
        printss(str.substring(1),result);
        printss(str.substring(1),result+str.charAt(0));
        printss(str.substring(1),result+(int)str.charAt(0));
        
    }
    public static boolean getAns(int[][]arr,int start){
        if(start==arr.length-1){
            int x=arr[start][0];
            int y=arr[start][1];
            return x==0||y==0;
       }
       boolean recAns=getAns(arr,start+1);
       if(!recAns)return false;
       int cx=arr[start][0];
       int cy=arr[start][1];
       int nx=arr[start+1][0];
       int ny=arr[start+1][1];
       if(nx==0&&cx==0) return true;
       if(ny==0&&cy==0) return true;
       return false;
        
    }

    public static int maxSum(Integer[]arr,int vsize){
        int div=arr.length;
        int maxtilnow=arr[0];
        int max=arr[0];
        for(int i=1;i<vsize;i++){
            int j=i%div;
            maxtilnow=Math.max(arr[j], maxtilnow+arr[j]);
            max=Math.max(max, maxtilnow);
        }
        return max;
    }

    public static void print(ArrayList<Integer[]>arrays,ArrayList<Integer> kvalues){

        for(int i=0;i<arrays.size();i++){
            Integer[] arr=arrays.get(i);
            int kval=kvalues.get(i);
            int newSize=kval*arr.length;
            int maxSubarray=maxSum(arr, newSize);
            System.out.println(maxSubarray+" ");

        }
             
    }
}