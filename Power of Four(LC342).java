class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        long max = Integer.MAX_VALUE + 1;
        return max % num == 0 && (num - 1) % 3 == 0;
    }
}