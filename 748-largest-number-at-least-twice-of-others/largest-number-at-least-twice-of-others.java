class Solution {
    public int dominantIndex(int[] nums) {
     int large = -1;
     int secondLarge = -1;
     int idx = -1;
     for(int i = 0 ; i < nums.length ; i++){
        if(nums[i]>large){
            secondLarge = large; 
            large = nums[i];
            idx = i;
        }else if(nums[i]>secondLarge)secondLarge = nums[i];
     }   
     return large >= 2 * secondLarge ? idx : -1;
     
    }
}