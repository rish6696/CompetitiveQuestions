import java.io.*;
import java.util.*;

public class rough {

    public static void main(String[] args) throws Exception {
        String [] A ={"FCEFEEBFBD", "CAFGADGCBE", "CEEBGFCEGG", "FEABFFEGGG", "BFFAECDCCF"};
        String B = "ECAEAFAFDF";

        System.out.println(exist(A, B));
    }
    
    public static int exist(String[] A, String B) {
        for(int i=0; i< A.length;i++){
            String curr = A[i];
            for(int j =0;j<curr.length();j++){
                if(curr.charAt(j)== B.charAt(0)){
                   boolean ans = dfs(0,B,i,j,-1,-1,A);
                   if (ans) return 1;
                }
            }
        }
        return 0;
    }

    public static  boolean dfs(int index , String word,int cr,int cc, int br,int bc,String [] grid){


        if(index == word.length()-1  ) return true;
 
           int [][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

           for (int d=0;d<dir.length;d++){
              int nr = cr + dir[d][0];
              int nc = cc + dir[d][1];

              if( nr >=0 && nr < grid.length && nc >=0 && nc < grid[cr].length()  && word.charAt(index+1) == grid[nr].charAt(nc)){
                boolean recAns =  dfs(index+1,word,nr,nc,cr,cc,grid);
                if (recAns) return true;
              }
           }


           return false;
    }
}



// ddddrrttttrrrrrddlllddrrrddd
// ddddrrdddrrrrr
// ddddrrrrrrrddd