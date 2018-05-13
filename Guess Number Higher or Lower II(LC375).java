class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return helper(1, n, dp);
    }
    
    private int helper(int left, int right, int[][] dp) {
        if (left >= right) {
            return 0;
        }
        if (dp[left][right] != 0) {
            return dp[left][right];
        }
        int result = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            int cur = i + Math.max(helper(left, i - 1, dp), helper(i + 1, right, dp));
            result = Math.min(result, cur);
        }
        dp[left][right] = result;
        return result;
    }
}