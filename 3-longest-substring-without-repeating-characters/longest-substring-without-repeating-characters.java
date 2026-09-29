class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;

        for(int right = 0; right < n ; right ++){
            if(!map.containsKey(s.charAt(right)) || map.get(s.charAt(right))<left){
                map.put(s.charAt(right), right);
                maxLen = Math.max(maxLen , right-left+1);
            }else{
                left = map.get(s.charAt(right))+1;
                map.put(s.charAt(right) , right);
            }
        }
        return maxLen;
    }
}