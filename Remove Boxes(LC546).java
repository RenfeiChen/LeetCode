class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return helper(boxes, 0, n - 1, 0, dp);
    }
    
    private int helper(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j][k]  > 0) {
            return dp[i][j][k];
        }
        while (i < j && boxes[i] == boxes[i + 1]) {
            k++;
            i++;
        }
        int ans = (k + 1) * (k + 1) + helper(boxes, i + 1, j, 0, dp);
        for (int t = i + 1; t <= j; t++) {
            if (boxes[t] == boxes[i]) {
                ans = Math.max(ans, helper(boxes, i + 1, t - 1, 0, dp) + helper(boxes, t, j, k + 1, dp));
            }
        }
        dp[i][j][k] = ans;
        return ans;
    }
}