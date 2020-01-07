public class SolutionJava {
    public static void main(String[] args) {
        // int [] arr={10,8,9,10,11,13,10,16,18,10,13};
        // int[] ans=allIndices(arr,10,0,0);
        // for(int i=0;i<ans.length;i++){
        //     System.out.print(ans[i]+" ");
        // }
        System.out.println(stairCAse(6));
    }

    public static int stairCAse(int n){
        if(n==1){
            return 1;
        }
        else if(n==2){
            return 2;
        }
        else if(n==3){
            return 4;
        }
        int count =0;
        for(int i=1;i<=3;i++){
            count=count+stairCAse(n-i);
        }
        return count;
    }


    public static int[] allIndices(int[] arr,int val,int start,int count){
        if(start==arr.length){
            int [] ref=new int[count];
            return ref;
        }

        int[] indices=null;
        if(arr[start]==val){
            indices=allIndices(arr, val, start+1, count+1);
        }
        else{
            indices=allIndices(arr, val, start+1, count);
        }
        if(arr[start]==val){
            indices[count]=start;
        }
        return indices;
        
    }
}