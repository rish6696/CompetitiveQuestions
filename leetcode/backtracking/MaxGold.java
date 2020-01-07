public class MaxGold{
    public static void main(String[] args) {
        int [][]grid={{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};

        int ans=Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    boolean[][] isDone=new boolean[grid.length][grid[0].length];
                    ans=Math.max(ans, maxGold(grid, i, j, isDone));
                }
            }
        }
        System.out.println(ans);

    }

    public static boolean canMove(int[][]grid,int row,int col,boolean[][]isDone){
        return row>=0 && col>=0 &&
        row<grid.length && col <grid[0].length &&
        !isDone[row][col] && grid[row][col]!=0 ;
    }

    public static int  maxGold(int[][] grid,int row,int col,boolean[][]isDone){

        isDone[row][col]=true;
        int[][]dir={{0,1},{1,0},{-1,0},{0,-1}};
        int ans=Integer.MIN_VALUE;
        for (int i = 0; i < dir.length; i++) {
            int x=row+dir[i][0];
            int y=col+dir[i][1];
            if(canMove(grid, x, y, isDone)){
                int recAns=maxGold(grid, x, y, isDone);
                ans=Math.max(ans, recAns);
            }
        }
        isDone[row][col]=false;
        return ans==Integer.MIN_VALUE ? grid[row][col]: ans+grid[row][col];
    }
}