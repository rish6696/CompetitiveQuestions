public class _1306JumpGameIII{
    public static void main(String[] args) {
        int []arr={3,0,2,1,2};
        int start=2;
        boolean [] strg =new boolean[arr.length];
        boolean []inStack =new boolean [arr.length];
        boolean ans =jumpGameIII(start, strg, arr,inStack);
        System.out.println(ans);
        
    }

    public static boolean jumpGameIII(int idx, boolean[]strg,int []arr,boolean[]inStack){ 
       if(strg[idx]|| inStack[idx])return false;
       if(arr[idx]==0)return true;
       inStack[idx]=true;
       int val =arr[idx];
       if(val+idx>=0&& val+idx < arr.length){
           boolean recAns = jumpGameIII(val+idx, strg, arr,inStack);
           if(recAns)return true;
       }
       if(idx-val>=0&& idx-val < arr.length){
           boolean recAns= jumpGameIII(idx-val, strg, arr,inStack);
           if(recAns)return true;
       }
       strg[idx]=true;
       inStack[idx]=false;
       return false;
    }
}