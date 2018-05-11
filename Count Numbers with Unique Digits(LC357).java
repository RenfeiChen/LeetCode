class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        return helper(n, new boolean[10], 0);
    }
    
    private int helper(int n, boolean[] used, int digit) {
        if (digit == n) {
            return 1;
        }
        int result = 1;
        for (int i = (digit == 0) ? 1 : 0; i < 10; i++) {
            if (!used[i]) {
                used[i] = true;
                result += helper(n, used, digit + 1);
                used[i] = false;
            }
        }
        return result;
    }
}