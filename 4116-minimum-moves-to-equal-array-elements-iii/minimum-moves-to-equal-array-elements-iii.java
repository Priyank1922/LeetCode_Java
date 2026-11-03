class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        for(int num : nums) max = Math.max(max , num); 

        int move = 0;
        for(int num : nums) move += (max-num);

        return move;      
    }
}