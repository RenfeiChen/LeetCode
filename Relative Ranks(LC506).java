class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }
        Arrays.sort(pair, new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
               return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
           } 
        });
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            int index = pair[i][1];
            if (i == 0) {
                result[index] = "Gold Medal";
            } else if (i == 1) {
                result[index] = "Silver Medal";
            } else if (i == 2) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = "" + (i + 1);
            }
        }
        return result;
    }
}