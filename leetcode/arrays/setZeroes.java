import java.util.Arrays;
public class setZeroes{
    public static void main(String[] args) {

        int[][]arr={{1,0,9,7},{0,4,6,3},{2,1,9,2}};
        boolean isColum =false;
      
        //check for the all numbers but except for the first column
        for (int i = 0; i < arr.length; i++) {

            if(arr[i][0]==0) isColum=true;

            for (int j = 1; j < arr[0].length; j++) {
                if(arr[i][j]==0){
                    arr[i][0]=0;
                    arr[0][j]=0;
                } 
            }
        }

        //setting 0 to all rows and column except first row and column 

        for (int i = 1; i < arr.length; i++) {

            for (int j = 1; j < arr[0].length; j++) {
                if(arr[i][0]==0||arr[0][j]==0){
                    arr[i][j]=0;
                }
            }
            
        }


        // if first row is also needed to be set 0 
        if(arr[0][0]==0){
            for (int i = 0; i < arr[0].length; i++) {
                arr[0][i]=0;
            }
        }

        // if first column is alsi needed to set 0 
        if(isColum){
            for (int i = 0; i < arr.length; i++) {
                arr[i][0]=0;
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    
    }


   
}