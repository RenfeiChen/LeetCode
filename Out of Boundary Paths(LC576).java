class Solution {
    public int findPaths(int m, int n, int N, int I, int J) {
        int[][][] dp = new int[m][n][N + 1];
        dp[I][J][0] = 1;
        int[][] dir = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        for (int k = 1; k < N; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int t = 0; t < 4; t++) {
                        int row = i + dir[t][0], col = j + dir[t][1];
                        if (row < 0 || row >= m || col < 0 || col >= n) {
                            continue;
                        }
                        dp[i][j][k] = (dp[i][j][k] + dp[row][col][k - 1]) % 1000000007;
                    }
                }
            }
        }
        int result = 0;
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < m; i++) {
                result = (result + dp[i][0][k]) % 1000000007;
            }
            for (int i = 0; i < m; i++) {
                result = (result + dp[i][n - 1][k]) % 1000000007;
            }
            for (int j = 0; j < n; j++) {
                result = (result + dp[0][j][k]) % 1000000007;
            }
            for (int j = 0; j < n; j++) {
                result = (result + dp[m - 1][j][k]) % 1000000007;
            }
        }
        return result;
    }
}