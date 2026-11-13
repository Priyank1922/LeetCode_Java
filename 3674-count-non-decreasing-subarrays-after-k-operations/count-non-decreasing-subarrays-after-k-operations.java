class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
 int n = nums.length;
        long ans = 0;
        long cost = 0;
        Deque<long[]> dq = new ArrayDeque<>();
        int j = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            int count = 1;
while (!dq.isEmpty() && dq.peekLast()[0] < num) {
                long[] last = dq.pollLast();
long nextNum = last[0];
                int nextCount = (int) last[1];
                count += nextCount;
                cost += (long) (num - nextNum) * nextCount;
            }
            dq.offerLast(new long[]{num, count});
            while (cost > k) {
                long[] first = dq.pollFirst();
                long rightmostNum = first[0];
                int rightmostCount = (int) first[1];
cost -= rightmostNum - nums[j];
                j--;
                if (rightmostCount > 1) {
                    dq.offerFirst(
                        new long[]{rightmostNum, rightmostCount - 1}
                    );
                }
            }
            ans += j - i + 1;
        }
        return ans;
    }
}