class Solution {
    public int minInsertions(String s) {
        int res = 0;   
        int need = 0; 

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (need % 2 == 1) {
                    res++;
                    need--; 
                }
                need += 2; 
            } else { 
                need--;
                if (need < 0) {
                    res++;
                    need = 1; 
                }
            }
        }

        return res + need; 
    }
}
