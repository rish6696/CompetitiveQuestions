import java.util.Arrays;
public class MatrixReshape{
    public static void main(String[] args) {
        
        int [][] nums ={{1,2},{3,4}};
        int [][] ans =matrixReshape(nums, 1, 4);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int count =0;
        for(int i=0;i<nums.length;i++){
            count+=nums[i].length;
        }
        if(count==r*c){
            int [][] newArray=new int [r][c];
            count =0;
            while(count<=r*c-1){
                int x=nums[0].length;
                int or=(count/ x);
                int oc=(count % x);
                int nr=(count / c);
                int nc=(count % c);
                newArray[nr][nc]=nums[or][oc];
                count++;
            }
            return newArray;
            
        }else{
            return nums; 
        }
        
    }
}