class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length, result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                count += ((num >> i) & 1);
            }
            result += count * (n - count);
        }
        return result;
    }
}