import java.util.LinkedList;

public class _1162AsFarfromLandasPossible{


public static class Point{
    int x =0;
    int y=0;
    public Point(int x,int y){
       this.x=x;
       this.y=y;
    }
}

    public static void main(String[] args) {
        LinkedList<Point> queue =new LinkedList<>();
        int [][] grid ={{1,0,1},{0,0,0},{1,0,1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[i][j]==1){
                    queue.addLast(new Point(i, j));
                }
            }
        }

        System.out.println(dfs(queue, grid));

    }


    public static int  dfs( LinkedList<Point> queue ,int [][] grid  ){
        int max =0;
        while(!queue.isEmpty()){
            Point curr=queue.removeFirst();
            int [][] dir ={{0,1},{1,0},{-1,0},{0,-1}};
            for (int i = 0; i < dir.length; i++) {
                int newX =curr.x+dir[i][0];
                int newY=curr.y+dir[i][1];
                if(newX>=0 && newX <grid.length && newY>=0 && newY <grid[0].length && grid[newX][newY]==0){
                   grid[newX][newY]=grid[curr.x][curr.y]+1;
                   max=Math.max(max, grid[newX][newY]);
                   queue.addLast(new Point(newX, newY));
                }
            }

        }
        return max-1;

    }
}