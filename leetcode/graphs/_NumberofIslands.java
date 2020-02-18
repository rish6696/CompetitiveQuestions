public class _NumberofIslands{
    public static void main(String[] args) {

        char [][] grid ={{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        boolean[]visited =new boolean [grid.length*grid[0].length];
        int ans =0;
        for (int i = 0; i < visited.length; i++) {
            int r= i /grid[0].length;
            int c= i% grid[0].length;
            if(grid[r][c]=='1' && !visited[i]){
                ans++;
                dfs(grid, visited, i);
            }

        }
        System.out.println(ans);

        
    }

    public static void dfs(char [][] grid,boolean []visited ,int idx ){
        visited[idx]=true;
        int x =idx / grid[0].length;
        int y=idx% grid[0].length;
        int [][] dir ={{0,1},{1,0},{0,-1},{-1,0}};
        for (int i = 0; i < dir.length; i++) {
            int row =x+dir[i][0];
            int col =y+dir[i][1];
            if(row>=0&& row<grid.length && col >=0 && col<grid[0].length && grid[row][col]=='1'  && !visited[row*grid[0].length+col] ){
                dfs(grid, visited, row*grid[0].length+col);
            }
        }
    }
}