class Solution {
    public int magicalString(int n) {
        int[] nums = new int[n + 1];
        int result = 1;
        if (n == 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 2;
        int index = 1, i = 2;
        while (i < n - 1) {
            index++;
            if (nums[index] == 1) {
                nums[i + 1] = 3 - nums[i];
                i++;
                if (nums[i] == 1) {
                    result++;
                }
            } else {
                nums[i + 2] = 3 - nums[i];
                nums[i + 1] = nums[i + 2];
                i += 2;
                if (nums[i] == 1) {
                    if (i == n) {
                        result ++;
                    } else {
                        result += 2;
                    }
                }
            }
        }
        return result;
    }
}