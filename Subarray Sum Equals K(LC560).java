class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, result = 0;
        for (int num : nums) {
            map.put(-sum, map.getOrDefault(-sum , 0) + 1);
            sum += num;
            result += map.getOrDefault(k - sum, 0);
        }
        return result;
    }
}