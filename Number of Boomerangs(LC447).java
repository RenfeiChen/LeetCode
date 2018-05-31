class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length, result = 0;
        if (n <= 2) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int dist = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (int num : map.values()) {
                result += num * (num - 1);
            }
            map.clear();
        }
        return result;
    }
}