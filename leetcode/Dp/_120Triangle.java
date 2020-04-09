import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _120Triangle {
    public static void main(String[] args) {
        List<List<Integer>> t = new ArrayList<>();
        t.add(Arrays.asList(2));
        t.add(Arrays.asList(3,4));
        t.add(Arrays.asList(6,5,7));
        t.add(Arrays.asList(4,1,8,3));
        System.out.println(getMinDp(t));
        

    }

    public static int getMinDp(List<List<Integer>> t) {

        int[][] dp = new int[t.size()][t.size()];

        for (int row = dp.length - 1; row >= 0; row--) {
            for (int col = t.get(row).size()-1; col >= 0; col--) {

                if (row == t.size() - 1) {
                    dp[row][col] = t.get(row).get(col);
                    continue;
                }

                int ans = Integer.MAX_VALUE;

                // left call
                ans = Math.min(ans, dp[row + 1] [col]);

                // right call
                ans = Math.min(ans, dp[row + 1] [col + 1]);
                dp[row][col] = ans + t.get(row).get(col);
            }
        }

        return dp[0][0];
    }

    public static int getMin(int row, int col, List<List<Integer>> triangle, int[][] dp) {

        if (dp[row][col] != Integer.MAX_VALUE)
            return dp[row][col];

        if (row == triangle.size() - 1) {
            dp[row][col] = triangle.get(row).get(col);
            return dp[row][col];
        }

        int ans = Integer.MAX_VALUE;

        // left call
        ans = Math.min(ans, getMin(row + 1, col, triangle, dp));

        // right call
        ans = Math.min(ans, getMin(row + 1, col + 1, triangle, dp));
        dp[row][col] = ans + triangle.get(row).get(col);
        return dp[row][col];
    }
}