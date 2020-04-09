import java.math.BigInteger;

public class _55JumpGame {

    public static void main(String[] args) {

        BigInteger a = new BigInteger("0");
        System.out.println(a.ONE);

        int[] nums = { 3, 2, 1, 0, 4 };
        int[] dp = new int[nums.length];
        System.out.println(canDp(nums));
        // System.out.println(can(0, nums, dp));
        // display(dp);

    }

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static boolean canDp(int[] nums) {

        boolean[] dp = new boolean[nums.length];

        for (int idx = dp.length - 1; idx >= 0; idx--) {

            if (idx == nums.length - 1) {
                dp[idx] = true;
                continue;
            }

            boolean ans = false;

            for (int i = 1; i <= nums[idx]; i++) {
                if (idx + i < nums.length) {
                    boolean rec = dp[idx + i];
                    if (rec) {
                        ans = true;
                        break;
                    }
                }
            }
            dp[idx] = ans;
        }
        return dp[0];
    }

    public static boolean can(int idx, int[] nums, int[] dp) {

        if (idx == nums.length - 1)
            return true;
        if (dp[idx] == 1)
            return false;

        for (int i = 1; i <= nums[idx]; i++) {
            if (idx + i < nums.length) {
                boolean rec = can(idx + i, nums, dp);
                if (rec)
                    return rec;
            }
        }
        dp[idx] = 1;
        return false;
    }

    public static int minjumps(int arr[], int[] strg, int idx) {
        if (idx == arr.length - 1) {
            return 0;
        }
        if (strg[idx] != 0) {
            return strg[idx];
        }
        int val = arr[idx];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= val; i++) {
            if (idx + i < arr.length) {
                int recAns = minjumps(arr, strg, i + idx);
                ans = Math.min(ans, recAns);
            }
        }
        if (ans == Integer.MAX_VALUE) {
            strg[idx] = ans;
            return ans;
        }
        strg[idx] = ans + 1;
        return ans + 1;
    }

    public static int minjumpsDp(int arr[]) {

        int[] dp = new int[arr.length];
        dp[dp.length - 1] = 0;
        for (int idx = dp.length - 1; idx >= 0; idx--) {

            if (idx == arr.length - 1) continue;


            int val = arr[idx];
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i <= val; i++) {
                if (idx + i < arr.length) {
                    int recAns = dp[i + idx];
                    ans = Math.min(ans, recAns);
                }
            }
            if (ans == Integer.MAX_VALUE) {
                dp[idx] = ans;
               
            }else{
                dp[idx]=ans+1;
            }
            
        }

        return dp[0];
    }
}