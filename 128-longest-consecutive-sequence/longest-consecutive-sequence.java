class Solution {
    public int longestConsecutive(int[] nums) {
       int longestLength = 0;
        Map<Integer , Boolean> exploredMap = new HashMap<>();
        for(int num : nums){
            exploredMap.put(num , Boolean.FALSE);
        }
        for(int num : nums){
            int currentLength = 1;
            int nextNum = num + 1;
            while(exploredMap.containsKey(nextNum) && exploredMap.get(nextNum) == false){
                currentLength++;
                exploredMap.put(nextNum , Boolean.TRUE);
                nextNum++;
            }
            int prevNum = num-1 ;
            while(exploredMap.containsKey(prevNum) && !exploredMap.get(prevNum)){
                currentLength++;
                exploredMap.put(prevNum , Boolean.TRUE);
                prevNum--;
            }
            longestLength = Math.max(longestLength , currentLength);
        }
        return longestLength;
    }
}