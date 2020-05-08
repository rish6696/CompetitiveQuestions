import java.util.Arrays;

public class _Numberofsubsequencesoftheformabc {

    public static void main(String[] args) {
        String str = "abbc";
        int[][] dp = new int[str.length() + 1][4];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        System.out.println(recursiveSol(str, 0, 0, dp));
        System.out.println(DP_ITERATIVE(str));
    }

    public static int recursiveSol(String str, int idx, int last, int[][] dp) {
        if (idx == str.length()) {
            if (last == 3) {
                dp[idx][last] = 1;
                return 1;
            }
            dp[idx][last] = 0;
            return 0;
        }

        if (dp[idx][last] != -1) {
            System.out.println("returnnded from dp ");
            return dp[idx][last];
        }

        // select it
        int curr = str.charAt(idx) - 'a' + 1;
        int ans = 0;
        if (curr - 1 == last || curr == last) {
            ans += recursiveSol(str, idx + 1, curr, dp);
        }

        // not select
        ans += recursiveSol(str, idx + 1, last, dp);
        dp[idx][last] = ans;
        return ans;
    }

    public static int DP_ITERATIVE(String str) {

        int[][] dp = new int[str.length() + 1][4];
        for (int idx = dp.length - 1; idx >= 0; idx--) {
            for (int last = dp[0].length - 1; last >= 0; last--) {
                if (idx == str.length()) {
                    if (last == 3) {
                        dp[idx][last] = 1;
                        continue;
                    }
                    dp[idx][last] = 0;
                    continue;
                }
                // select it
                int curr = str.charAt(idx) - 'a' + 1;
                int ans = 0;
                if (curr - 1 == last || curr == last) {
                    ans += dp[idx + 1][curr];
                }

                // not select
                ans += dp[idx + 1][last];
                dp[idx][last] = ans;
            }
        }
        return dp[0][0];
    }

}