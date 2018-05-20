class Solution {
    public String removeKdigits(String str, int k) {
        if (str.length() == k) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        char[] num = str.toCharArray();
        k = num.length - k;
        stack.push(num[0]);
        for (int i = 1; i < num.length; i++) {
            if (num[i] >= stack.peek()) {
                if (stack.size() < k) {
                    stack.push(num[i]);
                }
            } else {
                while (!stack.empty() && num[i] < stack.peek() && num.length - i - 1 + stack.size() >= k) {
                    stack.pop();
                }
                stack.push(num[i]);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.append(stack.pop());
        }
        String ans = result.reverse().toString();
        int index = 0;
        while (index < ans.length() && ans.charAt(index) == '0') {
            index++;
        }
        if (index == ans.length()) {
            return "0";
        }
        return ans.substring(index);
    }
}