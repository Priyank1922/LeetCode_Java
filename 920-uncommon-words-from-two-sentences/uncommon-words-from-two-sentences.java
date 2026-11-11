class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : s1.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word : s2.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for (String word : map.keySet()) {
            if (map.get(word) == 1) {
                ans.add(word);
            }
        }
return ans.toArray(new String[0]);
    }
}