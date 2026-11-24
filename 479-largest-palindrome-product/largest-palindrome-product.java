class Solution {
    public int largestPalindrome(int n) {

        if (n == 1) return 9;

        long upper = (long) Math.pow(10, n) - 1;
        long lower = (long) Math.pow(10, n - 1);

        for (long left = upper; left >= lower; left--) {

            String s = String.valueOf(left);
            long palindrome = Long.parseLong(
                    s + new StringBuilder(s).reverse());

            for (long x = upper; x * x >= palindrome; x--) {

                if (palindrome % x == 0) {
                    long y = palindrome / x;

                    if (y >= lower && y <= upper) {
                        return (int) (palindrome % 1337);
                    }
                }
            }
        }

        return -1;
    }
}
