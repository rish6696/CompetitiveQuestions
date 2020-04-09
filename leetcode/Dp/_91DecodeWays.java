import java.util.Arrays;

public class _91DecodeWays {
    public static void main(String[] args) {

        String s = "7541387519572282368613553811323167125532172369624572591562685959575371877973171856836975137559677665";
        // int [] dp = new int [s.length()+1];
        // Arrays.fill(dp, -1);
        // System.out.println(decodeWays(0, s, dp));
        System.out.println(decodeWaysDp(s));
        System.out.println(decodeWaysDpOptimised(s));
    }

    public static int decodeWaysDpOptimised(String str) {

        int[] dp = new int[str.length() + 1];
        int j = str.length() - 1;

        int f = 0;
        int s = 1;
        if (str.charAt(j) == '0')
            f = 0;
        else
            f = 1;

        for (int i = dp.length - 3; i >= 0; i--) {

            int ans = 0;

            if (str.charAt(i) == '0') {
                ans = 0;
            } else {

                // select two index
                if (Integer.parseInt(str.substring(i, i + 2)) <= 26)
                    ans += s;

                // select first index
                if (str.charAt(i + 1) != '0')
                    ans += f;

            }
            s=f;
            f=ans;
        }

        return f;

    }

    public static int decodeWaysDp(String str) {

        int[] dp = new int[str.length() + 1];
        int j = str.length() - 1;

        for (int i = dp.length - 1; i >= 0; i--) {

            if (i > j) {
                dp[i] = 1;
                continue;
            }
            if (i == j) {
                if (str.charAt(i) == '0') {
                    dp[i] = 0;
                    continue;
                }
                dp[i] = 1;
                continue;
            }

            if (str.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            int ans = 0;

            // select two index
            if (Integer.parseInt(str.substring(i, i + 2)) <= 26)
                ans += dp[i + 2];

            // select first index
            if (str.charAt(i + 1) != '0')
                ans += dp[i + 1];

            dp[i] = ans;
        }

        return dp[0];

    }

    public static int decodeWays(int i, String str, int[] dp) {

        int j = str.length() - 1;
        if (i > j) {
            dp[i] = 1;
            return 1;
        }
        if (i == j) {
            if (str.charAt(i) == '0') {
                dp[i] = 0;
                return 0;
            }
            dp[i] = 1;
            return 1;
        }

        if (str.charAt(i) == '0') {
            dp[i] = 0;
            return 0;
        }
        if (dp[i] != -1) {
            System.out.println("returned from dp");
            return dp[i];
        }
        int ans = 0;

        // select two index
        if (Integer.parseInt(str.substring(i, i + 2)) <= 26)
            ans += decodeWays(i + 2, str, dp);

        // select first index
        if (str.charAt(i + 1) != '0')
            ans += decodeWays(i + 1, str, dp);

        dp[i] = ans;
        return ans;
    }
}