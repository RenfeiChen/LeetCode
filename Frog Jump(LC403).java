class Solution {
    public boolean canCross(int[] stones) {
        int target = stones[stones.length - 1];
        if (stones.length >= 2 && stones[1] > 1) {
            return false;
        }
        Set<Integer> stone = new HashSet<>();
        for (int i = 1; i < stones.length; i++) {
            if (i > 3 && stones[i] > 2 * stones[i - 1]) {
                return false;
            }
            stone.add(stones[i]);
        }
        return helper(1, 1, stone, target);
    }
    
    public boolean helper(int cur, int step, Set<Integer> stones, int target) {
        if (cur == target) {
            return true;
        }
        if (stones.contains(cur + step + 1) && helper(cur + step + 1, step + 1, stones, target)) {
            return true;
        }
        if (stones.contains(cur + step) && helper(cur + step, step, stones, target)) {
            return true;
        }
        if (step > 1 && stones.contains(cur + step - 1) && helper(cur + step - 1, step - 1, stones, target)) {
            return true;
        }
        return false;
    }
}