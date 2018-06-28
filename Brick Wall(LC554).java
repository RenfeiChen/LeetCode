class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (List<Integer> l : wall) {
            int sum = 0;
            for (int i = 0; i < l.size() - 1; i++) {
                int num = l.get(i);
                sum += num;
                int count = map.getOrDefault(sum, 0) + 1;
                ans = Math.max(ans, count);
                map.put(sum, count);
            }
        }
        return wall.size() - ans;
    }
}