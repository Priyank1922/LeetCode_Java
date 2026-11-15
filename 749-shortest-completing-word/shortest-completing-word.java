class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] need = new int[26];

        for (char ch : licensePlate.toCharArray()) {
            if (Character.isLetter(ch)) {
                need[Character.toLowerCase(ch) - 'a']++;
            }
        }
        String ans = null;
        for (String word : words) {
            if (isCompleting(word, need)) {
                if (ans == null || word.length() < ans.length()) {
                    ans = word;
                }
            }
        }
        return ans;
    }



    private boolean isCompleting(String word, int[] need) {
        int[] freq = new int[26];

        for (char ch : word.toCharArray()) freq[ch - 'a']++;
 for (int i = 0; i < 26; i++) {
            if (freq[i] < need[i]) return false;
        }
return true;
    }
}