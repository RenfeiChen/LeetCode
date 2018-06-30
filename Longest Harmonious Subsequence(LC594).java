class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            int same = map.getOrDefault(num, 0), up = map.getOrDefault(num + 1, 0), down = map.getOrDefault(num - 1, 0);
            if (Math.max(up, down) != 0) {
                result = Math.max(result, Math.max(up, down) + same + 1);
            }
            map.put(num, same + 1);
        }
        return result;
    }
}