class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int k = nums[0];
        boolean ascending = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] != (k + i) % n) {
                ascending = false;
                break;
            }
        }

        if (ascending) {
            if (k == 0) return 0;
            return Math.min(n - k, k + 2);
        }
        k = n - 1 - nums[0];
        boolean descending = true;

        for (int i = 0; i < n; i++) {
            int expected = n - 1 - ((k + i) % n);

            if (nums[i] != expected) {
                descending = false;
                break;
            }
        }

        if (descending) {
            return Math.min(k + 1, n - k + 1);
        }

        return -1;
    }
}