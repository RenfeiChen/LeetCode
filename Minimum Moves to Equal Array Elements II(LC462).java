class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, k = 0;
        if (n % 2 == 0) {
            k = (nums[n / 2 - 1] + nums[n / 2]) / 2;
        } else {
            k = nums[n / 2];
        }
        int result = 0;
        for (int num : nums) {
            result += Math.abs(num - k);
        }
        return result;
    } 
}