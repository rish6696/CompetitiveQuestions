public class CouplingHands{
    public static void main(String[] args) {

        int [] row ={3,2,0,1};
        System.out.println(getSwaps(row));
        
    }


    public static int getSwaps(int [] row ){
        int ans =0;
        int i=0;
        while(i < row.length-1){
            int val =row[i];
            int partner=0;
            if((val&1)==0) partner=val+1;
            else partner=val -1;
            int j=i+1;
            int nxt=row[j];
            while (nxt!=partner) {
                j++;
                nxt=row[j];
            }
            if(j!=i+1){
            swap(row,i+1,j);
            ans++;
            }
            i+=2;

        }
        return ans;


    } 


    public static void swap(int []arr,int i,int j){
        if(i==j)return ;
        arr[i]^=arr[j];
        arr[j]^=arr[i];
        arr[i]^=arr[j];

    }
}