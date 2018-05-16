class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            helper(result, i, n);
        }
        return result;
    }
    
    private void helper(List<Integer> result, int now, int target) {
        if (now > target) {
            return;
        }
        result.add(now);
        for (int i = 0; i < 10; i++) {
            int next = now * 10 + i;
            if (next > target) {
                return;
            }
            helper(result, next, target);
        }
    }
}