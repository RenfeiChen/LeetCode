class Solution {
    int[] parent;
    int[] size;
    public int findCircleNum(int[][] M) {
        int n = M.length;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (find(i) == i) {
                result++;
            }
        }
        return result;
    }
    
    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        parent[i] = find(parent[i]);
        return parent[i];
    }
    
    private void union(int i, int j) {
        int rootI = find(i), rootJ = find(j);
        if (size[rootI] < size[rootJ]) {
            parent[rootI] = rootJ;
            size[rootJ] += size[rootI];
        } else {
            parent[rootJ] = rootI;
            size[rootI] += size[rootJ];
        }
    }
}