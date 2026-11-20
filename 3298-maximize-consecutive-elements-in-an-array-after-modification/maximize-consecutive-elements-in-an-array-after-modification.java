class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 1;

        for (int x : nums) {
            int prevX = dp.getOrDefault(x, 0);
            int prevXMinus1 = dp.getOrDefault(x - 1, 0);

            dp.put(x,
                Math.max(prevX, prevXMinus1 + 1));

            dp.put(x + 1,
                Math.max(dp.getOrDefault(x + 1, 0),
                         prevX + 1));

            ans = Math.max(ans,
                    Math.max(dp.get(x),
                             dp.get(x + 1)));
        }

        return ans;
    }
}