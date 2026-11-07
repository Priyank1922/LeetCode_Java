class Solution {
    public int findLengthOfLCIS(int[] nums) {
    int count = 1;
    int maxLen = 1;
    for(int i = 1 ; i < nums.length; i++){
        if(nums[i] > nums[i-1])count++;
        else count = 1;

        maxLen = Math.max(maxLen , count);
    }
    return maxLen;
    }
}