import java.util.ArrayList;
import java.util.List;

public class _1043PartitionArrayforMaximumSum{
    public static void main(String[] args) {
        int []arr={1,15,7,9,2,5,10};
        System.out.println(partition(0, arr,new ArrayList<>()));
    }


    public static int getSum(List<Integer> pList,int []arr){
        int sum =0;
        int start =0;
        for (int i = 0; i < pList.size(); i++) {
            int end = pList.get(i);
            int max =getMax(arr, start, end);
            sum += (end -start+1)*max;
            start=end+1;
        }
        return sum;
    }
    public static int getMax(int []arr,int start,int end){
        int max =Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max=Math.max(max, arr[i]);
        }
        return max;
    }

    public static int  partition(int idx,int []arr,List<Integer> pList){
        if(idx==arr.length){
            System.out.println(pList);
            return getSum(pList, arr);
        }
        int ans =Integer.MIN_VALUE;
        String local ="";
        for (int i = 0; i < 3; i++) {
            if(idx+i<arr.length){    
            local+=arr[idx+i]+" ";
            pList.add(idx+i);
            ans=Math.max(ans, partition(idx+i+1, arr, pList));
            pList.remove(pList.size()-1);

            }

        }
        return ans;
    }
}