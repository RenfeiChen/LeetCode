class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        for (int i = 0; i <= (int)Math.sqrt(c); i++) {
            int left = c - i * i, sqL = (int)Math.sqrt(left);
            if (sqL * sqL == left) {
                return true;
            }
        }
        return false;
    }
}