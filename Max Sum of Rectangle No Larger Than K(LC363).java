class Solution {
    public int maxSumSubmatrix(int[][] matrix, int target) {
        int n = matrix.length, result = Integer.MIN_VALUE;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int[] sum = new int[m];
            for (int j = i; j >= 0; j--) {
                int total = 0;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int k = 0; k < m; k++) {
                    sum[k] += matrix[j][k];
                    total += sum[k];
                    Integer cur = set.ceiling(total - target);
                    if (cur != null) {
                        result = Math.max(result, total - cur);
                    }
                    set.add(total);
                }
            }
        }
        return result;
    }
}