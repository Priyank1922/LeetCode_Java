class Solution {
    public int removeDuplicates(int[] nums) {
        int k, i = 1;
        for (k = 1; k < nums.length; k++) {
            if (nums[k - 1] != nums[k]) {
                nums[i] = nums[k];
                i++;
            }
        }
        return i;
    }
}