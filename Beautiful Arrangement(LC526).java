class Solution {
    int result = 0;
    public int countArrangement(int N) {
        if (N == 0) {
            return 0;
        }
        helper(N, new boolean[N + 1], 1);
        return result;
    }
    
    private void helper(int n, boolean[] used, int index) {
        if (index > n) {
            result++;
        }
        for (int i = 1; i <= n; i++) {
            if (!used[i] && (index % i == 0 || i % index == 0)) {
                used[i] = true;
                helper(n, used, index + 1);
                used[i] = false;
            }
        }
    }
}