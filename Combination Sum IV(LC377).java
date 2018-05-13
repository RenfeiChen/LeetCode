class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int i = 0; i <= target; i++) {
            dp[i] = -1;
        }
        dp[0] = 1;
        return helper(nums, target, dp);
    }
    
    private int helper(int [] nums, int target, int[] dp) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                sum += helper(nums, target - nums[i], dp);
            }
        }
        dp[target] = sum;
        return sum;
    }
    
}