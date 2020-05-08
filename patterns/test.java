
public class test {
    public static void main(String[] args) {
        int [][] arr =  {  {1,2,3,4} ,{6,7,8,9} ,{9,1,2,3}};
        print(arr);
    }


    public static void print(int [][]arr){

        int col =0;
        boolean uptobottom=true;
        while(col<arr[0].length){
            int row = uptobottom ?0:arr.length-1;
            if(uptobottom){
                while(row<arr.length){
                System.out.print(arr[row][col]+" ");
                row++;
                }
                uptobottom=false;
            }else{
                while(row>=0){
                    System.out.print(arr[row][col]+" ");
                    row--;
                    }
                    uptobottom=true;
            }
            col++;
        }
    }

}