class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isSelf(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
    public boolean isSelf(int num) {
        int original = num;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 0 || original % digit != 0) {
                return false;
            }
num /= 10;  
        }

        return true;
    }
}