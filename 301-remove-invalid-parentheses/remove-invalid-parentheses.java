import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();
        int[] invalid = getInvalidCounts(s);
        dfs(s, 0, invalid[0], invalid[1], new StringBuilder(), result);
        return new ArrayList<>(result);
    }

    private void dfs(String s, int index, int extraLeft, int extraRight,
                     StringBuilder path, Set<String> result) {
        if (index == s.length()) {
            if (extraLeft == 0 && extraRight == 0 && isValid(path.toString())) {
                result.add(path.toString());
            }
            return;
        }

        char c = s.charAt(index);
        int len = path.length();

        if (c == '(') {

            if (extraLeft > 0) {
                dfs(s, index + 1, extraLeft - 1, extraRight, path, result);
            }

            path.append(c);
            dfs(s, index + 1, extraLeft, extraRight, path, result);
            path.setLength(len);
        } else if (c == ')') {

            if (extraRight > 0) {
                dfs(s, index + 1, extraLeft, extraRight - 1, path, result);
            }

            path.append(c);
            dfs(s, index + 1, extraLeft, extraRight, path, result);
            path.setLength(len);
        } else {
            
            path.append(c);
            dfs(s, index + 1, extraLeft, extraRight, path, result);
            path.setLength(len);
        }
    }

    private int[] getInvalidCounts(String s) {
        int extraLeft = 0, extraRight = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                extraLeft++;
            } else if (c == ')') {
                if (extraLeft > 0) {
                    extraLeft--;
                } else {
                    extraRight++;
                }
            }
        }
        return new int[]{extraLeft, extraRight};
    }

    private boolean isValid(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}
