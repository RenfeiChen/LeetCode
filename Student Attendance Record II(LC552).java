class Solution {
    public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][][] dp = new int[n + 1][2][3];
        dp[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    int cur = dp[i - 1][j][2]; // this position insert P
                    if (j == 1) {
                        cur = (cur + dp[i - 1][0][2]) % MOD; // this position insert A
                    }
                    if (k > 0) {
                        cur = (cur + dp[i - 1][j][k - 1]) % MOD; // if k = 0 means that we can only insert P, if k > 0 so we can add 
                    }
                    dp[i][j][k] = cur;
                }
            }
        }
        return dp[n][1][2];
    }
}