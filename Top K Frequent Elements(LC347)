class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        if (n < k) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        if (map.keySet().size() < k) {
            return result;
        }
        List<Integer>[] times = new ArrayList[n + 1];
        for (Integer i : map.keySet()) {
            if (times[map.get(i)] == null) {
                times[map.get(i)] = new ArrayList<>();
            }
            times[map.get(i)].add(i);
        }
        for (int i = n; i >= 0; i--) {
            if (k == 0) {
                break;
            }
            if (times[i] != null) {
                for (Integer num : times[i]) {
                    if (k == 0) {
                        break;
                    }
                    result.add(num);
                    k--;
                }
            }
        }
        return result;
    }
}