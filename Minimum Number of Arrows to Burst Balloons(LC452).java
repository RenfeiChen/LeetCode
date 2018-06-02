class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        Arrays.sort(points, new Comparator<int[]>() {
           public int compare (int[] a, int[] b) {
               return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
           } 
        });
        int minEnd = Integer.MIN_VALUE, maxEnd = -1, result = 0;
        for (int[] point : points) {
            if (point[0] <= minEnd) {
                minEnd = Math.min(minEnd, point[1]);
                maxEnd = Math.max(maxEnd, point[1]);
            } else {
                result++;
                minEnd = point[1];
                maxEnd = point[1];
            }
        }
        return result;
    }
}