class Solution {
    public int climbStairs(int n, int[] costs) {

        long[] dp = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = Long.MAX_VALUE;
        }
 dp[0] = 0;

        for (int i = 1; i <= n; i++) {
if (i - 1 >= 0) dp[i] = Math.min(dp[i], dp[i - 1] + costs[i - 1] + 1);

if (i - 2 >= 0) dp[i] = Math.min(dp[i],dp[i - 2] + costs[i - 1] + 4);

if (i - 3 >= 0) dp[i] = Math.min(dp[i],dp[i - 3] + costs[i - 1] + 9);
        }

        return (int) dp[n];
    }
}