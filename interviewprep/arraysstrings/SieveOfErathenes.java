public class SieveOfErathenes{
    public static void main(String[] args) {
        int n =1000;
        printPrimes(n);
    }

    public static void printPrimes(int n){

        boolean[] arr = new boolean [n+1];
        for(int i =2;i<=(int)Math.pow(n, 0.5);i++){
           if(!arr[i]){
               int k =2;
               while(i*k<=n){
                   arr[i*k]=true;
                   k++;
               }
           }
        }

        for(int i=2;i<arr.length;i++){
            if(!arr[i]) System.out.print(i+" ");
        }
    }
}