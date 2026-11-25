import java.util.*;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int ans = Integer.MIN_VALUE;
        for (int left = 0; left < n; left++) {

            int[] rowSum = new int[m];
            for (int right = left; right < n; right++) {
                for (int row = 0; row < m; row++) {
                    rowSum[row] += matrix[row][right];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);

                int prefix = 0;

                for (int sum : rowSum) {
                    prefix += sum;

                    Integer target = set.ceiling(prefix - k);

                    if (target != null) {
                        ans = Math.max(ans, prefix - target);
                    }

                    set.add(prefix);
                }
            }
        }

        return ans;
    }
}