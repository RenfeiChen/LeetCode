class Solution {
    public int kInversePairs(int n, int k) {
        final int MOD = 1000000007;
        int[][] dp = new int[n + 100][k + 100];
        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[2][2] = 0;
        for (int i = 3; i <= n; i++) {
            dp[i][0] = dp[i - 1][0];
            for (int j = 1; j <= k; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
                if (j - i >= 0) {
                    dp[i][j] = dp[i][j] - dp[i - 1][j - i];
                    if (dp[i][j] < 0) {
                        dp[i][j] += MOD;
                    }
                }
            }
        }
        return dp[n][k];
    }
}