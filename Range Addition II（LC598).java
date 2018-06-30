class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int row = m, col = n;
        for (int[] d : ops) {
            row = Math.min(row, d[0]);
            col = Math.min(col, d[1]);
        }
        return row * col;
    }
}