class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        if (k < 0) {
            k = -k;
        }
        if (nums.length < 2) {
            return false;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0 && nums[i - 1] == 0) {
                return true;
            }
        }
        if (k == 0) {
            return false;
        }
        if (k == 1) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            sum = (sum + num) % k;
            if (set.contains(k - sum) || (sum == 0 && set.contains(0))) {
                return true;
            }
            int temp = (-sum + num) % k;
            if (temp < 0) {
                temp += k;
            }
            set.add(temp);
        }
        return false;
    }
}