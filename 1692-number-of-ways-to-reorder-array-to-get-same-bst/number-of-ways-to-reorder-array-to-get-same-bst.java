class Solution {

    private static final long MOD = 1_000_000_007L;
    private long[][] comb;

    public int numOfWays(int[] nums) {

        int n = nums.length;

        // Precompute nCr
        comb = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] =
                        (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        List<Integer> arr = new ArrayList<>();

        for (int num : nums) {
            arr.add(num);
        }

        long ans = (countWays(arr) - 1 + MOD) % MOD;

        return (int) ans;
    }

    private long countWays(List<Integer> nums) {

        if (nums.size() <= 2) {
            return 1;
        }

        int root = nums.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {

            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }

        long leftWays = countWays(left);
        long rightWays = countWays(right);

        int leftSize = left.size();
        int rightSize = right.size();

        long ways =
                comb[leftSize + rightSize][leftSize];

        return (((ways * leftWays) % MOD) * rightWays) % MOD;
    }
}