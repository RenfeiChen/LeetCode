class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            int index = Math.abs(num);
            if (nums[index - 1] < 0) {
                result.add(index);
            } else {
                nums[index - 1] = -nums[index - 1];
            }
        }
        return result;
    }
}