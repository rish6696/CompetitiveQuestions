import java.util.Arrays;

public class _44WildcardMatching {
    public static void main(String[] args) {

        String str = "aa";
        String pattern = "*";
        int[][] dp = new int[str.length() + 1][pattern.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        // String str ="ho";
        // String pattern ="ho**";
        System.out.println(wildcard(pattern, str, 0, 0, dp));
        System.out.println(wildCardDp(pattern, str));
        //display2D(dp);

    }

    public static void display2D(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }

    public static boolean wildCardDp(String pattern, String str) {

        int[][] dp = new int[str.length() + 1][pattern.length() + 1];
        for (int m = dp.length - 1; m >= 0; m--) {
            for (int n = dp[0].length - 1; n >= 0; n--) {

                if (m >= str.length() && n >= pattern.length()) {
                    dp[m][n] = 1;
                    continue;
                }

                if (m < str.length() && n >= pattern.length()) {
                    dp[m][n] = 0;
                    continue;
                }

                if (m >= str.length() && n < pattern.length()) {
                    if (pattern.charAt(n) != '*') {
                        dp[m][n] = 0;
                        continue;
                    }
                    int rec = dp[m][n + 1];
                    dp[m][n] = rec;
                    continue;
                }

                char strc = str.charAt(m);
                char pttrc = pattern.charAt(n);

                if (pttrc == '?' || strc == pttrc) {
                    dp[m][n] = dp[m + 1][n + 1];
                    continue;
                }

                if (pttrc != '*' && pttrc != strc) {
                    dp[m][n] = 0;
                    continue;
                }
                int i=0;

                for (i = m; i <= str.length(); i++) {
                    int recAns = dp[i][n + 1];
                    if (recAns==1) {
                        dp[m][n] = 1;
                        break;
                    }
                }
                if(i>str.length())dp[m][n] = 0;
            }
        }

        return dp[0][0] ==1;

    }

    // m for string
    // n for pattern
    public static boolean wildcard(String pattern, String str, int m, int n, int[][] dp) {

        if (dp[m][n] != -1) {
            // System.out.println("returned from dp");
            return dp[m][n] == 0 ? false : true;
        }

        if (m >= str.length() && n >= pattern.length()) {
            dp[m][n] = 1;
            return true;
        }

        if (m < str.length() && n >= pattern.length()) {
            dp[m][n] = 0;
            return false;
        }

        if (m >= str.length() && n < pattern.length()) {
            if (pattern.charAt(n) != '*') {
                dp[m][n] = 0;
                return false;
            }
            boolean rec = wildcard(pattern, str, m, n + 1, dp);
            dp[m][n] = rec == true ? 1 : 0;
            return rec;
        }

        char strc = str.charAt(m);
        char pttrc = pattern.charAt(n);

        if (pttrc == '?' || strc == pttrc) {
            boolean rec = wildcard(pattern, str, m + 1, n + 1, dp);
            dp[m][n] = rec == true ? 1 : 0;
            return rec;
        }

        if (pttrc != '*' && pttrc != strc) {
            dp[m][n] = 0;
            return false;
        }

        for (int i = m; i <= str.length(); i++) {
            boolean recAns = wildcard(pattern, str, i, n + 1, dp);
            if (recAns) {
                dp[m][n] = 1;
                return true;
            }
        }
        dp[m][n] = 0;
        return false;
    }

}