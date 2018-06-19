class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (!numStack.empty() && numStack.peek() < nums[i]) {
                numStack.pop();
                result[indexStack.pop()] = nums[i];
            }
            numStack.push(nums[i]);
            indexStack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            while (!numStack.empty() && numStack.peek() < nums[i]) {
                numStack.pop();
                result[indexStack.pop()] = nums[i];
            }
            numStack.push(nums[i]);
            indexStack.push(i);
        }
        return result;
    }
}