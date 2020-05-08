
public class MazeQues {
  public static void main(String[] args) {
    int n =4;
    boolean[][] isDone= new boolean[n][n];
    System.out.println(maze(n-1, 0, 0, n-1, isDone,"",0));   
  }


  public static  boolean isValid(int row ,int col,boolean[][]isDone){
    if(row< 0 ||row >= isDone.length || col < 0 || col >= isDone[0].length || isDone[row][col]) return false;
    return true;
  }

  public static int maze(int cr,int cc,int er,int ec,boolean[][]isDone,String path,int visited) {

    if(cr==er&&cc==ec&&visited==isDone.length*isDone.length-1){
        System.out.println(path);
        return 1;
    }
    int ans =0;
    isDone[cr][cc]=true;
    // visited++;
    int [][] dir ={{1,0},{0,1},{0,-1},{-1,0}};
    String  [] dirName= {"D","R","B","U"};
    for (int i = 0; i < dir.length; i++) {

        int x = dir[i][0]+cr;
        int y = dir[i][1]+cc;

        if(isValid(x, y, isDone)){
            ans+=maze(x, y, er, ec, isDone,path+dirName[i],visited+1);
        }
    }
    isDone[cr][cc]=false;
    return ans;
  }
}