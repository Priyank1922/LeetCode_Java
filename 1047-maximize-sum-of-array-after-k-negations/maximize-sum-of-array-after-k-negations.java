class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length && k>0 ; i++){
            if(nums[i]<0){
                nums[i] = -nums[i];
                k--;
            }
        }

        int sum = 0;
        int minAbs = Integer.MAX_VALUE;;
        for(int num : nums ){
            sum += num;
            minAbs = Math.min(minAbs , Math.abs(num));
        }
        
        if(k%2==1) sum -= 2*minAbs;
        return sum;
    }
}