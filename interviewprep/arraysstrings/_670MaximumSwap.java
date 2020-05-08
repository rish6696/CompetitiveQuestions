public class _670MaximumSwap {
    public static void main(String[] args) {
        System.out.println(maximumSwap(12));
    }

    public static int maximumSwap(int num) {
        String s = num+"";
        char[] arr = s.toCharArray();
        int k=-1;
        for(int i=1;i<arr.length;i++){
            int curr = arr[i]-'0';
            int prev =arr[i-1]-'0';
            if(curr>prev){
                k=i;
                break;
            }
        }
        
        if(k==-1) return num;
        int maxIndex =k;
        for(int i=k+1;i<arr.length;i++){
             if(arr[i]>arr[maxIndex]) maxIndex = i; 
        }
        
        
        for(int i=0;i<=k;i++){
            if(arr[i]<arr[maxIndex]){
                swap(arr,maxIndex,i);
                break;
            }
        }
        
        return Integer.parseInt(new String(arr));
    }
    
    
    public static void swap(char[]arr,int i ,int j){
        if(i==j) return ;
        arr[i]^=arr[j];
        arr[j]^=arr[i];
        arr[i]^=arr[j];
        
    }
}