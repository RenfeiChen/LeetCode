class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        if (matrix[0].length == 0) {
            return result;
        }
        int n = matrix.length, m = matrix[0].length;
        boolean[][] pacific = new boolean[n][m], atlantic = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(i, 0, matrix, Integer.MIN_VALUE, pacific);
            dfs(i, m - 1, matrix, Integer.MIN_VALUE, atlantic);
        }
        for (int j = 0; j < m; j++) {
            dfs(0, j, matrix, Integer.MIN_VALUE, pacific);
            dfs(n - 1, j, matrix, Integer.MIN_VALUE, atlantic);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }
    
    private void dfs(int i, int j, int[][] matrix, int height, boolean[][] used) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || used[i][j] || height > matrix[i][j]) {
            return;
        }
        used[i][j] = true;
        dfs(i - 1, j, matrix, matrix[i][j], used);
        dfs(i + 1, j, matrix, matrix[i][j], used);
        dfs(i, j - 1, matrix, matrix[i][j], used);
        dfs(i, j + 1, matrix, matrix[i][j], used);
    }
}