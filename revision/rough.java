import java.io.*;
import java.util.*;

public class rough {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int [][] arr = new int [n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                arr[i][j]=s.nextInt();
            }
        }
        boolean[][] isdone = new boolean [n][m];
        floodfill(arr,0,0,"",isdone);
    }
    
    public static boolean isSafe(int  [][] arr,boolean [] [] isdone,int row,int col){
        if(row>=0&&row<arr.length&&col>=0&&col<arr[0].length && !isdone[row][col]&&arr[row][col]!=1) return true;
        return false;
    }

    public static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited){
        if(row==maze.length-1&&col==maze[0].length-1){
            System.out.println(psf);
            return ;
        }
        
        visited [row][col]=true;
        int[][] dir = { {-1,0}, {1,0},{0,1},{0,-1} };
        char [] dn ={  't','d','r','l' } ;
        for(int i =0;i<dir.length;i++){
            int x = row + dir [i][0];
            int y = col +dir[i][1];
            if(isSafe(maze,visited,x,y)){
                floodfill(maze,x,y,psf+dn[i],visited);
            }
        }
        
        visited[row][col]=false;
    }
}



// ddddrrttttrrrrrddlllddrrrddd
// ddddrrdddrrrrr
// ddddrrrrrrrddd