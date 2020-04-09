public class _463IslandPerimeter{
    public static void main(String[] args) {

        int [][] grid = {{0,1,0,0},
        {1,1,1,0},
        {0,1,0,0},
        {1,1,0,0}};

        System.out.println(islandPerimeter(grid));
        
    }



    public static int islandPerimeter(int[][] grid) {
        int ans =0;
        
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length ;j++ ){
                int val =grid[i][j];
                if(val==1){
                    int[][] dir ={{1,0},{0,1},{-1,0},{0,-1}};
                    for(int k =0;k<dir.length;k++){
                        int x = i + dir[k][0];
                        int y = j+ dir[k][1];
                        if(  outside(grid,x,y) || grid[x][y]==0 ) ans++;
                    }   
                }
            }
        }
        
        
        return ans;
        
    }
    
    
    public static boolean outside(int[][] grid ,int row,int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length) return true;
        return false;
    }
}