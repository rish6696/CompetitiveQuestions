public class uniquePaths{
    public static void main(String[] args) {
        int m=2;
        int n=2;
        System.out.println(getAns(m-1, n-1, 0, 0));
    }

    public static  boolean isValid(int row,int col ,int r,int c){
        return r >=0 && r <= row && c >=0&& c <= col;
    }
    
    public static int getAns(int row,int col,int r,int c){
        if(row== r && col ==c)return 1;
        int ans=0;
        
        int [][]dir={{0,1},{1,0}};
        for(int i=0;i<dir.length;i++){
            int x=r+dir[i][0];
            int y=c+dir[i][1];
            if(isValid(row,col,x,y)) ans+=getAns(row,col,x,y);
            
        }
        
        return ans;
    }
    
}