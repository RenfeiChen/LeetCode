class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        Map<String, Boolean> map = new HashMap<>();
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) {
            return false;
        }
        if (desiredTotal <= 0) {
            return true;
        }
        return helper(maxChoosableInteger, desiredTotal, new boolean[maxChoosableInteger + 1], map);
    }
    
    private boolean helper(int num, int target, boolean[] used, Map<String, Boolean> map) {
        if (target <= 0) {
            return false;
        }
        String state = Arrays.toString(used);
        if (!map.containsKey(state)) {
            for (int i = 1; i <= num; i++) {
                if (!used[i]) {
                    used[i] = true;
                    if (!helper(num, target - i, used, map)) {
                        map.put(state, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            map.put(state, false);
        }
        return map.get(state);
    }
}