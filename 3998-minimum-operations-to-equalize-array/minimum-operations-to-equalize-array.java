class Solution {
    public int minOperations(int[] nums) {
        int first = nums[0];
        for(int num : nums)
            if(num != first) return 1;
        return 0;
    }
}