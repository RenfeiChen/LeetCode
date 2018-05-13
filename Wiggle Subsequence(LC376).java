class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int down = nums[0], up = nums[0], downL = 1, upL = 1;
        for (int num : nums) {
            if (num < down) {
                down = num;
            } else if (num > down) {
                if (upL < downL + 1) {
                    upL = downL + 1;
                    up = num;
                }
            }
            if (num < up) {
                if (downL < upL + 1) {
                    downL = upL + 1;
                    down = num;
                }
            } else {
                up = num;
            }
        }
        return Math.max(downL, upL);
    }
}