public class _213HouseRobberII{
    public static void main(String[] args) {
        int []arr ={2,7,9,3,1};
        System.out.println(houseRob(0, 1, arr));
    }

    public static int houseRob(int idx,int canRobLast,int []arr){
        if(idx==arr.length-1 && canRobLast==0) return 0;

        if(idx>=arr.length) return 0;

        int ans = Integer.MIN_VALUE;

        //select
        int canRob = idx == 0 ? 0 : canRobLast;
        ans=Math.max(ans, arr[idx]+houseRob(idx+2, canRob, arr));

        //not select
        canRob = idx == 0 ? 1 : canRobLast; 
        ans =Math.max(ans, houseRob(idx+1, canRob, arr));

        return ans;
    }
}