public class BeautifulArrangement{
    public static void main(String[] args) {
        int n=4;
        //boolean[] arr=new boolean [n];
        int isDone=0;
        System.out.println(permu("", isDone, 0, n));
        
    }
    public static boolean canAdd (int num ,int i){
        return num%i==0 || i%num==0 ;
    }

    public static int  permu(String ans,int isDone,int idx,int n){
        if(idx==n){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i=1;i<=n;i++){
            int mask = (1<<(i-1));
            int negtion=~mask;
            if( (isDone&mask)==0 && canAdd(i, idx+1)){
                isDone|=mask;
                count+=permu(ans+i, isDone, idx+1, n);
                isDone&=negtion;
            }
        }
        return count;
    }
}