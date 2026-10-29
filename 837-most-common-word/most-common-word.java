class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
       paragraph = paragraph.toLowerCase();
paragraph = paragraph.replaceAll("[^a-z]", " ");
        String[]words = paragraph.split("\\s+");

        HashSet<String> bannedSet = new HashSet<>();
        for(String word : banned) bannedSet.add(word);

        HashMap<String , Integer>map = new HashMap<>();
        for(String word : words){
            if(!bannedSet.contains(word)){
                map.put(word , map.getOrDefault(word,0)+1);
            }
        }
        String ans = "";
        int max = 0;
        for(String word : map.keySet()){
            if(map.get(word)>max){
                max = map.get(word);
                ans = word;
            }
        }return ans;
    }
}