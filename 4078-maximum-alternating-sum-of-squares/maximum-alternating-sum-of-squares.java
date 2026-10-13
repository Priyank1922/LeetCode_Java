class Solution {
    public long maxAlternatingSum(int[] nums) {
           int n = nums.length;
           long[]squares = new long[n];

           for(int i = 0 ; i < n ; i++){
            squares[i] = 1L * nums[i] * nums[i];
           } 
           Arrays.sort(squares);

           int positiveCount = (n+1)/2;
           long ans = 0;

            for(int i=0 ; i < n-positiveCount ; i++){
                ans -= squares[i];
            }

            for(int i = n - positiveCount ; i < n ; i++){
                ans += squares[i];
            }
           return ans;
    }
}