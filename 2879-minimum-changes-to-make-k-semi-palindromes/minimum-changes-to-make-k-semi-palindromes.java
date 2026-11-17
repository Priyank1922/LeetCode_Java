class Solution {

    public int minimumChanges(String s, int k) {
        int n = s.length();

        int[][] cost = new int[n][n];

        // precompute cost
        for (int l = 0; l < n; l++) {
            for (int r = l + 1; r < n; r++) {
                cost[l][r] = getCost(s, l, r);
            }
        }

        int INF = 1_000_000;

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {

            for (int part = 1; part <= k; part++) {

                for (int p = 0; p < i; p++) {

                    if (dp[p][part - 1] == INF)
                        continue;
                    int len = i - p;
                    if (len < 2)
                        continue;
                    dp[i][part] = Math.min(
                            dp[i][part],
                            dp[p][part - 1] + cost[p][i - 1]);
                }
            }
        }
        return dp[n][k];
    }
    private int getCost(String s, int l, int r) {
        int len = r - l + 1;
        int ans = Integer.MAX_VALUE;
        for (int d = 1; d < len; d++) {

            if (len % d != 0)
                continue;
            int cur = 0;
            for (int start = 0; start < d; start++) {
                int left = start;
                int right = start + ((len / d) - 1) * d;

                while (left < right) {

                    if (s.charAt(l + left) != s.charAt(l + right))
                        cur++;
                    left += d;
                    right -= d;
                }
            }
            ans = Math.min(ans, cur);
        }
 return ans;
    }
}