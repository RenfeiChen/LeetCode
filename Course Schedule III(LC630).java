class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });
        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            pq.offer(course);
            if (time > course[1]) {
                time -= pq.poll()[0];
            }
        }
        return pq.size();
    }
}