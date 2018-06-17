class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        Map<Integer, Integer> pre = new HashMap<>();
        pre.put(0, 1);
        for (int i = 0; i < nums.length - 1; i++) {
            Map<Integer, Integer> tempSet = new HashMap<>();
            for (int key : pre.keySet()) {
                tempSet.put(key + nums[i], tempSet.getOrDefault(key + nums[i], 0) + pre.get(key));
                tempSet.put(key - nums[i], tempSet.getOrDefault(key - nums[i], 0) + pre.get(key));
            }
            pre = tempSet;
        }
        return pre.getOrDefault(S - nums[nums.length - 1], 0) + pre.getOrDefault(S + nums[nums.length - 1], 0);
    }
}