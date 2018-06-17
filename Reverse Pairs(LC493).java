class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int MAX = Integer.MAX_VALUE / 2;
        int mid = left + (right - left) / 2;
        int leftPair = mergeSort(nums, left, mid), rightPair = mergeSort(nums, mid + 1, right);
        int i = left, j = mid + 1, p = mid + 1, result = leftPair + rightPair, idx = -1;
        int[] merge = new int[right - left + 1];
        while (i <= mid) {
            while (p <= right && nums[i] / 2.0 > nums[p]) {
                p++;
            }
            result += p - mid - 1;
            while (j <= right && nums[j] <= nums[i]) {
                idx++;
                merge[idx] = nums[j];
                j++;
            }
            idx++;
            merge[idx] = nums[i];
            i++;
        }
        while (j <= right) {
            idx++;
            merge[idx] = nums[j];
            j++;
        }
        for (int k = 0; k <= idx; k++) {
            nums[left + k] = merge[k];
        }
        return result;
    }
}