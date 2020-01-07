import java.util.*;
public class RotateMatrix{
    public static void main(String[] args) {
        int[][]matrix={
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        transposeMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            reverse(matrix[i]);
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void reverse(int []arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            arr[left]^=arr[right];
            arr[right]^=arr[left];
            arr[left]^=arr[right];
            left++;
            right--;

        }
    }
    

    public static void transposeMatrix(int[][]matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                if(j!=i)swap(matrix, i, j);
            }
        }
    }

    public static void swap(int[][]matrix,int i,int j){
        matrix[i][j]^=matrix[j][i];
        matrix[j][i]^=matrix[i][j];
        matrix[i][j]^=matrix[j][i];
    }
}