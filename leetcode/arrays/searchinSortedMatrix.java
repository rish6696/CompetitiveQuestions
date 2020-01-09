public class searchinSortedMatrix{
 public static void main(String[] args) {

    int [][] arr ={
        {1,   3,  5,  7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}
    };

    System.out.println(search(arr, 13));
     
 }

 public static boolean search(int [][]matrix,int target){
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return false;
        }
        int r=0;
        int c= matrix[0].length-1;
        while(r < matrix.length && c>=0){
            if(target == matrix[r][c])
            return true;
              
            else if(target < matrix[r][c] )
             c--;
             else r++;
        }
        return false;
   
    // if(target<arr[0][0])return false;
    // int i=0;
    // int j=0;
    // while(i>=0 && i<arr.length && j>=0 && j < arr[0].length){
    //     if(arr[i][j]==target)return true;
    //     else if(arr[i][j]<target){
    //         if(j==arr[0].length-1) i++;
    //         else j++;
    //     }else j--;

    // }
    // return false;

 }




}