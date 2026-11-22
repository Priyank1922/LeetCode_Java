class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];

        for(int num : nums){
            min = Math.min(min , num);
            max = Math.max(max , num);
        }

        return Math.max(0 , max - min -2*k);
    }
}