public class UniqueDigits{
    public static void main(String[] args) {
        int n=4;
        int count=0;
        for(int i=1;i<=n;i++){
            count+=countNumbersWithUniqueDigits(i);
        }
        count++;

        System.out.println("*****************************"+count);
       // System.out.println(countNumbersWithUniqueDigits(1));
    }
    public static  int countNumbersWithUniqueDigits(int n) {
        
        return permu("",1,n,0);
    }
    
    public static int permu(String ans,int count,int k,int done){
        if(count==k+1){
            System.out.print(ans+" ");
            return 1;
        }
        int val=0;
        for(int i=0;i<10;i++){
            if(i!=0||count!=1){
            int mask =1<<i;
            int notmask=~mask;
            if((done&mask)==0){
                done|=mask;
                val+=permu(ans+i,count+1,k,done);
                done&=notmask;
                
            }
        }
        }
        return val;
    }

}