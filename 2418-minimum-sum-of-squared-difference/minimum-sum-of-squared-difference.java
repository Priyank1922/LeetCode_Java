class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] frequency = new int[100001];

        long operations = (long) k1 + k2;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            frequency[diff]++;
            maxDiff = Math.max(maxDiff, diff);
        }

        for (int diff = maxDiff; diff > 0 && operations > 0; diff--) {
            int count = frequency[diff];
            if (count == 0) {
                continue;
            }

            long move = Math.min(operations, count);

            frequency[diff] -= move;
            frequency[diff - 1] += move;
            operations -= move;
        }
        long answer = 0;
        for (int diff = 1; diff <= 100000; diff++) {
            answer += (long) diff * diff * frequency[diff];
        }
        return answer;
    }
}