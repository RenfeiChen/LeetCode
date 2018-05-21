class Solution {
    public int splitArray(int[] nums, int m) {
        int[] sum = new int[nums.length + 1];
        int[][] dp = new int[nums.length + 1][m + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = i - 1; j < nums.length; j++) {
                if (i == 1) {
                    dp[j][i] = sum[j + 1] - sum[0];
                } else {
                    dp[j][i] = Integer.MAX_VALUE;
                    for (int k = Math.max(0, i - 2); k < j; k++) {
                        dp[j][i] = Math.min(dp[j][i], Math.max(dp[k][i - 1], sum[j + 1] - sum[k + 1]));
                    }
                }
            }
        }
        return dp[nums.length - 1][m];
    }
}