class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0, f = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            f += i * nums[i];
        }
        int result = f;
        for (int i = 1; i < nums.length; i++) {
            f += sum - nums.length * nums[nums.length - i];
            result = Math.max(result, f);
        }
        return result;
    }
}