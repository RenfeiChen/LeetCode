class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int[] dp = new int[n];
        int size = 0;
        for (int i = 0; i < n; i++) {
            int left = 0, right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] < pairs[i][0]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == size) {
                dp[left] = pairs[i][1];
                size++;
            } else {
                dp[left] = Math.min(dp[left], pairs[i][1]);
            }
        }
        return size;
    }
}