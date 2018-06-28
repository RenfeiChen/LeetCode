class Solution {
    public int arrayNesting(int[] nums) {
        int max = 1;
        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            int t = i, size = 1;
            while (nums[t] != i) {
                used[t] = true;
                size++;
                t = nums[t];
            }
            used[t] = true;
            max = Math.max(max, size);
        }
        return max;
    }
}