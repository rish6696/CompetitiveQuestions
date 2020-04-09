import java.util.Arrays;

public class rough {
    public static void main(String[] args) {
        int []a ={2,3,5,7};
        int []b ={1,8,9,6};

        System.out.println(Arrays.toString(sumarray(a, b, a.length, b.length)));
        
    }
    public static int[] sumarray(int a[], int b[], int n, int m) {
        int sum, carry = 0;
        int i = n - 1;
        int j = m - 1;
        int newSize = Math.max(n, m) + 1;
        int[] ans = new int[newSize];
        int k =ans.length-1;
        while (i >=0 && j >=0) {
            sum = a[i] + b[j] + carry;
            int x = sum % 10;
            carry = sum / 10;
            ans[k] = x;
            i--;
            j--;
            k--;
        }
        while (i >= 0) {
            sum = a[i] + carry;
            int x = sum % 10;
            carry = sum / 10;
            ans[k] = x;
            i--;
            k--;
        }
        while (j >= 0) {
            sum = b[j] + carry;
            int x = sum % 10;
            carry = sum / 10;
            ans[k] = x;
            j--;
            k--;
        }
        if (carry != 0){
            ans[k] = carry;
            return ans;
        } 
        else{
            int[] ans_ = new int [ans.length-1];
            for(int idx =1;idx < ans.length;idx++){
                ans_[idx-1]=ans[idx];
            }
            return ans_;
        }
     
    }
}