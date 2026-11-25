

class Solution {

    private static final long BASE = 131L;
    private long[] hash;
    private long[] power;

    private long getHash(int l, int r) {
        return hash[r + 1] - hash[l] * power[r - l + 1];
    }

    private boolean check(int[] nums, int len) {

        Map<Long, Integer> freq = new HashMap<>();

        for (int i = 0; i + len - 1 < nums.length; i++) {
            long h = getHash(i, i + len - 1);
            freq.put(h, freq.getOrDefault(h, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        hash = new long[n + 1];
        power = new long[n + 1];

        power[0] = 1;

        for (int i = 0; i < n; i++) {
            power[i + 1] = power[i] * BASE;
            hash[i + 1] = hash[i] * BASE + nums[i];
        }

        int left = 1;
        int right = n;
        int ans = n;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (check(nums, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}