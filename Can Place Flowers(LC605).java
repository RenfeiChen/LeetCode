class Solution {
    public boolean canPlaceFlowers(int[] nums, int n) {
        int index = 0;
        while (n > 0) {
            while (index < nums.length && !(nums[index] == 0 && (index == 0 || nums[index - 1] == 0) && (index == nums.length - 1 || nums[index + 1] == 0))) {
                index++;
            }
            if (index >= nums.length) {
                return false;
            }
            index += 2;
            n--;
        }
        return true;
    }
}