class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;

        for (int i = left; i <= right; i++) {
            int bits = Integer.bitCount(i);

            if (bits == 2 || bits == 3 || bits == 5 || bits == 7 ||
                bits == 11 || bits == 13 || bits == 17 || bits == 19) {
                ans++;
            }
        }

        return ans;
    }
}