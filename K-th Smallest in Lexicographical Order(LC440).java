class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int step = helper(cur, cur + 1, n);
            if (step <= k) {
                cur++;
                k -= step;
            } else {
                cur *= 10;
                k--;
            }
        }
        return cur;
    }
    
    private int helper(long n1, long n2, int n) {
        int step = 0;
        while (n1 <= n) {
            step += Math.min(n2, n + 1) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return step;
    }
    
    
}