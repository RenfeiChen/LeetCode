class Solution {
    public int minPatches(int[] nums, int n) {
        long reach = 0;
        int i = 0, ans = 0;
        while (reach < n) {
            if (i < nums.length && nums[i] <= reach + 1) {
                reach += nums[i];
                i++;
            } else {
                reach += reach + 1;
                ans++;
            }
        }
        return ans;
    }
}