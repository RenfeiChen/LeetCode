class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int num : nums) {
            min = num < min ? num : min;
            sum += num;
        }
        return sum - nums.length * min;
    }
}