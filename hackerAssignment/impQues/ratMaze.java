import java.util.Scanner;

public class ratMaze{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int m=s.nextInt();
        int n=s.nextInt();
        int [][] maze=new int[m][n];
        boolean [][] isVisited=new boolean[m][n];
        for(int i=0;i<maze.length;i++){
           for(int j=0;j<n;j++){
                maze[i][j]=s.nextInt();
           }
        }
        System.out.println(ratMaze(0, 0, m-1, n-1, isVisited, maze));
        
    }

    public static boolean isValidRatmaze(int x,int y,int er,int ec,boolean[][] isVisited,int[][]maze){
        if(x>=0&&x<=er&&y>=0&&y<=ec&&!isVisited[x][y]&&maze[x][y]==1) return true;
        return false;
    }

    public static boolean ratMaze(int cr,int cc,int er,int ec,boolean[][] isVisited,int[][]maze){
        if(cr==er&&cc==ec){
            return true;
        }
        isVisited[cr][cc]=true;
        int [][] dir={{-1,0},{0,1},{1,0},{0,-1}};
        for(int d=0;d<dir.length;d++){
            int x=cr+dir[d][0];
            int y=cc+dir[d][1];
            if(isValidRatmaze(x, y, er, ec, isVisited, maze)){
                boolean recAns=ratMaze(x, y, er, ec, isVisited, maze);
                if(recAns)return true;
            }
        }
        isVisited[cr][cc]=false;
        return false;

    }
}