class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (n * m != r * c) {
            return nums;
        }
        int[][] result = new int[r][c];
        int cur = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = nums[cur / m][cur % m];
                cur++;
            }
        }
        return result;
    }
}