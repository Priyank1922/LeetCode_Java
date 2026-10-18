class Solution {
    public String getPermutation(int n, int k) {

        List<Integer> nums = new ArrayList<>();
        int fact = 1;

        for (int i = 1; i < n; i++) {
            fact *= i;
            nums.add(i);
        }

        nums.add(n);

        k--; // convert to 0-based

        StringBuilder ans = new StringBuilder();

        while (true) {

            int index = k / fact;
            ans.append(nums.get(index));

            nums.remove(index);

            if (nums.size() == 0) {
                break;
            }

            k %= fact;
            fact /= nums.size();
        }

        return ans.toString();
    }
}