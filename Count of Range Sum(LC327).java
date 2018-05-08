class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0 || lower > upper) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1, lower, upper);
    }
    
    private int helper(int[] nums, int start, int end, int lower, int upper) {
        if (start == end) {
            if (nums[start] >= lower && nums[end] <= upper) {
                return 1;
            } else {
                return 0;
            }
        }
        int mid = start + (end - start) / 2, ans = 0;
        long sum = 0;
        long[] prefix = new long[end - mid];
        for (int i = mid + 1; i <= end; i++) {
            sum += nums[i];
            prefix[i - mid - 1] = sum;
        }
        Arrays.sort(prefix);
        sum = 0;
        for (int i = mid; i >= start; i--) {
            sum += nums[i];
            ans += binarySearch(prefix, upper - sum + 1) - binarySearch(prefix, lower - sum);
        }
        return helper(nums, start, mid, lower, upper) + helper(nums, mid + 1, end, lower, upper) + ans;
    }
    
    private int binarySearch(long[] nums, long target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}