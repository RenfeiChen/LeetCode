/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = null;
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            TreeNode cur = new TreeNode(num);
            while (!stack.empty() && stack.peek().val < num) {
                cur.left = stack.pop();
            }
            if (!stack.empty()) {
                stack.peek().right = cur;
            }
            stack.push(cur);
            if (num > result) {
                root = cur;
                result = num;
            }
        }
        return root;
    }
}