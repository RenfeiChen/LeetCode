class Solution {
    public int lengthLongestPath(String strs) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int result = 0;
        for(String str : strs.split("\n")) {
            int level = str.lastIndexOf("\t") + 1;
            while (level + 1 < stack.size()) {
                stack.pop();
            }
            int len = stack.peek() + str.length() - level + 1; // remove "/t", add"/"
            stack.push(len);
            if (str.contains(".")) {
                result = Math.max(result, len - 1);
            }
        }
        return result;
    }
}