import java.util.Arrays;


public class _486PredicttheWinner {

    public static void main(String[] args) {

        int [] nums = {1,5,233,7};
        Pair[][] dp =new Pair[nums.length][nums.length];
        Pair ans = sol(0,nums.length-1,0,nums,dp);
        System.out.println(ans);

      
        
    }


    public static class Pair{
        int f;
        int s;
        public Pair(int f,int s){
           this.f=f;
           this.s=s;
        }

        @Override
        public String toString() {
            return "F=>"+this.f+",S=>"+this.s;
        }
    }

    public static  Pair sol(int start ,int end,int chance,int [] nums,Pair[][]dp){
        chance%=2;
        if(start==end){
            if(chance==0){
                return new Pair(nums[start], 0);
            }else{
                return new Pair(0, nums[start]);
            }
        }

        if(dp[start][end]!=null){
            System.out.println("returned from dp");
            return dp [start][end];
        }  
       
        Pair recA= sol(start+1,end,chance+1,nums,dp);
        Pair recB =sol(start,end-1,chance+1,nums,dp);



        Pair ans = null;
        
     
        if(chance==0){
          
            Pair max = recA.f + nums[start] > recB.f+nums[end]?recA:recB;
            int score = Math.max( recA.f+nums[start],recB.f+nums[end]  );
            ans= new Pair(score, max.s);
            
        }else{
            Pair max = recA.s + nums[start] > recB.s+nums[end]?recA:recB;
            int score = Math.max( recA.s+nums[start],recB.s+nums[end]  );
            ans= new Pair(max.f, score); 
        }


        dp[start][end]= ans;
        return ans;
        
    }
}