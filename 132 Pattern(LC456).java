class Solution {
    private class Pair {
        int min, max;
        Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack<>();
        for (int num : nums) {
            if (stack.empty()) {
                stack.push(new Pair(num, num));
            } else {
                Pair cur = stack.peek();
                if (num > cur.min) {
                    if (num < cur.max) {
                        return true;
                    } else if (num > cur.max) {
                        stack.pop();
                        cur.max = num;
                        while (!stack.empty() && stack.peek().max < num) {
                            stack.pop();
                        }
                        if (!stack.empty() && stack.peek().min < num) {
                            return true;
                        }
                        stack.push(cur);
                    }
                } else if (num < cur.min) {
                    stack.push(new Pair(num, num));
                }
                
            }
        }
        return false;
    }
}