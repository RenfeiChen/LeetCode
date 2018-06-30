class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = new int[4][2];
        Set<Integer> set = new HashSet<>();
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        points[3] = p4;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                set.add(getDist(points[i], points[j]));
            }
        }
        return !set.contains(0) && set.size() == 2;
    }
    
    private int getDist(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}