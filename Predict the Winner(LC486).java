class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
            dp[i][i] = nums[i];
        }
        return helper(0, nums.length - 1, dp, nums) >= 0 ? true : false;
    }
    
    private int helper(int left, int right, int[][] dp, int[] nums) {
        if (dp[left][right] != Integer.MIN_VALUE){
            return dp[left][right];
        }
        int pickHead = nums[left] - helper(left + 1, right, dp, nums);
        int pickTail = nums[right] - helper(left, right - 1, dp, nums);
        dp[left][right] = Math.max(pickHead, pickTail);
        return dp[left][right];
    }
}