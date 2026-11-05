class Solution {

    private Boolean[][] dp;

    public boolean isMatch(String s, String p) {

        dp = new Boolean[s.length() + 1][p.length() + 1];

        return solve(0, 0, s, p);
    }

    private boolean solve(int i, int j, String s, String p) {

        if (dp[i][j] != null)
            return dp[i][j];

        if (j == p.length())
            return dp[i][j] = (i == s.length());

        boolean firstMatch =
                i < s.length() &&
                (s.charAt(i) == p.charAt(j)
                || p.charAt(j) == '.');

        if (j + 1 < p.length()
                && p.charAt(j + 1) == '*') {

            return dp[i][j] =
                    solve(i, j + 2, s, p)
                    ||
                    (firstMatch &&
                    solve(i + 1, j, s, p));
        }

        return dp[i][j] =
                firstMatch &&
                solve(i + 1, j + 1, s, p);
    }
}