class Solution {
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int count = 0;
        boolean[] used = new boolean[nums.length];
        System.out.println(sum / 4);
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (canForm(nums, i, used, sum / 4)) {
                    count++;
                    if (count == 3) {
                        return true;
                    }
                    // for (int j = 0; j < nums.length; j++) {
                    //     if (used[j]) {
                    //         System.out.print(nums[j] + " ");
                    //     }
                    // }
                    // System.out.println();
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    
    private boolean canForm(int[] nums, int start, boolean[] used, int target) {
        if (target == 0) {
            return true;
        }
        if (start == nums.length || target < 0) {
            return false;
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            if (canForm(nums, i + 1, used, target - nums[i])) {
                return true;
            }
            used[i] = false;
        }
        return false;
    }
}