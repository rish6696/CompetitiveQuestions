import java.util.ArrayList;
import java.util.List;

public class GrayCode{
    public static void main(String[] args) {
        int n=1;
        List<Integer> bigAns=new ArrayList<>();
        int [] bits=new int [n];
        int s=(int)Math.pow(2, n);
        boolean [] isDone=new boolean[s];
        generateGrayCode(bits, isDone, -1, bigAns);
        System.out.println(bigAns);
    }

    public static int getNumfromBitsArray(int[] bits){
        int ans =0;
        for(int i=0;i<bits.length;i++){
            int temp=bits.length-1-i;
            if(bits[i]!=0){
                int mask = 1<<temp;
                ans|=mask;
            }
        }
        return ans;

    }

    public static void generateGrayCode(int[] bits,boolean []isDone,int lastDone,List<Integer> bigAns){
        int value =getNumfromBitsArray(bits);
        if(isDone[value]){
            return ;
        }
        isDone[value]=true;
        bigAns.add(value);
        for (int i = 0; i < bits.length; i++) {
            if(i!=lastDone){
                int valPrev=bits[i];
                int toInsert=valPrev==0?1:0;
                bits[i]=toInsert;
                generateGrayCode(bits, isDone, lastDone, bigAns);
                bits[i]=valPrev;

            }            
        }
       
    }
}