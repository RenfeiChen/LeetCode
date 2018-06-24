class Solution {
    public int findPairs(int[] nums, int k) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        if (k < 0) {
            return 0;
        }
        if (k == 0) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (int num : map.keySet()) {
                if (map.get(num) > 1) {
                    result++;
                }
            }
            return result;
        }
        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }
            if (set.contains(num - k)) {
                result++;
            }
            if (set.contains(num + k)) {
                result++;
            }
            set.add(num);
        }
        return result;
    }
}