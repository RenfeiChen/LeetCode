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
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return result;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        result = Math.max(result, left + right);
        return Math.max(left, right);
    }
}