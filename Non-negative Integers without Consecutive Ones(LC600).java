class Solution {
    int[] sum;
    public int findIntegers(int num) {
        String s = Integer.toBinaryString(num);
        int n = s.length();
        int[][] dp = new int[n + 1][2];
        sum = new int[n + 1];
        dp[1][0] = 1;
        dp[1][1] = 1;
        sum[1] = 2;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
            sum[i] = dp[i][0] + dp[i][1];
        }
        return helper(0, 0, s) + helper(1, 0, s);
    }
    
    private int helper(int cur, int index, String s) {
        int num = s.charAt(index) - '0';
        if (s.length() - 1 == index) {
            if (num >= cur) {
                return 1;
            } else {
                return 0;
            }
        }
        if (cur > num) {
            return 0;
        } else if (cur == num) {
            return cur == 1 ? helper(0, index + 1, s) : helper(0, index + 1, s) + helper(1, index + 1, s);
        } else {
            return sum[s.length() - index - 1];
        }
    }
}