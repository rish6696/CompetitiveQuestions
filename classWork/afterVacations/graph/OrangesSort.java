import java.util.LinkedList;

public class OrangesSort {


    public static void main(String[] args) {
        int [][] arr={ {2, 1, 0, 2, 1},
        {1, 0, 1, 2, 1},
        {1, 0, 0, 2, 1}};

        LinkedList<Integer> queue =new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j]==2){
                    queue.addLast(i*arr[0].length+j);
                }
            }
        }

        int level =0;
        while(!queue.isEmpty()){
            int rvt =queue.removeFirst();
            int row =rvt/(arr[0].length);
            int col =rvt % (arr[0].length);
            int[][] dir ={{0,1},{1,0},{-1,0},{0,-1}};
            for (int i = 0; i < dir.length; i++) {
                int nrow =row+dir[i][0];   
                int ncol =col+dir[i][1];
                if(nrow>=0&&nrow<arr.length && ncol>=0 && ncol <arr[0].length && arr[nrow][ncol]==1){
                    arr[nrow][ncol]=2;
                    queue.addLast(rvt);

                }      
         }
           
        }
    }
}