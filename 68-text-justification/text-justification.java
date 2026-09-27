import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i, lineLen = 0;
            // Count how many words fit in this line
            while (j < words.length && lineLen + words[j].length() + (j - i) <= maxWidth) {
                lineLen += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder sb = new StringBuilder();

            // If last line OR only one word → left justify
            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) sb.append(" ");
            } else {
                // Distribute spaces evenly
                int spaces = (maxWidth - lineLen) / gaps;
                int extra = (maxWidth - lineLen) % gaps;

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        for (int s = 0; s < spaces; s++) sb.append(" ");
                        if (extra-- > 0) sb.append(" ");
                    }
                }
            }
            ans.add(sb.toString());
            i = j;
        }
        return ans;
    }
}
