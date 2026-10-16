class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectSum = n * (n+1) /2;
        int actualSum = 0;

        for(int num : nums){
            actualSum += num;
        }
        return  expectSum - actualSum;
    }
}