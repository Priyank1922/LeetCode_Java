class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {

        if (n1 == 0) return 0;

        int len2 = s2.length();

        Map<Integer, int[]> map = new HashMap<>();

        int count1 = 0;
        int count2 = 0; 
        int index = 0;  

        while (count1 < n1) {
            for (int i = 0; i < s1.length(); i++) {

                if (s1.charAt(i) == s2.charAt(index)) {
                    index++;

                    if (index == len2) {
                        count2++;
                        index = 0;
                    }
                }
            }

            count1++;

            if (map.containsKey(index)) {

                int[] prev = map.get(index);

                int prevCount1 = prev[0];
                int prevCount2 = prev[1];

                int cycleS1 = count1 - prevCount1;
                int cycleS2 = count2 - prevCount2;

                int remaining = n1 - count1;

                int times = remaining / cycleS1;

                count1 += times * cycleS1;
                count2 += times * cycleS2;

            } else {
                map.put(index, new int[]{count1, count2});
            }
        }

        return count2 / n2;
    }
}