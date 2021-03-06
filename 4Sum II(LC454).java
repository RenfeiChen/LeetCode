class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : C) {
            for (int d : D) {
                map.put(c + d, map.getOrDefault(c + d, 0) + 1);
            }
        }
        int result = 0;
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                if (map.containsKey(-sum)) {
                    result += map.get(-sum);
                }
            }
        }
        return result;
    }
}