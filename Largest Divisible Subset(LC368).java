class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length, size = 0, end = 0;
        int[] dp = new int[n + 1];
        int[] chain = new int[n + 1];
        if (n == 0) {
            return result;
        }
        Arrays.sort(nums);
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int max = 1;
            chain[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && max < dp[j] + 1) {
                    max = dp[j] + 1;
                    chain[i] = j;
                }
            }
            dp[i] = max;
            if (max > size) {
                size = max;
                end = i;
            }
        }
        while (chain[end] != end) {
            result.add(0, nums[end]);
            end = chain[end];
        }
        result.add(0, nums[end]);
        return result;
    }
}