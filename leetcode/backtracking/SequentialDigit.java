import java.util.ArrayList;
import java.util.Collections;

public class SequentialDigit{
    
    public static void main(String[] args) {
        ArrayList<Integer> bigans=new ArrayList<>();
        solution(0, 0,bigans,10,1000000000);
      //  Collections.sort(bigans);
        System.out.println(bigans);
        
    }
    public static  void solution(int ans,int num,ArrayList<Integer> bigans,int lower,int high){
        if(ans>=lower && ans <=high){
            bigans.add(ans);
        }

        if(ans>=high){
            return ;
        }
        if(num==0){
            for (int i = 1; i <= 9; i++) {
                solution(i, i,bigans,lower,high);
            }
        }else{
            if(num<9){
            solution((ans*10)+num+1, num+1,bigans,lower,high);
         }
        }
    }
}