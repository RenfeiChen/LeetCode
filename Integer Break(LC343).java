class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        return dfs(dp, n);
    }
    
    private int dfs(int[] dp, int n) {
        if (dp[n] != 0) {
            return dp[n];
        }
        int result = 1;
        for (int i = 1; i < n; i++) {
            result = Math.max(result, i * Math.max(n - i, dfs(dp, n - i)));
        }
        dp[n] = result;
        return result;
    }
}