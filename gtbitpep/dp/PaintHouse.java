import java.util.Arrays;

public class PaintHouse {
    public static void main(String[] args) {
        int[][] arr = { { 1, 5, 7 }, { 5, 8, 4 }, { 3, 2, 9 }, { 1, 2, 4 } };
        int[][] dp = new int[arr.length+1][4];
        for (int[] a : dp)
            Arrays.fill(a, Integer.MAX_VALUE);
        System.out.println(RECURSIVE(arr, 0, 0));
        System.out.println(RECURSIVE_MEMO(arr, 0, 0, dp));
        System.out.println(DP(arr));

    }

    public static int RECURSIVE(int[][] arr, int idx, int prevent) {
        if (idx == arr.length)
            return 0;
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k <= 2; k++) {
            if (k + 1 != prevent)
                ans = Math.min(ans, arr[idx][k] + RECURSIVE(arr, idx + 1, k + 1));
        }
        return ans;
    }

    public static int RECURSIVE_MEMO(int[][] arr, int idx, int prevent, int[][] dp) {
        if (idx == arr.length)
            return 0;
        if (dp[idx][prevent] != Integer.MAX_VALUE) {
            return dp[idx][prevent];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k <= 2; k++) {
            if (k + 1 != prevent)
                ans = Math.min(ans, arr[idx][k] + RECURSIVE_MEMO(arr, idx + 1, k + 1, dp));
        }
        dp[idx][prevent] = ans;
        return ans;
    }

    public static int DP(int[][] arr) {
        int[][] dp = new int[arr.length+1][4];
        for (int idx = dp.length - 1; idx >= 0; idx--) {
            for (int prevent = dp[0].length - 1; prevent >= 0; prevent--) {
                if (idx == arr.length) continue;
                int ans =Integer.MAX_VALUE;
                for (int k = 1; k <= 3; k++) {
                    if (k != prevent)
                        ans = Math.min(ans, arr[idx][k-1] + dp[idx + 1][k]);
                }
                dp[idx][prevent] = ans;
            }
        }
        return dp[0][0];
    }
}