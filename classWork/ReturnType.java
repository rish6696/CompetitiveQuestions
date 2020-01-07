import java.util.ArrayList;

public class ReturnType{
    public static void main(String[] args) {
        // String str="";
        // String m="";
        // String z="";
        // String[] stringArray=new String[3];
        // stringArray[0]=str;
        // stringArray[1]=m;
        // stringArray[2]=z;
        // System.out.println(getLongestString(stringArray));

       // System.out.println(getSS(str));
    //    System.out.println(heightTree(0, 0, 4 , 6));
    //    System.out.println(longestPath(0, 0, 4, 6));
  //  System.out.println(floodFill(0, 0, 2, 2,new boolean[3][3]));
        // System.out.println(floodFillMultiMove(0, 0, 1, 1, new boolean[2][2]));
        //System.out.println(KnightMove(0, 0, 3, 3, new boolean[4][4]));
         int [][]arr=new int[5][5];
         System.out.println(KnightMovePath(0, 0, 4 ,4,new boolean[5][5], arr, 1));
        // for (int i = 0; i < arr.length; i++) {

        //     for (int j = 0; j < arr[0].length; j++) {
        //         System.out.print(arr[i][j]+"    ");
        //     }
        //     System.out.println();
            
        // }

       // System.out.println(nokiaKeyPad("123"));
        // int[][] board = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
        // {0, 0, 0, 0, 0, 0, 0, 0, 0},
        // {0, 8, 7, 0, 0, 0, 0, 3, 1},
        // {0, 0, 3, 0, 1, 0, 0, 8, 0},
        // {9, 0, 0, 8, 6, 3, 0, 0, 5},
        // {0, 5, 0, 0, 9, 0, 6, 0, 0},
        // {1, 3, 0, 0, 0, 0, 2, 5, 0},
        // {0, 0, 0, 0, 0, 0, 0, 7, 4},
        // {0, 0, 5, 2, 0, 6, 3, 0, 0}};

          
        // System.out.println(sudoku(board,0));
       
          
    }
    public static String getLongestString(ArrayList<String> array) {
        int maxLength = -1;
        String longestString = null;
        for (String s : array) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                longestString = s;
            }
        }
        return longestString;
    }

    public static String getSmallString(ArrayList<String> array) {
        int minLength = Integer.MAX_VALUE;
        String longestString = null;
        for (String s : array) {
            if (s.length() < minLength) {
                minLength = s.length();
                longestString = s;
            }
        }
        return longestString;
    }

    public static String longestPath(int cr,int cc,int er,int ec){
        if(cr==er&&cc==ec){
            return "";
        }

        ArrayList<String> stringArray=new ArrayList<>();
        String hs=null,vs=null,ds=null;
        if(cc<=ec-1){
            hs=longestPath(cr, cc+1, er, ec);
        }
        if(cr<=er-1){
            vs=longestPath(cr+1, cc, er, ec);
        }
      
        if(cr<=er-1&&cc<=ec-1){
            ds=longestPath(cr+1, cc+1, er, ec);
        }
        if(hs!=null) stringArray.add(hs);
        if(vs!=null)stringArray.add(vs);
        if(ds!=null)stringArray.add(ds);
       
        
        
        String longest=getSmallString(stringArray);
        String ans="";
        if(hs!=null&&longest.equals(hs)){
            ans="H"+longest;
        }
        if(vs!=null&&longest.equals(vs)){

            ans="V"+longest;
        }
        if(ds!=null&&longest.equals(ds)){
            ans="D"+longest;
        }
        return ans;
        

    }


    public static int heightTree(int cr,int cc,int er,int ec){
        if(cr==er&&cc==ec){
            return 0;
        }
        int hh=0,vh=0,dh=0;
        if(cr<=er-1){
            vh=heightTree(cr+1, cc, er, ec);
        }
        if(cc<=ec-1){
            hh=heightTree(cr, cc+1, er, ec);
        }
        if(cr<=er-1&&cc<=ec-1){
            dh=heightTree(cr+1, cc+1, er, ec);
        }
        return Math.max(hh, Math.max(vh, dh))+1;
    }

    public static ArrayList<String>mazePath(int cr,int cc,int er,int ec){
        if(cr==er&&cc==ec){
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String>ans=new ArrayList<>();
        if(cc<=ec-1){
            ArrayList<String> horiResult=mazePath(cr, cc+1, er, ec);
            for(int i=0;i<horiResult.size();i++){
                ans.add("H"+horiResult.get(i));
            }
        }
        if(cr<=er-1){
            ArrayList<String> vertiResult=mazePath(cr+1, cc, er, ec);
            for(int i=0;i<vertiResult.size();i++){
                ans.add("V"+vertiResult.get(i));    
            }

        }
        if(cc<=ec-1&&cr<=er-1){
            ArrayList<String> diagonalResult=mazePath(cr+ 1, cc+1, er, ec); 
            for(int i=0;i<diagonalResult.size();i++){
                ans.add("D"+diagonalResult.get(i));
            }
        }
        return ans;
    }


    public static ArrayList<String> getSS(String str){
        if(str.length()==0){
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }
        char cc=str.charAt(0);
        String ros=str.substring(1);
        ArrayList<String>recAns=getSS(ros);
        ArrayList<String> ans=new ArrayList<>();
        for(int i=0;i<recAns.size();i++){
            ans.add(recAns.get(i));
            ans.add(cc+recAns.get(i));
        }
        return ans;
    }

    public static ArrayList<String>mazePathMultiMove(int cr,int cc,int er,int ec){
        if(cr==er&&cc==ec){
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String>ans=new ArrayList<>();

        for(int j=1;j<=ec;j++){
            if(cc<=ec-1){
                ArrayList<String> horiResult=mazePathMultiMove(cr, cc+1, er, ec);
                for(int i=0;i<horiResult.size();i++){
                    ans.add("H"+horiResult.get(i));
                }
            }

            if(cr<=er-1){
                ArrayList<String> vertiResult=mazePath(cr+1, cc, er, ec);
                for(int i=0;i<vertiResult.size();i++){
                    ans.add("V"+vertiResult.get(i));    
                }
    
            }
            if(cc<=ec-1&&cr<=er-1){
                ArrayList<String> diagonalResult=mazePath(cr+ 1, cc+1, er, ec); 
                for(int i=0;i<diagonalResult.size();i++){
                    ans.add("D"+diagonalResult.get(i));
                }
            }
        
        }
    return ans;

    }

    public static ArrayList<String>floodFill(int cr,int cc,int er,int ec,boolean[][]isDone){
        if(cr==er&&cc==ec){
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }
        isDone[cr][cc]=true;
        ArrayList<String>ans=new ArrayList<>();
        if(cc<=ec-1&&!isDone[cr][cc+1]){
            ArrayList<String> horiResult=floodFill(cr, cc+1, er, ec,isDone);
            for(int i=0;i<horiResult.size();i++){
                ans.add("H"+horiResult.get(i));
            }
        }
        if(cr<=er-1&&!isDone[cr+1][cc]){
            ArrayList<String> vertiResult=floodFill(cr+1, cc, er, ec,isDone);
            for(int i=0;i<vertiResult.size();i++){
                ans.add("V"+vertiResult.get(i));    
            }

        }
        if(cr>=1&&cr<=er&&!isDone[cr-1][cc]){
            ArrayList<String> upwardResult=floodFill(cr- 1, cc, er, ec,isDone); 
            for(int i=0;i<upwardResult.size();i++){
                ans.add("U"+upwardResult.get(i));
            }
        }
         if(cc>=1&&cc<=ec&&!isDone[cr][cc-1]){
            ArrayList<String> backResult=floodFill(cr, cc-1, er, ec,isDone); 
            for(int i=0;i<backResult.size();i++){
                ans.add("B"+backResult.get(i));
            }
        }
        isDone[cr][cc]=false;
        return ans;
    }
    public static boolean isValid(int x,int y,int er,int ec,boolean[][] isVisited){
        if(x>=0&&x<=er&&y>=0&&y<=ec&&!isVisited[x][y])return true;
        return false;
    }

    public static ArrayList<String> floodFillMultiMove(int cr,int cc,int er,int ec,boolean[][] isVisited){
       if(cr==er&&cc==ec){
           ArrayList<String> base=new ArrayList<>();
           base.add("");
           return base;
       }
       isVisited[cr][cc]=true;
       ArrayList<String> myAns=new ArrayList<>();

       int [][] dir={ {-1,0},{1,0},{0,1},{0,-1},{-1,1},{1,1},{1,-1},{-1,-1} };
       String[] dirName={"U","D","R","L","d1","d2","d3","d4"};
       for(int d=0;d<dir.length;d++){
           int x=cr+dir[d][0];
           int y=cc+dir[d][1];
           if(isValid(x, y, er, ec, isVisited)){
               ArrayList<String> recAns=floodFillMultiMove(x, y, er, ec, isVisited);
               for(String s:recAns){
                   myAns.add(s+dirName[d]);
               }
           }
       }
       isVisited[cr][cc]=false;
       return myAns;
    }
     public static int  KnightMove(int cr,int cc,int er,int ec,boolean[][] isVisited){
       if(cr==er&&cc==ec){
           return 1;
       }
       isVisited[cr][cc]=true;
       int count=0;

       int [][] dir={ {1,2},{2,1},{-1,2},{-2,1},{1,-2},{-1,-2},{2,-1},{-2,-1} };
       //String[] dirName={"U","D","R","L","d1","d2","d3","d4"};
       for(int d=0;d<dir.length;d++){
           int x=cr+dir[d][0];
           int y=cc+dir[d][1];
           if(isValid(x, y, er, ec, isVisited)){
               count+=KnightMove(x, y, er, ec, isVisited);
           }
       }
       isVisited[cr][cc]=false;
       return count;
    }



    public static int  KnightMovePath(int cr,int cc,int er,int ec, boolean[][] isVisited,int[][]arr,int count){
        if(count==25){
            arr[cr][cc]=count;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("*********************************************");
            return 1;
        }
        isVisited[cr][cc]=true;  
        int counter =0;     
        int [][] dir={ {1,2},{2,1},{-2,1},{1,-2},{-1,-2},{2,-1},{-2,-1},{-1,2}};
        for(int d=0;d<dir.length;d++){
           int x=cr+dir[d][0];
           int y=cc+dir[d][1];
           if(isValid(x, y, er, ec, isVisited)){
               arr[cr][cc]=count;
               counter+=KnightMovePath(x, y, er,ec,isVisited, arr, count+1);
               arr[cr][cc]=0;
                
           }
        }
        isVisited[cr][cc]=false;
        return counter;
      
    }


    public static ArrayList<String> nokiaKeyPad(String str){
        if(str.length()==0){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        String ros=str.substring(1);
        ArrayList<String> myAns=new ArrayList<>();
        ArrayList<String> recAns=nokiaKeyPad(ros);
        String curr=mapper(str.charAt(0));
        for (int i = 0; i < recAns.size(); i++) {
            for(int j=0;j<curr.length();j++){
                char sc=curr.charAt(j);
                myAns.add(recAns.get(i)+sc);
            }
        }
        return myAns;
    }

    public static String mapper(char str){
        switch (str) {
            case '1':
               return "abc";
             case '2':
               return "def";
             case '3':
               return "ghi";
             case '4':
               return "jkl";
             case '5':
               return "mno";
             case '6':
               return "pqrs";
                case '7':
               return "tuv";
                case '8':
               return "wxyz";
               default:
               return "";
        
            
        }
    }


    public static ArrayList<String> getPermutation(String str){
        if(str.length()==1){
            ArrayList<String>base=new ArrayList<>();
            base.add(str.charAt(0)+"");
            return base;
        }
        String ros=str.substring(1);
        char cc=str.charAt(0);
        ArrayList<String> myAns=new ArrayList<>();
        ArrayList<String> recAns=getPermutation(ros);
        for(String s:recAns){
            for(int i=0;i<=str.length()-1;i++){
                myAns.add(s.substring(0,i)+cc+s.substring(i));
            }
        }
        return myAns;

    }


    //   public static ArrayList<String> getPermutationNoRepeat(String str,boolean[]arr){
    //     if(str.length()==1){
    //         ArrayList<String>base=new ArrayList<>();
    //         arr[(int)str.charAt(0)]=true;
    //         base.add(str.charAt(0)+"");
    //         return base;
    //     }
    //     String ros=str.substring(1);
    //     char cc=str.charAt(0);
    //     ArrayList<String> myAns=new ArrayList<>();
    //     ArrayList<String> recAns=getPermutationNoRepeat(ros,arr);
    //     for(String s:recAns){
    //         for(int i=0;i<=s.length();i++){
    //             if(!arr[(int)str.charAt(i)]){
    //                 myAns.add(s.substring(0,i)+cc+s.substring(i));  
    //             }
                
    //         }
    //     }
    //     return myAns;

    // }
    //   public static ArrayList<String> getPermutationNoRepeat(String str,boolean[]arr){
    //     if(str.length()==1){
    //         ArrayList<String>base=new ArrayList<>();
    //         arr[(int)str.charAt(0)]=true;
    //         base.add(str.charAt(0)+"");
    //         return base;
    //     }
    //     String ros=str.substring(1);
    //     char cc=str.charAt(0);
    //     ArrayList<String> myAns=new ArrayList<>();
    //     ArrayList<String> recAns=getPermutationNoRepeat(ros,arr);
    //     for(String s:recAns){
    //         for(int i=0;i<=s.length();i++){
    //             if(!arr[(int)str.charAt(i)]){
    //                 myAns.add(s.substring(0,i)+cc+s.substring(i));  
    //             }
                
    //         }
    //     }
    //     return myAns;

    // }

    public static boolean isValidSudoku(int[][] board,int row,int col,int num){
        //row
        for(int i=0;i<board[row].length;i++){
             if(board[row][i]==num){
                 return false;
             }
        }
        //col
        for(int i=0;i<board.length;i++){
            if(board[i][col]==num){
                return false;
            }
        }
        //matrix
        int vr=(row/3)*3;
        int vc=(col/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[vr+i][vc+j]==num)return false;
            }
        }


        return true;
    }

   
   public static int  sudoku(int[][] board,int vidx){
        if(vidx==board.length*board[0].length){
          for(int[] ar:board){
              for(int ele:ar){
                System.out.print(ele+" ");
              }
              System.out.println();            
          }
          System.out.println();
             return 1;
         }
 
          int r=vidx/9;
          int c=vidx%9;
          int count=0;
        //  boolean res=false;

          if(board[r][c]!=0){
             count+=sudoku(board,vidx+1);
          }else{
             for(int num=1;num<=9;num++){
                   if(isValidSudoku(board,r,c,num)){
                        board[r][c]=num;
                        count+=sudoku(board, vidx+1);
                        board[r][c]=0;
                    
                   }
               }
    }
    return count;
 }
}
