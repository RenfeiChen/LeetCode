class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length, result = 0;
        if (n < 3) {
            return 0;
        }
        int count = 2;
        for (int i = 2; i < n; i++) {
            if (nums[i] + nums[i - 2] == 2 * nums[i - 1]) {
                count++;
            } else {
                if (count < 3) {
                    count = 2;
                    continue;
                }
                result += (count - 1) *  (count - 2) / 2;
                count = 2;
            }
        }
        if (count >= 3) {
            result += (count - 1) *  (count - 2) / 2;
        }
        return result;
    }
}