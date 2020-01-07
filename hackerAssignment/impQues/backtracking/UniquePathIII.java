public class UniquePathIII {
    public static void main(String[] args) {
        int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 2 } };
        int[] staringPoints = getStartingOrEnding(grid, 1);
        int[] endingPoints = getStartingOrEnding(grid, 2);
        System.out.println(getPaths(staringPoints[0], staringPoints[1], endingPoints[0], endingPoints[1], grid,
                new boolean[grid.length][grid[0].length]));

    }

    public static boolean isValid(int cr, int cc, int[][] board, boolean[][] isVisited) {
        if (cr >= 0 && cr < board.length && cc >= 0 && cc < board[0].length && board[cr][cc] != -1
                && !isVisited[cr][cc])
            return true;
        return false;
    }

    public static boolean passedEveryObstacleOnce(int[][] board, boolean[][] isVisited) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    if (!isVisited[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int getPaths(int cr, int cc, int er, int ec, int[][] board, boolean[][] isVisited) {
        if (cr == er && cc == ec && passedEveryObstacleOnce(board, isVisited)) {
            return 1;
        }
        isVisited[cr][cc] = true;
        int count = 0;
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int dir = 0; dir < directions.length; dir++) {
            int x = cr + directions[dir][0];
            int y = cc + directions[dir][1];
            if (isValid(x, y, board, isVisited)) {
                count += getPaths(x, y, er, ec, board, isVisited);
            }
        }
        isVisited[cr][cc] = false;
        return count;
    }

    public static int[] getStartingOrEnding(int[][] board, int ref) {
        int[] arr = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == ref) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }

        }
        return arr;
    }

}