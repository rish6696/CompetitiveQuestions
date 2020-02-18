import java.util.LinkedList;

public class _994RottingOranges{
    public static void main(String[] args) {

        int[][] grid={{2,1,1},{1,1,0},{0,1,1}};
        int colLength =grid[0].length;
        LinkedList<Integer> queue =new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==2)queue.add( i*colLength+j);
            }
        }
        int level =0;
        int [][] dir ={{1,0},{0,1},{0,-1},{-1,0}};
        boolean []visited =new boolean [grid.length*colLength];
        while(!queue.isEmpty()){
            int size =queue.size();
            while(size > 0 ){
                size--;
                int idx = queue.removeFirst();
                visited[idx]=true;
                int r= idx /colLength;
                int c= idx% colLength;
                for (int i = 0; i < dir.length; i++) {
                    int nx =r+dir[i][0];
                    int ny =c+dir[i][1];
                    if(nx>=0 && nx<grid.length && ny>=0 && ny <grid[0].length && grid[nx][ny]==1){
                        grid[nx][ny]=2;
                        queue.addLast(nx*colLength+ny);
                    }     
                }
            }
            level++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    System.out.println(-1);
                    return ;
                }
            }
        }

        
        System.out.println(level);
    }



}