import java.util.*;
public class SquareFullArray{
    public static void main(String[] args) {
        int[]A={2,2,2};
        ArrayList<Integer>ans =new ArrayList<>();
        boolean [] isDone =new boolean [A.length];
        Arrays.sort(A);
        System.out.println(returnSolution(isDone, A, ans));
        
        
    }
        
    public static int returnSolution(boolean[]isDone,int[]data,ArrayList<Integer>ans){
        if(ans.size()==data.length){
            return 1 ;
        }
        int c=0;
        for(int i=0;i<data.length;i++){
            if(ans.size()==0){
                isDone[i]=true;
                ans.add(data[i]);
                c+=returnSolution(isDone,data,ans);
                ans.remove(ans.size()-1);
                isDone[i]=false;
            }else{
                if(!isDone[i]&&isPerfectSquare(ans.get(ans.size()-1)+data[i])){         
                    if(i==0||data[i-1]!=data[i]||!isDone[i-1]){
    
                    isDone[i]=true;
                    ans.add(data[i]);
                    c+=returnSolution(isDone,data,ans);
                    isDone[i]=false;
                    ans.remove(ans.size()-1);
                    }
                    
                    
                }
            }
        }
        return c;
    }
    
    
    
    public static boolean isPerfectSquare(int a){
        int l=0;
        int r=a/2;
        while(l<=r){
            int mid=(l+r)/2;
            if(mid*mid==a){
                return true;
            }else if(mid*mid<a){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return false;
    }
}