class Solution {
    public String reverseWords(String s) {
        String [] words = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(String word : words){
            StringBuilder temp = new StringBuilder(word);
            ans.append(temp.reverse().append(" "));
        }
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }
}