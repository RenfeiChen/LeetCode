class Solution {
    int result = 0;
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid);
                }
            }
        }
        return result;
    }
    
    private void dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == 2) {
            return;
        }
        if (i == 0 || grid[i - 1][j] == 0) {
            result++;
        }
        if (i == grid.length - 1 || grid[i + 1][j] == 0) {
            result++;
        }
        if (j == 0 || grid[i][j - 1] == 0) {
            result++;
        }
        if (j == grid[0].length - 1 || grid[i][j + 1] == 0) {
            result++;
        }
        grid[i][j] = 2;
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }
}