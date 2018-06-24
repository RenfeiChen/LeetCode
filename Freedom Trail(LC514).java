class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = key.length(), m = ring.length();
        int[][] dp = new int[n + 1][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int need = Math.min(m - Math.abs(k - j), Math.abs(k - j)) + 1;
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][k] + need);
                    }
                }
            }
        }
        return dp[0][0];
    }
}