public class Watch{
    public static void main(String[] args) {
        boolean[]arr=new boolean[12];
        int k=2;
        printSol(0, arr, 0,k);
        
    }

    public static String getTimeFromArray(boolean []arr){
        int hourSum=0;
        int  minSum=0; 
        for(int i=0;i<arr.length;i++){
            if(arr[i]){
                if(i<=3){
                    hourSum+=1<<i;
                }else{
                    int k=i%4;
                    minSum+=1<<k;
                }
            
            }
        }
        return hourSum+":"+minSum;
  
    }

    public static void printSol(int start,boolean []arr,int c,int total){
        if(c==total+1){
            System.out.println(getTimeFromArray(arr));
            return ;
        }

        for(int i=start;i<arr.length;i++){
            arr[i]=true;
            printSol(i+1, arr,c+1,total);
            arr[i]=false;
        }
    }
}