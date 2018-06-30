class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length, result = 0;
        if (n < 3) {
            return 0;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int end = i + 1;
            for (int j = i + 1; j < n - 1; j++) {
                while (end < n - 1 && nums[end + 1] < nums[j] + nums[i]) {
                    end++;
                }
                result += end - j;
            }
        }
        return result;
    }
}