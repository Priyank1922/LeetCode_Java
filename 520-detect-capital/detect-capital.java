class Solution {
    public boolean detectCapitalUse(String word) {
        return word.equals(word.toUpperCase()) ||
               word.equals(word.toLowerCase()) ||
               word.equals(
                   Character.toUpperCase(word.charAt(0))
                   + word.substring(1).toLowerCase()
               );
    }
}