class Solution {
    int[][] d = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    result[i][j] = Integer.MAX_VALUE;
                } else {
                    result[i][j] = 0;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = cur[0] + d[i][0], nextC = cur[1] + d[i][1];
                if (nextR < 0 || nextR >= matrix.length || nextC < 0 || nextC >= matrix[0].length || result[nextR][nextC] <= result[cur[0]][cur[1]] + 1) {
                    continue;
                }
                result[nextR][nextC] = result[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{nextR, nextC});
            }
        }
        return result;
    }
}