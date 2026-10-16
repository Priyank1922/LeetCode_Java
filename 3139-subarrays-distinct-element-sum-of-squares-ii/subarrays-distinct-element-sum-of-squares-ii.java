class Solution {

    private static final int MOD = 1_000_000_007;

    class SegmentTree {
        long[] sum;
        long[] sqSum;
        long[] lazy;
        int n;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sqSum = new long[4 * n];
            lazy = new long[4 * n];
        }

        private void apply(int node, int l, int r, long val) {
            int len = r - l + 1;

            sqSum[node] = (sqSum[node]
                    + 2L * val % MOD * sum[node] % MOD
                    + val * val % MOD * len % MOD) % MOD;

            sum[node] = (sum[node] + val * len) % MOD;

            lazy[node] += val;
        }

        private void push(int node, int l, int r) {
            if (lazy[node] == 0) {
                return;
            }

            int mid = (l + r) / 2;

            apply(node * 2, l, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, r, lazy[node]);

            lazy[node] = 0;
        }

        private void update(int node, int l, int r,
                            int ql, int qr, int val) {

            if (ql > r || qr < l) {
                return;
            }

            if (ql <= l && r <= qr) {
                apply(node, l, r, val);
                return;
            }

            push(node, l, r);

            int mid = (l + r) / 2;

            update(node * 2, l, mid, ql, qr, val);
            update(node * 2 + 1, mid + 1, r, ql, qr, val);

            sum[node] =
                (sum[node * 2] + sum[node * 2 + 1]) % MOD;

            sqSum[node] =
                (sqSum[node * 2] + sqSum[node * 2 + 1]) % MOD;
        }

        long getSquareSum() {
            return sqSum[1];
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;

        SegmentTree st = new SegmentTree(n);

        Map<Integer, Integer> lastPos = new HashMap<>();

        long ans = 0;

        for (int i = 0; i < n; i++) {

            int prev = lastPos.getOrDefault(nums[i], -1);

            st.update(1, 0, n - 1,
                    prev + 1, i, 1);

            ans = (ans + st.getSquareSum()) % MOD;

            lastPos.put(nums[i], i);
        }

        return (int) ans;
    }
}