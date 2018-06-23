class Solution {
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        int sum = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(-sum)) {
                result = Math.max(result, i - map.get(-sum) + 1);
            }
            if (!map.containsKey(-sum + nums[i])) {
                map.put(-sum + nums[i], i);
            }
        }
        return result;
    }
}