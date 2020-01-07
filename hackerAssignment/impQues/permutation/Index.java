import java.util.ArrayList;
import java.util.Scanner;
public class Index{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int size=s.nextInt();
        int[]arr=new int[size];
        for (int i = 0; i < size; i++) {
            arr[i]=s.nextInt();
        }
        int target=s.nextInt();
       
       ArrayList<String> ans=new ArrayList<>();
       get(arr,target,"",ans,0);
       System.out.println(ans);
    }

    public static void get(int[]arr,int target,String ans ,ArrayList<String> bigAns,int idx ){
        if(target==0){
            bigAns.add(ans);
        }
        if(idx==arr.length){
            return ;
        }
        for(int i=idx;i<arr.length;i++){
            if(target-arr[i]>=0){
                String m=ans+arr[i]+" ";
                get(arr,target-arr[i],m,bigAns,i+1);
            }
        }    
    }
}