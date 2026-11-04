import java.util.*;

class Solution {

    class SlidingMedian {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        int leftSize = 0, rightSize = 0;
        long leftSum = 0, rightSum = 0;

        private void addToMap(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        private void removeFromMap(TreeMap<Integer, Integer> map, int val) {
            int cnt = map.get(val);
            if (cnt == 1) {
                map.remove(val);
            } else {
                map.put(val, cnt - 1);
            }
        }

        void add(int val) {
            if (leftSize == 0 || val <= left.lastKey()) {
                addToMap(left, val);
                leftSize++;
                leftSum += val;
            } else {
                addToMap(right, val);
                rightSize++;
                rightSum += val;
            }
            rebalance();
        }

        void remove(int val) {
            if (left.containsKey(val)) {
                removeFromMap(left, val);
                leftSize--;
                leftSum -= val;
            } else {
                removeFromMap(right, val);
                rightSize--;
                rightSum -= val;
            }
            rebalance();
        }

        void rebalance() {
            while (leftSize < rightSize) {
                int v = right.firstKey();

                removeFromMap(right, v);
                rightSize--;
                rightSum -= v;

                addToMap(left, v);
                leftSize++;
                leftSum += v;
            }

            while (leftSize > rightSize + 1) {
                int v = left.lastKey();

                removeFromMap(left, v);
                leftSize--;
                leftSum -= v;

                addToMap(right, v);
                rightSize++;
                rightSum += v;
            }
        }

        int median() {
            return left.lastKey();
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;
        long INF = (long) 1e18;

        SlidingMedian sm = new SlidingMedian();

        long[] cost = new long[n + 1];
        Arrays.fill(cost, INF);

        for (int i = 0; i < n; i++) {

            if (i >= x) {
                sm.remove(nums[i - x]);
            }

            sm.add(nums[i]);

            if (i >= x - 1) {
                long med = sm.median();

                cost[i + 1] =
                        med * sm.leftSize - sm.leftSum +
                        sm.rightSum - med * sm.rightSize;
            }
        }

        long[] dp = new long[n + 1];

        for (int take = 1; take <= k; take++) {

            long[] ndp = new long[n + 1];
            Arrays.fill(ndp, INF);

            for (int pos = take * x; pos <= n; pos++) {

                ndp[pos] = ndp[pos - 1];

                if (dp[pos - x] != INF) {
                    ndp[pos] = Math.min(
                        ndp[pos],
                        dp[pos - x] + cost[pos]
                    );
                }
            }

            dp = ndp;
        }

        return dp[n];
    }
}