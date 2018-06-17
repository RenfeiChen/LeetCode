class Solution {
    public int findPoisonedDuration(int[] time, int d) {
        int start = -1, end = -2, result = 0;
        for (int t : time) {
            if (t <= end) {
                end = t + d - 1;
            } else {
                result += end - start + 1;
                start = t;
                end = t + d - 1;
            }
        }
        result += end - start + 1;
        return result;
    }
}