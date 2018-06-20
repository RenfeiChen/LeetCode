class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < n - i + 1; j++) {
                int k = j + i - 1;
                if (s.charAt(j) == s.charAt(k)) {
                    if (i == 2) {
                        dp[j][k] = 2;
                    } else {
                        dp[j][k] = 2 + dp[j + 1][k - 1];
                    }
                } else {
                    dp[j][k] = Math.max(dp[j + 1][k], dp[j][k - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}