class Solution {
    // int[] record;
    public String optimalDivision(int[] nums) {
        // double[][] dp = new double[nums.length][2];
        // record = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 0; j < 2; j++) {
        //         dp[i][j] = 0.0;
        //     }
        // }
        // return String.valueOf(helper(0, 0, dp, nums));
        if (nums == null || nums.length == 0) return "";
        if (nums.length == 1) {
            return nums[0] + "";
        }
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++) {
            if (i == 1) {
                sb.append("(").append(nums[i]).append("/");
            } else if (i == nums.length - 1) {
                sb.append(nums[i]).append(")");
            } else {
                sb.append(nums[i]).append("/");
            }
        }
        return sb.toString();
    }
    
    // private double helper(int start, int getMax, double[][] dp, int[] nums) {
    //     if (start >= nums.length) {
    //         return 1.0;
    //     }
    //     if (dp[start][getMax] != 0.0) {
    //         return dp[start][getMax];
    //     }
    //     double ans = 0;
    //     if (getMax == 0) {
    //         ans = Double.MIN_VALUE;
    //     } else {
    //         ans = Double.MAX_VALUE;
    //     }
    //     double div = 1.0 * nums[start] * nums[start];
    //     for (int i = start; i < nums.length; i++) {
    //         div = div / nums[i];
    //         if (getMax == 0) {
    //             double temp = div / helper(i + 1, 1, dp ,nums);
    //             if (ans <= temp) {
    //                 ans = temp;
    //                 record[start] = i + 1;
    //             }
    //         } else {
    //             double temp = div / helper(i + 1, 0, dp ,nums);
    //             if (ans >= temp) {
    //                 ans = temp;
    //                 record[start] = i + 1;
    //             }
    //         }
    //     }
    //     dp[start][getMax] = ans;
    //     return ans;
    // }
}