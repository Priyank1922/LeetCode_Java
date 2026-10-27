class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int ans = 0;
        boolean oddFound = false;

        for (int count : map.values()) {
            if (count % 2 == 0) {
                ans += count;
            } else {
                ans += count - 1;
                oddFound = true;
            }
        }

        if (oddFound) {
            ans++;
        }

        return ans;
    }
}