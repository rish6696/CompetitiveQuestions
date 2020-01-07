import java.util.ArrayList;

public class EqualSum{
    public static void main(String[] args) {
        int[]arr={1,3 ,5 ,7 ,0};
        ArrayList<String> bigAns=new ArrayList<>();
       // printEqualSum(arr, 0, new ArrayList<>(), new ArrayList<>(),new boolean[arr.length]);
        returnEqualSum(arr, 0, new ArrayList<>(), new ArrayList<>(),new boolean[arr.length],bigAns);
        System.out.println(bigAns.size());
        System.out.println(bigAns);
        printEqualSum(arr, 0, new ArrayList<>(), new ArrayList<>(), new boolean[arr.length]);

    }


    public static int getSum(ArrayList<Integer>list){
        int sum=0;
        for (Integer integer : list) {
            sum+=integer;
        }
        return sum;
    }

    public static  boolean isAllVisited(boolean[]arr){
        for (int i = 0; i < arr.length; i++) {
            if(!arr[i])return false;
        }
        return true;
    }


    public static  void printEqualSum(int[]arr,int start,ArrayList<Integer>fArrayList,ArrayList<Integer>sArrayList,boolean[]isvisited){
        if(start==arr.length&& isAllVisited(isvisited) && getSum(fArrayList)==getSum(sArrayList)){
            for (Integer integer : fArrayList) {
                System.out.print(integer+" ");
            }
            System.out.print("\t");
            for (Integer integer : sArrayList) {
                System.out.print(integer+" ");
            }

            System.out.println();
            return ;

        }  
        
        for(int i=start;i<arr.length;i++){
            isvisited[i]=true;
            fArrayList.add(arr[i]);
            printEqualSum(arr, i+1, fArrayList, sArrayList,isvisited);
            fArrayList.remove(fArrayList.size()-1);
            sArrayList.add(arr[i]);
            printEqualSum(arr, i+1, fArrayList, sArrayList,isvisited);
            sArrayList.remove(sArrayList.size()-1);
            isvisited[i]=false;
        }

    }

    public static void returnEqualSum(int[]arr,int start,ArrayList<Integer>fArrayList,ArrayList<Integer>sArrayList,boolean[]isvisited,ArrayList<String>bigAns){
        if(start==arr.length&& isAllVisited(isvisited) && getSum(fArrayList)==getSum(sArrayList)){
            String left="";
            String right="";
            for (Integer integer : fArrayList) {
                left=left+integer+" ";
            }
            for (Integer integer : sArrayList) {
                right=right+integer+" ";
            }
            bigAns.add(left+" and "+right);
            return ;

        }  
        
        for(int i=start;i<arr.length;i++){
            isvisited[i]=true;
            fArrayList.add(arr[i]);
            returnEqualSum(arr, start+1, fArrayList, sArrayList,isvisited,bigAns);
            fArrayList.remove(fArrayList.size()-1);
            sArrayList.add(arr[i]);
            returnEqualSum(arr, start+1, fArrayList, sArrayList,isvisited,bigAns);
            sArrayList.remove(sArrayList.size()-1);
            isvisited[i]=false;
        }

        

    }



}