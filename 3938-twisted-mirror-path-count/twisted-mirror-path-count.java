class Solution {

    static final int MOD = 1_000_000_007;

    int m, n;
    int[][] grid;

    int[][][] memo;
    boolean[][][] vis;

    private int encode(int r, int c) {
        return r * n + c;
    }

    private int resolve(int r, int c, int dir) {

        if (r < 0 || c < 0 || r >= m || c >= n)
            return -1;

        if (grid[r][c] == 0)
            return encode(r, c);

        if (vis[r][c][dir])
            return memo[r][c][dir];

        vis[r][c][dir] = true;

        if (dir == 0) {
            memo[r][c][dir] = resolve(r + 1, c, 1);
        } else {
            memo[r][c][dir] = resolve(r, c + 1, 0);
        }

        return memo[r][c][dir];
    }

    public int uniquePaths(int[][] grid) {

        this.grid = grid;

        m = grid.length;
        n = grid[0].length;

        memo = new int[m][n][2];
        vis = new boolean[m][n][2];

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                long ways = dp[i][j];

                if (ways == 0)
                    continue;
                if (j + 1 < n) {

                    int dest;

                    if (grid[i][j + 1] == 0) {
                        dest = encode(i, j + 1);
                    } else {
                        dest = resolve(i, j + 1, 0);
                    }

                    if (dest != -1) {
                        int r = dest / n;
                        int c = dest % n;

                        dp[r][c] = (dp[r][c] + ways) % MOD;
                    }
                }
                if (i + 1 < m) {

                    int dest;

                    if (grid[i + 1][j] == 0) {
                        dest = encode(i + 1, j);
                    } else {
                        dest = resolve(i + 1, j, 1);
                    }

                    if (dest != -1) {
                        int r = dest / n;
                        int c = dest % n;

                        dp[r][c] = (dp[r][c] + ways) % MOD;
                    }
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }
}