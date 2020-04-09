import java.util.Arrays;

public class _64MinimumPathSum {
    public static void main(String[] args) {

        int[][] grid = { { 1, 4, 8, 6, 2, 2, 1, 7 }, { 4, 7, 3, 1, 4, 5, 5, 1 }, { 8, 8, 2, 1, 1, 8, 0, 1 },
                { 8, 9, 2, 9, 8, 0, 8, 9 }, { 5, 7, 5, 7, 1, 8, 5, 5 }, { 7, 0, 9, 4, 5, 6, 5, 6 },
                { 4, 9, 9, 7, 9, 1, 9, 0 } };

        // int [][] grid ={
        // {1,3,1},
        // {1,5,1},
        // {4,2,1}
        // };

        // System.out.println(minimumpathSum(0, 0, grid));

        // int[] dp = new int[grid.length * grid[0].length];
        // Arrays.fill(dp, -1);
        System.out.println(minimumpathSumDp(grid));

    }

    public static int minimumpathSum(int cr, int cc, int[][] grid) {

        int er = grid.length - 1;
        int ec = grid[0].length - 1;

        if (cr == er && cc == ec)
            return grid[er][ec];

        int[][] dir = { { 0, 1 }, { 1, 0 } };

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < dir.length; i++) {
            int row = cr + dir[i][0];
            int col = cc + dir[i][1];
            if (row >= 0 && row <= er && col >= 0 && col <= ec) {
                int rec = minimumpathSum(row, col, grid);
                ans = Math.min(ans, rec + grid[cr][cc]);
            }
        }
        return ans;
    }

    public static int minimumpathSumMemo(int cr, int cc, int[][] grid, int[] dp) {

        int er = grid.length - 1;
        int ec = grid[0].length - 1;
        int idx = cr * (ec + 1) + cc;
        if (dp[idx] != -1)
            return dp[idx];

        if (cr == er && cc == ec) {
            dp[idx] = grid[er][ec];
            return grid[er][ec];
        }

        int[][] dir = { { 0, 1 }, { 1, 0 } };

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < dir.length; i++) {
            int row = cr + dir[i][0];
            int col = cc + dir[i][1];
            if (row >= 0 && row <= er && col >= 0 && col <= ec) {
                int rec = minimumpathSumMemo(row, col, grid, dp);
                ans = Math.min(ans, rec + grid[cr][cc]);
            }
        }
        dp[idx] = ans;
        return ans;
    }

    public static int minimumpathSumDp(int[][] grid) {

        int er = grid.length - 1;
        int ec = grid[0].length - 1;

        int[][] dp = new int[er + 1][ec + 1];
        dp[er][ec] = grid[er][ec];

        int [][] dir ={{0,1},{1,0}};

        for (int row = er; row >= 0; row--) {
            for (int col = ec; col >= 0; col--) {
                if (row == er && col == ec)
                    continue;

                int ans = Integer.MAX_VALUE;
                for (int i = 0; i < dir.length; i++) {
                    int r = row + dir[i][0];
                    int c = col + dir[i][1];
                    if (r >= 0 && r <= er && c >= 0 && c <= ec) {
                        int rec = dp[r][c];
                        ans = Math.min(ans, rec + grid[row][col]);
                    }
                }
                dp[row][col] = ans;
            }
        }
        return dp[0][0];
    }

}