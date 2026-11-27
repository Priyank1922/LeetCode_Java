class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] bonus = new int[n];

        for (int i = 0; i < n; i++) {
            int factorI = items[i][0];

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int factorJ = items[j][0];

                if (factorJ % factorI == 0) {
                    bonus[i]++;
                }
            }
        }

        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];

            int[] take = new int[budget + 1];

            for (int b = 0; b <= budget; b++) {
                take[b] = Integer.MIN_VALUE / 2;
            }

            for (int b = price; b <= budget; b++) {
                take[b] = dp[b - price] + bonus[i] + 1;
            }

            for (int b = price; b <= budget; b++) {
                take[b] = Math.max(take[b], take[b - price] + 1);
            }

            for (int b = 0; b <= budget; b++) {
                dp[b] = Math.max(dp[b], take[b]);
            }
        }

        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, dp[b]);
        }

        return ans;
    }
}