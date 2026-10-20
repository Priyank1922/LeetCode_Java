import java.util.*;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) divisors.add(n / i);
            }
        }

        long ans = 0;

        for (int k : divisors) {
            boolean possible = true;

            for (int start = 0; start < n; start += k) {
                if (!isRotation(nums, sorted, start, k)) {
                    possible = false;
                    break;
                }
            }

            if (possible) ans += k;
        }

        return (int) ans;
    }

    private boolean isRotation(int[] nums, int[] sorted, int start, int len) {
        if (len == 1) {
            return nums[start] == sorted[start];
        }

        int[] lps = new int[len];

        for (int i = 1, j = 0; i < len; ) {
            if (sorted[start + i] == sorted[start + j]) {
                lps[i++] = ++j;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                lps[i++] = 0;
            }
        }

        int j = 0;

        for (int i = 0; i < 2 * len - 1; i++) {
            int textVal = nums[start + (i % len)];

            while (j > 0 && textVal != sorted[start + j]) {
                j = lps[j - 1];
            }

            if (textVal == sorted[start + j]) {
                j++;

                if (j == len) {
                    return true;
                }
            }
        }

        return false;
    }
}