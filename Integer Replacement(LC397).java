class Solution {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        return helper(map, n);
    }
    
    private int helper(Map<Integer, Integer> map, int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int result = 0;
        if (n % 2 == 0) {
            result = helper(map, n / 2) + 1;
        } else {
            result = Math.min(helper(map, n + 1), helper(map, n - 1)) + 1;
        }
        map.put(n, result);
        return result;
    }
}