class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        int[] result = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
            int[] combined = merge(getMax(nums1, i), getMax(nums2, k - i));
            if (isGreater(combined, 0, result, 0)) {
                result = combined;
            }
        }
        return result;
    }
    
    private boolean isGreater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                return true;
            } else if (nums1[i] < nums2[j]) {
                return false;
            }
            i++;
            j++;
        }
        return i != nums1.length;
    }
    
    private int[] merge(int[] nums1, int[] nums2) {
        int i = 0, j = 0, r = 0;
        int[] ans = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (isGreater(nums1, i, nums2, j)) {
                ans[r] = nums1[i];
                i++;
            } else {
                ans[r] = nums2[j];
                j++;
            }
            r++;
        }
        while (i < nums1.length) {
            ans[r] = nums1[i];
            i++;
            r++;
        }
        while (j < nums2.length) {
            ans[r] = nums2[j];
            j++;
            r++;
        }
        return ans;
    }
    
    private int[] getMax(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) {
                ans[j] = nums[i];
                j++;
            }
        }
        return ans;
    }
}