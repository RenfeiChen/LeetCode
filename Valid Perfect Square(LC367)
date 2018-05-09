class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 0, right = num;
        if (num == 1) {
            return true;
        }
        while (left < right) {
            long mid = left + (right - left)  / 2;
            if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left * left == num;
    }
}